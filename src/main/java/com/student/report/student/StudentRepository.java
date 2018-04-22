package com.student.report.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findById(long studentId);

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);
}