package com.student.report.department;

import com.student.report.Staff.Staff;
import com.student.report.course.Course;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department implements Serializable {

    @Id
    @NonNull
    @Column(name = "dept_id")
    private Integer id;

    @NonNull
    @Column(name = "short_name")
    private String shortName;

    @NonNull
    @Column(name = "long_name")
    private String longName;

    @OneToOne
    private Staff chair;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();
}
