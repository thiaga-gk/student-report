package com.student.report.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAll() {

        Iterable<Student> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentById(Long studentId) {

        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Student> getStudentsByFirstName(String firstName) {

        Iterable<Student> students = studentRepository.findByPersonFirstName(firstName);
        return students;
    }

    public Iterable<Student> getStudentsByLastName(String lastName) {

        Iterable<Student> students = studentRepository.findByPersonLastName(lastName);
        return students;
    }
}
