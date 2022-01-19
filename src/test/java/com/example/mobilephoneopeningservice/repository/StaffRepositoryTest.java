package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Staff;
import com.example.mobilephoneopeningservice.domain.StaffAuthority;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StaffRepositoryTest {

    @Autowired
    StaffRepository staffRepository;
    @Test
    @Order(1)
    void createTest() {
        /* Authority 생성 */
        Set<StaffAuthority> authorities = new HashSet<>();
        StaffAuthority authority = new StaffAuthority();
        authority.setAuthority("USER");
        authorities.add(authority);
        

        /* 패스워드 인코더 활용하여 패스워드 인코딩하여 DB 저장 */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Staff staff = Staff.builder()
                .staffId("testUser")
                .password(encoder.encode("1111"))
                .authorities(authorities)
                .name("testPerson")
                .phoneNumber("010-0000-0000")
                .build();

//        log.info("before create : {}", staff);

        Staff staff1 = staffRepository.save(staff);

//        log.info("after create : {}", staff1);

        Assertions.assertEquals(staff.getStaffId(), staff1.getStaffId());
    }
    @Test
    void staffCrud(){

    }
}