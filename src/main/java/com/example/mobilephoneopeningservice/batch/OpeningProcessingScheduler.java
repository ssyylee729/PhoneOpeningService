package com.example.mobilephoneopeningservice.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OpeningProcessingScheduler {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Job job;

    @Scheduled(cron = "0 0 8 * * *")
//    @Scheduled(cron = "*/10 * * * * *")
    public void perform() throws Exception
    {
        job = (Job) applicationContext.getBean("openingProcessingJob");
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}