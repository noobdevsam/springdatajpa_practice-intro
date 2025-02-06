package com.example.spdataintro;

import com.example.spdataintro.repos.BookRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.example.spdataintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MysqlIntegrationTest {
    
    @Autowired
    BookRepo bkRepo;

    @Test
    void jpatest_one_transaction() {
        long countBefore = bkRepo.count();
        assertThat(countBefore).isEqualTo(2);
    }
}

/*
Here, @ActiveProfiles is used to select a different profile only for this test
 class.
 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) is
 preventing h2-db to get auto configured.
*/