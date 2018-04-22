package com.student.report.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findById(Long studentId);

    List<Student> findByPersonFirstName(String firstName);

    List<Student> findByPersonLastName(String lastName);
}