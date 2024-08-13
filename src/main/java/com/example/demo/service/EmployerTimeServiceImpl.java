package com.example.demo.service;

import com.example.demo.Utilite.Utils;
import com.example.demo.dto.EmployerTimeDto;
import com.example.demo.model.Chomage;
import com.example.demo.model.Departement;
import com.example.demo.model.Employer;
import com.example.demo.model.EmployerTime;
import com.example.demo.repository.EmployerRepository;
import com.example.demo.repository.EmployerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Configuration

public class EmployerTimeServiceImpl implements EmployerTimeService {


    private final EmployerTimeRepository employerTimeRepository;
    private final EmployerService employerService;
    private final Utils utils;
    private final EmployerRepository employerRepository;

    @Autowired
    PostService postService;
    @Autowired
    ChomageService chomageService;
    @Autowired
    CongesService congesService;

    public EmployerTimeServiceImpl(EmployerTimeRepository employerTimeRepository, EmployerService employerService, Utils utils,  EmployerRepository employerRepository) {
        this.employerTimeRepository = employerTimeRepository;

        this.employerService = employerService;
        this.utils = utils;

        this.employerRepository = employerRepository;
    }


    @Override
    public EmployerTime creer(/*EmployerTime employerTime,*/EmployerTimeDto employerTimeDto) {
        Employer employer = employerRepository.findByEmployerId(employerTimeDto.getEmployerId())
                .orElseThrow(() -> new RuntimeException("Employer non trouvé"+ employerTimeDto.getEmployerId()));
        EmployerTime employerTime = new EmployerTime();
        employerTime.setEmployer(employer);
        employerTime.setJour(utils.getCurrenDate());
        employerTime.setHeureArrivee(utils.getCurrencenDateTime());

        var result= employerTimeRepository.save(employerTime);
        result.getEmployer().setEmployerTimes(null);
        return  result;
    }

    @Override
    public EmployerTime lire(long id) {
        return employerTimeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmployerTime> lire() {
        return employerTimeRepository.findAll();
    }

    /*@Override
    public EmployerTime creerListjustificationDansEmployerTime(EmployerTime employerTime) {
        var justificateEmployerTime=justificateEmployerTimeRepository.findAll();
                employerTime.setJustificateEmployerTimes(justificateEmployerTime);
        return employerTimeRepository.save(employerTime);
    }*/

    @Override
    public Long calculateTotalOccupiedTime(long employerId, LocalDate jour,long congeId) {

        long totalMinuteResponse = 0;
        Employer employer = employerService.lire(employerId);
        if (employer != null) {
            // Assuming you have a method to get the corresponding Post object for an EmployerTime
           EmployerTime employerTime = employerTimeRepository.findByEmployerIdAndJour(employerId, jour);
            if (employerTime != null) {
                Duration minuteDeEmployer =employerTime.getHeureArrivee()!=null && employerTime.getHeureDepart()!=null? Duration.between(employerTime.getHeureArrivee(), employerTime.getHeureDepart()) : null;

                long minuteDePost = postService.calculateTotalOccupiedTime(employer.getPost());
                // return minuteDePost - minuteDeEmployer.toMinutes();
                long totalMinute = minuteDePost - minuteDeEmployer.toMinutes();

                if (totalMinute <= 0) {
                    // L'employé a travaillé plus que les heures prévues
                    System.out.println("L'employé a travaillé aux  heures prévues.");
                } else if (totalMinute > 0) {
                    // L'employé a travaillé moin  que les heures prévues
                    System.out.println("L'employé a travaillé moin  que les heures prévues.");
                    //tu appel la method calculateTotalOccupiedTime avec en parametre l'id de chomage
                    long minuteChomage = chomageService.calculateTotalOccupiedTime();
                    if (minuteChomage <= totalMinute) {
                        System.out.println("Le temps travaillé correspond à une période de chômage.");
                    }
                }else  if(totalMinute == 480 ){
                    var minuteConges=congesService.getCongesJour(congeId);
                    if(minuteConges.getDebutConges().equals(LocalDateTime.now())){
                        System.out.println("l'employer a prit son tenps de conges");
                    }else{
                        throw new RuntimeException("l'employer n'a pas prit son tenps de conges. il a travailler moin que prevu");
                    }// or throw an exception if you want
                }
                totalMinuteResponse = totalMinute;
//                return totalMinute;
            }
        } else {
            throw new RuntimeException("Employer does not exist.");
        }
        return totalMinuteResponse;
    }

    @Override
    public EmployerTime updateHeureDepart(long employerId, LocalDate jour) {
        EmployerTime employerTime = employerTimeRepository.findByEmployerIdAndJour(employerId, jour);

        if (employerTime != null) {

            employerTime.setHeureDepart(utils.getCurrencenDateTime());
            return employerTimeRepository.save(employerTime);
    }
        throw new RuntimeException("employer nom trouve !!");
}



    @Override
    public String suprimer(long id) {
        employerTimeRepository.findById(id);
        return "this time is delete";
    }
}



           /*
            employerTime.setHeureDepart(heureDepart);
            return employerTimeRepository.save(employerTime);
    }*/


