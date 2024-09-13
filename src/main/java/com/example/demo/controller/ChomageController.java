package com.example.demo.controller;

import com.example.demo.dto.CreateChomageDto;
import com.example.demo.model.Chomage;
import com.example.demo.repository.ChomageRepository;
import com.example.demo.service.Interface.ChomageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
@RequestMapping("/chomage")
public class ChomageController {
    private final ChomageService chomageService;
    private  final ChomageRepository chomageRepository;

    public ChomageController(ChomageService chomageService, ChomageRepository chomageRepository) {
        this.chomageService = chomageService;
        this.chomageRepository = chomageRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Chomage> create(@RequestBody CreateChomageDto createChomageDto) {
        Chomage chomage = chomageService.creer(createChomageDto);
        return ResponseEntity.ok(chomage);
    }

    @GetMapping("/{id}")
    public Chomage getChomageById(@PathVariable long id) {
        return chomageService.lire(id);

    }
    @GetMapping("/read")
    public List<Chomage> read() {
        return chomageService.lire();
    }

    @GetMapping("/chomages/occupied-time")
    public Long getOccupiedTime() {
//        Chomage chomage = chomageRepository.findById(id).orElseThrow();
        return chomageService.calculateTotalOccupiedTime();
    }




}
