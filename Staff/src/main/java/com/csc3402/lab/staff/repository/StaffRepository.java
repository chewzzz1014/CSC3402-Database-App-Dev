package com.csc3402.lab.staff.repository;
import com.csc3402.lab.staff.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.csc3402.lab.staff.model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query(value = "SELECT * FROM staff WHERE staff_id = :id", nativeQuery = true)
    Staff findStaffById(@Param("id") int id);
}
