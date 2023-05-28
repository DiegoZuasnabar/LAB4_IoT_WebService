package com.example.clase7ws.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id", nullable = false, length = 10)
    private String id;

    @Column(name = "job_title", nullable = false, length = 35)
    private String jobTitle;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return id != null && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}