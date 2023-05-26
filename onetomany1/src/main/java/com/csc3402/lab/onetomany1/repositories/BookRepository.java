package com.csc3402.lab.onetomany1.repositories;

import com.csc3402.lab.onetomany1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
}
