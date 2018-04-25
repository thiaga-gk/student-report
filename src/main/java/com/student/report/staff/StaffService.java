package com.student.report.staff;

import com.student.report.exception.ResourceNotFoundException;
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
        return staff.orElseThrow(() -> new ResourceNotFoundException("Staff", "id", String.valueOf(staffId)));
    }

    public List<Staff> getStaffsByFirstName(String firstName) {

        return staffRepository.findByFacultyFirstName(firstName);
    }

    public List<Staff> getStaffsByLastName(String lastName) {

        return staffRepository.findByFacultyLastName(lastName);
    }

    public Staff createStaff(Staff staff) {

        return staffRepository.save(staff);
    }

    public Staff updateStaff(Integer staffId, Staff staffDetails) {

        Staff staff = getStaffById(staffId);
        staff.getFaculty().setFirstName(staffDetails.getFaculty().getFirstName());
        staff.getFaculty().setLastName(staffDetails.getFaculty().getLastName());
        staff.getFaculty().setGender(staffDetails.getFaculty().getGender());
        staff.getFaculty().setEmail(staffDetails.getFaculty().getEmail());
        staff.getFaculty().setPhone(staffDetails.getFaculty().getPhone());
        staff.getFaculty().setAddress(staffDetails.getFaculty().getAddress());
        staff.getFaculty().setBirthDate(staffDetails.getFaculty().getBirthDate());
        staff.getFaculty().setFullTime(staffDetails.getFaculty().getFullTime());
        staff.getFaculty().setEnrollmentStatus(staffDetails.getFaculty().getEnrollmentStatus());
        staff.getFaculty().setStartDate(staffDetails.getFaculty().getStartDate());
        staff.getFaculty().setEndDate(staffDetails.getFaculty().getEndDate());
        staff.setDesignation(staffDetails.getDesignation());

        return staffRepository.save(staff);
    }

    public void deleteStaff(Integer staffId) {

        Staff staff = getStaffById(staffId);
        staffRepository.delete(staff);
    }
}
