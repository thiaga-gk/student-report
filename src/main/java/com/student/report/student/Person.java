package com.student.report.student;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class Person implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    @Column(name = "email_id")
    private String email;

    @Column(name = "phone_number")
    private Long phone;

    private String address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "fulltime_status")
    private Boolean fullTime;

    @Column(name = "enrollment_status")
    private String enrollmentStatus;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
