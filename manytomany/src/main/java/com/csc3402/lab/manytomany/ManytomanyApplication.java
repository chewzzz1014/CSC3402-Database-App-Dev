package com.csc3402.lab.manytomany;

import com.csc3402.lab.manytomany.model.Course;
import com.csc3402.lab.manytomany.model.Student;
import com.csc3402.lab.manytomany.repositories.CourseRepository;
import com.csc3402.lab.manytomany.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ManytomanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManytomanyApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            // create a students
            Student student1 = new Student("Ahmad Murad", 24, "8th");
            Student student2 = new Student("Ah Chong", 21, "6th");
            Student student3 = new Student("Ramasamy",23,"5th");

            // save the student
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);


            // create three courses
            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
            Course course2 = new Course("Database Systems", "DB", 8, 800);
            Course course3 = new Course("Web Basics", "WB", 10, 0);

            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student 1, 2 & 3
            student1.getCourses().addAll(Arrays.asList(course1, course2, course3));
            student2.getCourses().addAll(Arrays.asList(course2,course3));
            student3.getCourses().addAll(Arrays.asList(course1));

            // update the student 1, 2 and 3
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
        };
    }
}