package com.example.demo.service;

import com.example.demo.dto.CreateDepartementDto;
import com.example.demo.dto.UpdateDepartementDto;
import com.example.demo.model.Departement;
import com.example.demo.model.Employer;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EmployerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartementServiceimpl implements DepartementService{
    private final DepartementRepository departementRepository;
    private final EmployerRepository employerRepository;

    public DepartementServiceimpl(DepartementRepository departementRepository, EmployerService employerService, EmployerRepository employerRepository){
        this.departementRepository=departementRepository;

        this.employerRepository = employerRepository;
    }
    @Override
    public Departement ceer(CreateDepartementDto createDepartementDto) {
        Departement departement = new Departement();
        departement.setDepartementId(createDepartementDto.getDepartementId());
        departement.setNom(createDepartementDto.getNom());
        departement.setDescription(createDepartementDto.getDescription());
        departement.setDateCreation(createDepartementDto.getDateCreation());
        departement.setLocalisation(createDepartementDto.getLocalisation());
      //var employer = employerRepository.findById(e);
        List<Employer> employers = new ArrayList<>();
        /*if (employer != null) {
            employers.add(employer.get());
            departement.setEmployers(employers);
        } else {
            throw new RuntimeException("l'employee n'est pas trouvee");
//            throw new NoSuchElementException("l'employee n'est pas trouvee");
        }
            return departementRepository.save(departement);
        }
         */
/*
        for (Long employerId : createDepartementDto.getEmployerIds()) {
            Employer employer = employerRepository.findById(employerId).orElseThrow(
                    () -> new RuntimeException("Employer not found with ID " + employerId));
            employers.add(employer);
        }
        depar*///tement.setEmployers(employers);

        return departementRepository.save(departement);
    }

    /*@Override
    public Departement creerListEmployerDansDepartement(Departement departement,List) {
        var employer=employerRepository.findAllByDepartement(departement);
       // departement.setEmployers(employer);
        return departementRepository.save(departement);
    }*/

    @Override
    public List<Departement> lire() {
        return departementRepository.findAll();
    }

    @Override
    public Departement lire(long id) {
        var Departement= departementRepository.findById(id);
        return Departement;
    }

    @Override
    public Departement modifier(long id, UpdateDepartementDto updateDepartementDto) {
        Departement departement1=departementRepository.findById(id);


            departement1.setNom(updateDepartementDto.getNom());
            departement1.setDescription(updateDepartementDto.getDescription());
            departement1.setLocalisation(updateDepartementDto.getLocalisation());
        //    departement2.setNombreEmployes(updateDepartementDto.getNombreEmployes());
            return departementRepository.save(departement1);

    }



    @Override
    public String supprimer(long id) {
        departementRepository.deleteById(id);
        return "departement supprimer !!!";
    }
}
