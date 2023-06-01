package com.csc3402.lab.staff.model;

import jakarta.persistence.*;

@Entity
public class StaffProject {

    @EmbeddedId
    private StaffProjectId id;

    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staff_Id")
    private Staff staff;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "project_Id")
    private Project project;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "role")
    private String role;

    public StaffProject() {
    }

    public StaffProject(Staff staff, Project project, String startDate, String endDate,
                        String role) {
        this.id = new StaffProjectId(staff.getStaffId(),project.getProjectId());
        this.staff = staff;
        this.project = project;
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
    }

    public StaffProjectId getId() {
        return id;
    }

    public void setId(StaffProjectId id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }



    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "StaffProject{" +
                "id=" + id +
                ", staff=" + staff +
                ", project=" + project +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
