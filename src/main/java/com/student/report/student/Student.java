package com.student.report.student;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Person person;

    @NonNull
    @Column(name = "degree")
    private String degree;

    @NonNull
    @Column(name = "academic_year")
    private int academicYear;
}