package com.example.demo.service;

import com.example.demo.Utilite.Utils;
import com.example.demo.dto.CreateCongesDto;
import com.example.demo.dto.UpdateCongesDto;
import com.example.demo.model.Conges;
import com.example.demo.model.Employer;
import com.example.demo.repository.CongesRepository;
import com.example.demo.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service


public class CongesServiceImpl implements CongesService{
    private final CongesRepository congesRepository;
    private final Utils utils;
    private final EmployerRepository employerRepository;

    public CongesServiceImpl(CongesRepository congesRepository, Utils utils, EmployerRepository employerRepository) {
        this.congesRepository = congesRepository;
        this.utils = utils;
        this.employerRepository = employerRepository;
    }

    @Override
    public Conges creer(CreateCongesDto createCongesDto) {
        Employer employer= employerRepository.findByEmployerId(createCongesDto.getEmployerId())
                .orElseThrow(() -> new RuntimeException("Employer non trouvé"+ createCongesDto.getEmployerId()));

        Conges conges=new Conges();

        conges.setEmployer(employer);
        conges.setCongeId(createCongesDto.getCongeId());
        conges.setJour(utils.convertStringToLocalDate(createCongesDto.getJour()));
        conges.setDebutConges(utils.convertStringToLocalDateTime(createCongesDto.getDebutConges()));
        conges.setFinConges(utils.convertStringToLocalDateTime(createCongesDto.getFinConges()));

      var result= congesRepository.save(conges);
        result.getEmployer().setConges(null);
        return  result;
       // return congesRepository.save(conges);
    }

    @Override
    public Conges lire(long id) {
        return congesRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Conges> lire() {
        return congesRepository.findAll();
    }

    @Override
    public Conges modifier(long id, UpdateCongesDto updateCongesDto) {
        Optional<Conges> conges1=  congesRepository.findById(id);

        if(conges1.isPresent()){
            Conges conges2= conges1.get();

            conges2.setCongeId(updateCongesDto.getCongeId());
            conges2.setJour(utils.convertStringToLocalDate(updateCongesDto.getJour()));
            conges2.setDebutConges(utils.convertStringToLocalDateTime(updateCongesDto.getDebutConges()));
             conges2.setFinConges(utils.convertStringToLocalDateTime(updateCongesDto.getFinConges()));
            return  congesRepository.save(conges2);
        }else {
            // System.out.println("personnel pas trouvee");
            throw new RuntimeException("pas de reponse trouve!!!");
        }
    }


    @Override
    public Long calculateTotalOccupiedTime(long congeId) {
        var conges = congesRepository.findByCongeId(congeId);
        var debutConges = conges.getDebutConges();
        var finConges = conges.getFinConges();

        if (debutConges != null && finConges != null) {
            Duration duration = Duration.between(debutConges, finConges);
            return duration.toMinutes(); // returns the total occupied time in minutes
        } else {
            return null;
        }
    }

    @Override
    public Conges getCongesJour(long congeId){
        return congesRepository.findByCongeId(congeId);
    }

    @Override
    public String suprimer(long id) {
        congesRepository.deleteById(id);
        return "l'employer n'a plus de conges";
    }
}
