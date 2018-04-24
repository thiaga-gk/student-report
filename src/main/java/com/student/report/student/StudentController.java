package com.student.report.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/all")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Student>> getAll() {

        Iterable<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/student/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long studentId) {

        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/student/last/{lastname}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Student>> getAllByLastName(@PathVariable("lastname") String lastName) {

        Iterable<Student> students = studentService.getStudentsByLastName(lastName);
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/student/first/{firstname}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Student>> getAllByFirstName(@PathVariable("firstname") String firstName) {

        Iterable<Student> students = studentService.getStudentsByFirstName(firstName);
        return ResponseEntity.ok(students);
    }

    @PostMapping(value = "/student")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {

        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping(value = "/student/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> updateStudent(@PathVariable(value = "id") Long studentId,
                                              @Valid @RequestBody Student studentDetails) {

        studentService.updateStudent(studentId, studentDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/student/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long studentId) {

        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}