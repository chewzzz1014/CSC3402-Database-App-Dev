package com.csc3402.lab.staff.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StaffProjectId implements Serializable {

    @Column(name = "staff_Id")
    private Integer staffId;

    @Column(name = "project_Id")
    private Integer projectId;

    public StaffProjectId() {
    }

    public StaffProjectId(Integer staffId, Integer projectId) {
        this.staffId = staffId;
        this.projectId = projectId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffProjectId that = (StaffProjectId) o;
        return Objects.equals(staffId, that.staffId) && Objects.equals(projectId,
                that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, projectId);
    }
}
