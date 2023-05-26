package com.csc3402.lab.onetomany1;

import com.csc3402.lab.onetomany1.model.Book;
import com.csc3402.lab.onetomany1.model.Page;
import com.csc3402.lab.onetomany1.repositories.BookRepository;
import com.csc3402.lab.onetomany1.repositories.PageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Onetomany1Application {

	public static void main(String[] args) {
		SpringApplication.run(Onetomany1Application.class, args);
	}

	@Bean
	public CommandLineRunner mappingOneToMany(BookRepository bookRepository, PageRepository
			pageRepository){
		return args -> {

			//create 2 new books
			Book book_Hibernate = new Book("JAVA PERSISTENCE WITH HIBERNATE", "Gavin King",
					"9781617290459");
			Book book_SpringMVC = new Book("Spring MVC Beginners Guide", "Amuthan Ganeshan",
					"978-1-78588-063-6");

			//save the books
			bookRepository.save(book_Hibernate);
			bookRepository.save(book_SpringMVC);

			// Create and save new pages for book_Hibernatre
			pageRepository.save(new Page(1, "Understanding object/relational persistence",
					"Getting Started with ORM", book_Hibernate));
			pageRepository.save(new Page(65, "Mapping entities with identity", "Mapping Strategies", book_Hibernate));
			pageRepository.save(new Page(229, "Transactional Data Processing", "Managing Data", book_Hibernate));

			// Create and save new pages for book_SpringMVC
			pageRepository.save(new Page(38, "Dispathcher servlet", "Spring MVC Architecture", book_SpringMVC));
			pageRepository.save(new Page(65, "Understanding request parameters", "Control Your Store with Controllers", book_SpringMVC));
			pageRepository.save(new Page(175, "Using Spring Security", "Incorporating Spring Security", book_SpringMVC));
		};
	}

}
