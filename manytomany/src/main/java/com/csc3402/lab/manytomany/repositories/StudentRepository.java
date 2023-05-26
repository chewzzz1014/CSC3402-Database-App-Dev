package com.csc3402.lab.manytomany.repositories;

import com.csc3402.lab.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
