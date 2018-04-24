package com.student.report.student;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person implements Serializable {

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    private String gender;

    @Email
    @NotBlank
    @Column(name = "email_id")
    private String email;

    @NotBlank
    @Column(name = "phone_number")
    private Long phone;

    @NotBlank
    private String address;

    @NotBlank
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank
    @Column(name = "fulltime_status")
    private Boolean fullTime;

    @NotBlank
    @Column(name = "enrollment_status")
    private String enrollmentStatus;

    @NotBlank
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
