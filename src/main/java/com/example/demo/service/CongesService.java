package com.example.demo.service;

import com.example.demo.dto.CreateCongesDto;
import com.example.demo.dto.UpdateCongesDto;
import com.example.demo.model.Conges;
import com.example.demo.model.Post;

import java.util.List;

public interface CongesService {
    Conges creer (CreateCongesDto createCongesDto);

    Conges lire(long id);

    List<Conges> lire();

    Conges modifier(long id, UpdateCongesDto updateCongesDto);

    Long  calculateTotalOccupiedTime(long congesId);

    Conges getCongesJour(long congesId);


    String suprimer(long id);


}
