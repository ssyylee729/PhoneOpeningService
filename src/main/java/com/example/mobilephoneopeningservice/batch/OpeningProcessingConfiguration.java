package com.example.mobilephoneopeningservice.batch;

import com.example.mobilephoneopeningservice.domain.Opening;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Slf4j
public class OpeningProcessingConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final EntityManagerFactory entityManagerFactory;


    public OpeningProcessingConfiguration(JobBuilderFactory jobBuilderFactory,
                                          StepBuilderFactory stepBuilderFactory, DataSource dataSource, EntityManagerFactory entityManagerFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    public Job openingProcessingJob() throws Exception {
        return jobBuilderFactory.get("openingProcessingJob")
                .incrementer(new RunIdIncrementer())
                .start(this.openingProcessingStep())
                .build();
    }

    @Bean
    public Step openingProcessingStep() throws Exception {
        return stepBuilderFactory.get("openingProcessingStep")
                .<Opening, Opening> chunk(10)
                .reader(jpaCursorItemReader())
                .processor(itemProcessor())
                .writer(jdbcOpeningItemWriter())
                .build();
    }

    private ItemProcessor<Opening,Opening> itemProcessor() {
        return item -> {
            log.info("processor, item {}", item.toString());

            return item;
        };
    }
    private JpaCursorItemReader<Opening> jpaCursorItemReader() throws Exception {
        JpaCursorItemReader<Opening> itemReader = new JpaCursorItemReaderBuilder<Opening>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select o from Opening o") //native query가 아닌 jpql query
                .build();
        itemReader.afterPropertiesSet();
        return  itemReader;
    }
    private JdbcCursorItemReader<Opening> jdbcOpeningItemReader() throws Exception {
        log.info("in jdbcOpeningItemReader");
        JdbcCursorItemReader<Opening> itemReader = new JdbcCursorItemReaderBuilder<Opening>()
                .name("jdbcOpeningItemReader")
                .dataSource(dataSource)
                .sql("select * from opening where status = 0")
                .rowMapper((result, rowNum) -> new Opening(result.getString("opening_id"))
//
//                        Opening.builder()
//                                .openingId(result.getString("opening_id"))
//                                .status(result.getInt("status"))
//                                .build()
                )
                .build();
        itemReader.afterPropertiesSet();
        return itemReader;

    }
    private ItemWriter<Opening> jdbcOpeningItemWriter() {
        JdbcBatchItemWriter<Opening> itemWriter = new JdbcBatchItemWriterBuilder<Opening>()
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                //Opening class를 파라미터로 자동 설정해줌.
                .sql("update opening set status = 2 where opening_id = :openingId")
                .build();
        itemWriter.afterPropertiesSet();

        return itemWriter;
    }
}
