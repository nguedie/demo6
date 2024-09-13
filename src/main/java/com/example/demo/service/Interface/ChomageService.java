package com.example.demo.service.Interface;


import com.example.demo.dto.CreateChomageDto;
import com.example.demo.model.Chomage;

import java.time.LocalDate;
import java.util.List;

public interface ChomageService {
    Chomage creer(CreateChomageDto createChomageDto);

    Chomage lire(long id);

    List<Chomage> lire();

    Long calculateTotalOccupiedTime();


    Chomage modifier(long id,Chomage chomage);

   // String suprimer(long id);

}
