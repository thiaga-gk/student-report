package com.student.report.staff;

import com.student.report.student.Person;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "staff")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff implements Serializable {

    @Id
    @NonNull
    @GeneratedValue
    private Integer id;

    @Embedded
    private Person faculty;
}
