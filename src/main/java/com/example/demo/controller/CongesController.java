package com.example.demo.controller;

import com.example.demo.dto.CreateCongesDto;
import com.example.demo.dto.UpdateCongesDto;
import com.example.demo.model.Conges;
import com.example.demo.repository.CongesRepository;
import com.example.demo.service.Interface.CongesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
@RequestMapping("/conges")

public class CongesController {
    private final CongesService congesService;
    private final CongesRepository congesRepository;

    public CongesController(CongesService congesService, CongesRepository congesRepository) {
        this.congesService = congesService;
        this.congesRepository = congesRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<Conges> create(@RequestBody CreateCongesDto createCongesDto) {
        Conges conges = congesService.creer(createCongesDto);
        return ResponseEntity.ok(conges);
    }

    @GetMapping("/{id}")
    public Conges getCongesById(@PathVariable long id) {
        return congesService.lire(id);

    }
    @GetMapping("/read")
    public List<Conges> read() {
        return congesService.lire();
    }

    @GetMapping("/conge/{congeId}/occupied-time")
    public Long getOccupiedTime(@PathVariable long congeId) {
      //  Conges conges= congesRepository.findById(id).orElseThrow();
        return congesService.calculateTotalOccupiedTime(congeId);
    }
    @PutMapping("/update/{id}")
    public Conges update(@PathVariable long id, @RequestBody UpdateCongesDto updateCongesDto){
        return congesService.modifier(id,updateCongesDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        congesService.suprimer(id);
    }
}
