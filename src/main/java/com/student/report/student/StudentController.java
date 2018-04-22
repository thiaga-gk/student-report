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
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<Student>> getAll() {

        Iterable<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long studentId) {

        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/last/{lastname}")
    public ResponseEntity<Iterable<Student>> getAllByLastName(@PathVariable("lastname") String lastName) {

        Iterable<Student> students = studentService.getStudentsByLastName(lastName);
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/first/{firstname}")
    public ResponseEntity<Iterable<Student>> getAllByFirstName(@PathVariable("firstname") String firstName) {

        Iterable<Student> students = studentService.getStudentsByFirstName(firstName);
        return ResponseEntity.ok(students);
    }
}