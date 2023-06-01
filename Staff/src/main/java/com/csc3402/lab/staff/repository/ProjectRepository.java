package com.csc3402.lab.staff.repository;

import jakarta.persistence.*;
import com.csc3402.lab.staff.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

    @Query(value = "SELECT * FROM project WHERE project_id = :id", nativeQuery = true)
    Project findProjectById(@Param("id") int id);
}
