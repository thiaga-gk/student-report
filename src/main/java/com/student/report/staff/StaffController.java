package com.student.report.staff;

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
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/staff/all")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Staff>> getAll() {

        Iterable<Staff> staffs = staffService.getAll();
        return ResponseEntity.ok(staffs);
    }

    @GetMapping(value = "/staff/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Staff> getStaff(@PathVariable("id") Integer staffId) {

        Staff staff = staffService.getStaffById(staffId);
        return ResponseEntity.ok(staff);
    }

    @GetMapping(value = "/staff/last/{lastname}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Staff>> getAllByLastName(@PathVariable("lastname") String lastName) {

        Iterable<Staff> staffs = staffService.getStaffsByLastName(lastName);
        return ResponseEntity.ok(staffs);
    }

    @GetMapping(value = "/staff/first/{firstname}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Iterable<Staff>> getAllByFirstName(@PathVariable("firstname") String firstName) {

        Iterable<Staff> staffs = staffService.getStaffsByFirstName(firstName);
        return ResponseEntity.ok(staffs);
    }

    @PostMapping(value = "/staff")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Staff> createStaff(@Valid @RequestBody Staff staff) {

        return new ResponseEntity<>(staffService.createStaff(staff), HttpStatus.CREATED);
    }

    @PutMapping(value = "/staff/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> updateStaff(@PathVariable(value = "id") Integer staffId,
                                            @Valid @RequestBody Staff staffDetails) {

        staffService.updateStaff(staffId, staffDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/staff/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Integer staffId) {

        staffService.deleteStaff(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
