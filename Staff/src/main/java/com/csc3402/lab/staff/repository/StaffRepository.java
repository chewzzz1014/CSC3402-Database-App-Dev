package com.csc3402.lab.staff.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.csc3402.lab.staff.model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
