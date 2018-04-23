package com.student.report.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAll() {

        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {

        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElseThrow(IllegalArgumentException::new);
    }

    public List<Student> getStudentsByFirstName(String firstName) {

        return studentRepository.findByPersonFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName) {

        return studentRepository.findByPersonLastName(lastName);
    }
}
