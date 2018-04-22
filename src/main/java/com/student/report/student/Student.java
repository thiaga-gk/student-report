package com.student.report.student;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Person person;

    @Column(name = "degree")
    private String degree;

    @Column(name = "academic_year")
    private int academicYear;
}