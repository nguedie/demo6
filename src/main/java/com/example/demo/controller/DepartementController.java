package com.example.demo.controller;

import com.example.demo.dto.CreateDepartementDto;
import com.example.demo.dto.UpdateDepartementDto;
import com.example.demo.model.Departement;
import com.example.demo.model.EmployerTime;
import com.example.demo.service.DepartementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/departement")

public class DepartementController {
    private final DepartementService departementService;
    public DepartementController(DepartementService departementService){
        this.departementService=departementService;
    }
    @PostMapping("/create")
    public ResponseEntity<Departement> create(@RequestBody CreateDepartementDto createDepartementDto) {
        Departement departement=departementService.ceer(createDepartementDto);
        return ResponseEntity.ok(departement);
    }
    /*@PostMapping("/Create")
     public Departement Create(@RequestBody Departement departement) {
        return departementService. creerListEmployerDansDepartement(departement);
    }*/
    @GetMapping("/read")
    public List<Departement> read() {
        return departementService.lire();
    }

    @GetMapping("/{id}")
    public Departement  getDepartmentById(@PathVariable long id) {
        var Departement=  departementService.lire(id);
return Departement;
    }
    @PutMapping("/update/{id}")
    public Departement update(@PathVariable long id, @RequestBody UpdateDepartementDto updateDepartementDto){
        return departementService.modifier(id,updateDepartementDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){

      return departementService.supprimer(id);
    }


}
