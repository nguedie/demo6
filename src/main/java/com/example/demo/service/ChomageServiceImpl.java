package com.example.demo.service;

import com.example.demo.Utilite.Utils;
import com.example.demo.dto.CreateChomageDto;
import com.example.demo.model.Chomage;
import com.example.demo.model.Employer;
import com.example.demo.repository.ChomageRepository;
import com.example.demo.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
@Service

public class ChomageServiceImpl implements ChomageService{
    private final ChomageRepository chomageRepository;
    private final EmployerRepository employerRepository;
    private  final Utils utils;

    public ChomageServiceImpl(ChomageRepository chomageRepository, EmployerRepository employerRepository, Utils utils) {
        this.chomageRepository = chomageRepository;
        this.employerRepository = employerRepository;
        this.utils = utils;
    }

    @Override
    public Chomage creer(CreateChomageDto createChomageDto) {
        Employer employer=employerRepository.findByEmployerId(createChomageDto.getEmployerId())
      .orElseThrow(() -> new RuntimeException("Employer non trouvé"+ createChomageDto.getEmployerId()));

      Chomage chomage=new Chomage();
      chomage.setEmployer(employer);
      chomage.setChomageId(createChomageDto.getChomageId());
      chomage.setJour(utils.convertStringToLocalDate(createChomageDto.getJour()));
      chomage.setDebutHeureChomage(utils.convertStringToLocalDateTime(createChomageDto.getDebutHeureChomage()));
      chomage.setFinHeureChomage(utils.convertStringToLocalDateTime(createChomageDto.getFinHeureChomage()));
      var chamageTooSave = chomageRepository.save(chomage);
        return chamageTooSave;
    }

    @Override
    public Chomage lire(long id) {
        return chomageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chomage> lire() {
        return chomageRepository.findAll();
    }

    @Override
    public Long calculateTotalOccupiedTime() { // ici passe en parametre plutot long id
        //appeler la methode lire pour recuperer la config du chomage
        var chomage = chomageRepository.findByChomageId(2);
        //tu recupere le debutHeureChomage et la finHeureChomage
        var debutHeureChomage = chomage.getDebutHeureChomage();
        var finHeureChomage = chomage.getFinHeureChomage();

        if (debutHeureChomage != null && finHeureChomage != null) {
            Duration duration = Duration.between(debutHeureChomage, finHeureChomage);
            return duration.toMinutes(); // returns the total occupied time in minutes
        } else {
            return null; // or throw an exception if you want
        }
    }

    @Override
    public Chomage modifier(long id, Chomage chomage) {
        return null;
    }



}
