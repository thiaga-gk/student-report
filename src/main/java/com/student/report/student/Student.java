package com.student.report.student;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String email;

    @Column(name = "phone")
    private long phone;

    @Column(name = "address")
    private String address;

    @Column(name = "degree")
    private String degree;

    @Column(name = "academic_year")
    private int academicYear;
}