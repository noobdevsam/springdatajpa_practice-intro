package com.example.spdataintro;

import com.example.spdataintro.model.Book;
import com.example.spdataintro.repos.BookRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.spdataintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SdjpaTests {
    
    @Autowired
    BookRepo bkRepo;

    @Test
    @Commit
    @Order(1)
    void jpatest_one() {
        long countBefore = bkRepo.count();
        assertThat(countBefore).isEqualTo(2);
        
        bkRepo.save(new Book("My Book", "4564", "SSSssfdfs"));
        
        long countAfter = bkRepo.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void jpatest_one_transaction() {
        long countBefore = bkRepo.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
