package com.student.report.Staff;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

    Optional<Staff> findById(Integer studentId);

    List<Staff> findByFacultyFirstName(String firstName);

    List<Staff> findByFacultyLastName(String lastName);
}
