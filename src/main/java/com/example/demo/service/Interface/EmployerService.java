package com.example.demo.service.Interface;

import com.example.demo.dto.CreateEmployerDto;
import com.example.demo.dto.UpdateEmployerDto;
import com.example.demo.model.Employer;


import java.util.Date;
import java.util.List;

public interface EmployerService {
    Employer creer(CreateEmployerDto createEmployerDto);


    List<Employer> lire();




    //List<Employer> sortEmployersBySalary(List<Employer> employers);

    Employer lire(long id);


    Employer modifier(long id, UpdateEmployerDto updateEmployerDto);

    String supprimer(long id);


    //Double calculeteHoursWorked(Employer employer);

    //Employer rechercheEmployer(long id, Employer employer);
}
