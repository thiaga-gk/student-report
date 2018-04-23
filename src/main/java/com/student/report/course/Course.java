package com.student.report.course;

import com.student.report.Staff.Staff;
import com.student.report.department.Department;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course implements Serializable {

    @Id
    @NonNull
    @GeneratedValue
    @Column(name = "course_id")
    private Integer id;

    @NonNull
    @Column(name = "course_name")
    private String name;

    @OneToOne
    private Staff faculty;

    @ManyToOne
    private Department department;
}
