package com.example.spdataintro.bootstrap;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.spdataintro.repos.*;
import com.example.spdataintro.model.*;
import java.util.List;

@Component
public class DataInit {
    
    @Bean
    CommandLineRunner runner(BookRepo bookRepo) {
        return args -> {
            var b1 = new Book("Domain Driven Design", "123", "RandomHouse");
            var b2 = new Book("Spring In Action", "57567", "Oriely");
            bookRepo.saveAll(List.of(b1,b2));
            
           bookRepo.findAll().forEach(
               book -> {
                  System.out.println("Book Id: " + book.getId());
                  System.out.println("Book Title: " + book.getTitle());
               }
            );
        };
    }
}