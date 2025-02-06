package com.example.spdataintro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spdataintro.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {}