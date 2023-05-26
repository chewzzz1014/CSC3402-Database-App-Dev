package com.csc3402.lab.manytomany.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(String title, String abbreviation, int modules, double fee) {
        this.title = title;
        this.abbreviation = abbreviation;
        this.modules = modules;
        this.fee = fee;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getModules() {
        return modules;
    }

    public double getFee() {
        return fee;
    }

    public Set<Student> getStudents() {
        return students;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    // toString

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", modules=" + modules +
                ", fee=" + fee +
                ", students=" + students +
                '}';
    }
}
