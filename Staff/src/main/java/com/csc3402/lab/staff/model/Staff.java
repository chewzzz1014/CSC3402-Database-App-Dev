package com.csc3402.lab.staff.model;
import jakarta.persistence.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    // constructor
    public Staff() {
    }

    // getters
    public Integer getStaffId() {
        return staffId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }


    // setters
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    // toString
    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                '}';
    }

}
