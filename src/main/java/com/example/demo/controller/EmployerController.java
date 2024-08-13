package com.example.demo.controller;

import com.example.demo.dto.CreateDepartementDto;
import com.example.demo.dto.CreateEmployerDto;
import com.example.demo.dto.UpdateEmployerDto;
import com.example.demo.model.Employer;
import com.example.demo.service.EmployerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employer")

public class EmployerController {


        private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }


        @PostMapping("/create")
        public ResponseEntity<Employer> createEmployer(@RequestBody CreateEmployerDto createEmployerDto) {
            Employer employer = employerService.creer(createEmployerDto);
              return ResponseEntity.ok(employer);
        }



   @GetMapping ("/getAllEmployers")
    public List<Employer> getAllEmployers() {
       return employerService.lire();
   }



   /* @GetMapping("/read")
    public List<Employer> read() {
        return employerService.lire();
    }*/
    @GetMapping("/getEmployerById/{id}")
    public Employer getEmployerById(@PathVariable long id) {
        var result= employerService.lire(id);
        var department= result.getDepartement();
        var post= result.getPost();
        return result;
    }

   /* @GetMapping("/{id}/hours-worked")
    public ResponseEntity<Double> getHoursWorked(@PathVariable Long id) {
        Employer employer = employerService.lire(id);
        Double hoursWorked = employerService.calculeteHoursWorked(employer);
        return ResponseEntity.ok(hoursWorked);
    }*/


        @PutMapping("/update/{id}")
        public Employer update(@PathVariable long id, @RequestBody UpdateEmployerDto updateEmployerDto){
            return employerService.modifier(id,updateEmployerDto);
        }
        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable long id){
        employerService.supprimer(id);
        }

    }


