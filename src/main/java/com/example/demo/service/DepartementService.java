package com.example.demo.service;

import com.example.demo.dto.CreateDepartementDto;
import com.example.demo.dto.UpdateDepartementDto;
import com.example.demo.model.Departement;

import java.util.List;

public interface DepartementService {
    Departement ceer(CreateDepartementDto createDepartementDto);

  //  Departement creerListEmployerDansDepartement(Departement epartement);

    List<Departement>lire();

    Departement lire (long id);

    Departement modifier (long id, UpdateDepartementDto updateDepartementDto);

    String supprimer(long id);
}
