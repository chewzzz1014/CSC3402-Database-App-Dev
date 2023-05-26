package com.csc3402.lab.onetomany1.repositories;

import com.csc3402.lab.onetomany1.model.Book;
import com.csc3402.lab.onetomany1.model.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}
