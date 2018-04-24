package com.student.report.student;

import com.student.report.exception.ResourceNotFoundException;
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
        return student.orElseThrow(() -> new ResourceNotFoundException("Student", "id", String.valueOf(studentId)));
    }

    public List<Student> getStudentsByFirstName(String firstName) {

        return studentRepository.findByPersonFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName) {

        return studentRepository.findByPersonLastName(lastName);
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student updateStudent(Long studentId, Student studentDetails) {

        Student student = getStudentById(studentId);
        student.getPerson().setFirstName(studentDetails.getPerson().getFirstName());
        student.getPerson().setLastName(studentDetails.getPerson().getLastName());
        student.getPerson().setGender(studentDetails.getPerson().getGender());
        student.getPerson().setEmail(studentDetails.getPerson().getEmail());
        student.getPerson().setPhone(studentDetails.getPerson().getPhone());
        student.getPerson().setAddress(studentDetails.getPerson().getAddress());
        student.getPerson().setBirthDate(studentDetails.getPerson().getBirthDate());
        student.getPerson().setFullTime(studentDetails.getPerson().getFullTime());
        student.getPerson().setEnrollmentStatus(studentDetails.getPerson().getEnrollmentStatus());
        student.getPerson().setStartDate(studentDetails.getPerson().getStartDate());
        student.getPerson().setEndDate(studentDetails.getPerson().getEndDate());
        student.setAcademicYear(studentDetails.getAcademicYear());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {

        Student student = getStudentById(studentId);
        studentRepository.delete(student);
    }
}
