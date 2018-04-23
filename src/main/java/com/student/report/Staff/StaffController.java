package com.student.report.Staff;

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
@RequestMapping(value = "/staff", produces = MediaType.APPLICATION_JSON_VALUE)
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<Staff>> getAll() {

        Iterable<Staff> staffs = staffService.getAll();
        return ResponseEntity.ok(staffs);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") Integer staffId) {

        Staff staff = staffService.getStaffById(staffId);
        return ResponseEntity.ok(staff);
    }

    @GetMapping(value = "/last/{lastname}")
    public ResponseEntity<Iterable<Staff>> getAllByLastName(@PathVariable("lastname") String lastName) {

        Iterable<Staff> staffs = staffService.getStaffsByLastName(lastName);
        return ResponseEntity.ok(staffs);
    }

    @GetMapping(value = "/first/{firstname}")
    public ResponseEntity<Iterable<Staff>> getAllByFirstName(@PathVariable("firstname") String firstName) {

        Iterable<Staff> staffs = staffService.getStaffsByFirstName(firstName);
        return ResponseEntity.ok(staffs);
    }
}
