package com.csc3402.lab.staff.repository;

import jakarta.persistence.*;
import com.csc3402.lab.staff.model.StaffProjectId;
import com.csc3402.lab.staff.model.StaffProject;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StaffProjectRepository extends JpaRepository<StaffProject, StaffProjectId> {
    @Query(value = "SELECT * FROM staff_project where staff_id = :id", nativeQuery = true)
    List<StaffProject> findStaffProjectByStaffId(@Param("id") int id);
}
