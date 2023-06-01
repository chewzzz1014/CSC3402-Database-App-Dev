package com.csc3402.lab.staff.model;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Project {

    public Project() {
    }

    public Project(Integer projectId, String projName, Integer cost, Set<StaffProject> staffProjects) {
        this.projectId = projectId;
        this.projName = projName;
        this.cost = cost;
        this.staffProjects = staffProjects;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_Id")
    private Integer projectId;

    @Column(name = "project_name")
    private String projName;

    @Column(name = "cost")
    private Integer cost;

    @OneToMany(mappedBy = "project")
    private Set<StaffProject> staffProjects = new HashSet<>();

    public Integer getProjectId() {
        return projectId;
    }

    public String getProjName() {
        return projName;
    }

    public Integer getCost() {
        return cost;
    }

    public Set<StaffProject> getStaffProjects() {
        return staffProjects;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setStaffProjects(Set<StaffProject> staffProjects) {
        this.staffProjects = staffProjects;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projName='" + projName + '\'' +
                ", cost=" + cost +
                ", staffProjects=" + staffProjects +
                '}';
    }
}
