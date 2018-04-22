package com.student.report.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAll() {

        Iterable<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long studentId) {

        Student student = studentRepository.findById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/last/{lastname}")
    public ResponseEntity<Iterable<Student>> getAllByLastName(@PathVariable("lastname") String lastName) {

        Iterable<Student> students = studentRepository.findByLastName(lastName.toLowerCase());
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/first/{firstname}")
    public ResponseEntity<Iterable<Student>> getAllByFirstName(@PathVariable("firstname") String firstName) {

        Iterable<Student> students = studentRepository.findByFirstName(firstName.toLowerCase());
        return ResponseEntity.ok(students);
    }
}