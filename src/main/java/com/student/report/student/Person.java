package com.student.report.student;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Person implements Serializable {

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    private String gender;

    @NonNull
    @Column(name = "email_id")
    private String email;

    @NonNull
    @Column(name = "phone_number")
    private Long phone;

    @NonNull
    private String address;

    @NonNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NonNull
    @Column(name = "fulltime_status")
    private Boolean fullTime;

    @NonNull
    @Column(name = "enrollment_status")
    private String enrollmentStatus;

    @NonNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
