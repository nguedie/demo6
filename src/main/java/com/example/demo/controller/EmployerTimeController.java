package com.example.demo.controller;


import com.example.demo.dto.EmployerTimeDto;
import com.example.demo.model.EmployerTime;

import com.example.demo.service.EmployerService;
import com.example.demo.service.EmployerTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employerTime")

public class EmployerTimeController {
    private final EmployerTimeService employerTimeService;


    @Autowired
    public EmployerTimeController(EmployerTimeService employerTimeService, EmployerService employerService) {
        this.employerTimeService = employerTimeService;

    }
    @PostMapping("/create")
    public  ResponseEntity<EmployerTime> create(/*@RequestBody EmployerTime employerTime,*/ @RequestBody EmployerTimeDto employerTimeDto)  {
      //  return employerTimeService.creer(employerTime,employerId);
        EmployerTime newEmployerTime = employerTimeService.creer(/*employerTime,*/employerTimeDto);
        return ResponseEntity.ok(newEmployerTime);
    }

    @GetMapping("/{id}")
    public EmployerTime getEmployerTimeById(@PathVariable long id) {
        return employerTimeService.lire(id);
    }

    @GetMapping("/{employerId}/calculateTotalOccupiedTime/{jour}/{congeId}")
    public ResponseEntity<Long> calculateTotalOccupiedTime(@PathVariable long employerId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jour,@PathVariable long congeId) {
        Long totalOccupiedTime = employerTimeService.calculateTotalOccupiedTime(employerId, jour,congeId);
        return ResponseEntity.ok(totalOccupiedTime);
    }

    @PutMapping("/{employerId}/jour/{jour}")
    public ResponseEntity<EmployerTime> updateHeureDepart(@PathVariable long employerId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jour) {
        EmployerTime employerTime = employerTimeService.updateHeureDepart(employerId, jour);
        if (employerTime != null) {
            return ResponseEntity.ok(employerTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

   /* @PatchMapping("/{id}/heureDepart")
    public ResponseEntity<EmployerTime> updateHeureDepart(@PathVariable Long employerId, @RequestBody LocalDate jour) {
        EmployerTime updatedEmployerTime = employerTimeService.updateHeureDepart(employerId, jour);
        return ResponseEntity.ok(updatedEmployerTime);
    }*/










