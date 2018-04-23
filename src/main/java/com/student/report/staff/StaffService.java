package com.student.report.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Iterable<Staff> getAll() {

        return staffRepository.findAll();
    }

    public Staff getStaffById(Integer staffId) {

        Optional<Staff> staff = staffRepository.findById(staffId);
        return staff.orElseThrow(IllegalArgumentException::new);
    }

    public List<Staff> getStaffsByFirstName(String firstName) {

        return staffRepository.findByFacultyFirstName(firstName);
    }

    public List<Staff> getStaffsByLastName(String lastName) {

        return staffRepository.findByFacultyLastName(lastName);
    }
}
