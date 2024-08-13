package com.example.demo.service;

import com.example.demo.Utilite.Utils;
import com.example.demo.dto.CreateEmployerDto;
import com.example.demo.dto.UpdateEmployerDto;
import com.example.demo.model.Departement;
import com.example.demo.model.Employer;
//import lombok.AllArgsConstructor;
import com.example.demo.model.EmployerTime;
import com.example.demo.model.Post;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EmployerRepository;

import com.example.demo.repository.EmployerTimeRepository;
import com.example.demo.repository.PostRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
//import java.util.Optional;


@Data
@Service

public class EmployerServiceimpl implements EmployerService {

    private final EmployerRepository employerRepository;
    private final PostRepository postRepository;
    private final DepartementRepository departementRepository;
    private final Utils utils;
    //private final EmployerTimeRepository employerTimeRepository;

    public EmployerServiceimpl(EmployerRepository employerRepository, PostRepository postRepository, PostService postService, PostRepository postRepository1, DepartementRepository departementRepository, EmployerTime employerTime, EmployerTime employerTimeRepository, EmployerTimeRepository employerTimeRepository1, Utils utils) {

        this.employerRepository = employerRepository;
        this.postRepository = postRepository;


        this.departementRepository = departementRepository;
        //this.employerTimeRepository = employerTimeRepository1;
        this.utils = utils;
    }


    @Override
    public Employer creer(CreateEmployerDto createEmployerDto) {

       /* employer.setCompetences(Competences.JAVASCRIPT);*/
        Employer employer = new Employer();
        employer.setEmployerId(createEmployerDto.getEmployerId());
        employer.setFirstName(createEmployerDto.getFirstName());
        employer.setLastName(createEmployerDto.getLastName());
        employer.setDateEmbauche(createEmployerDto.getDateEmbauche());
        employer.setAdresse(createEmployerDto.getAdresse());
        employer.setNumeroTelephone(createEmployerDto.getNumeroTelephone());
        employer.setManager(createEmployerDto.getManager());
        employer.setStatutEmploiyee(createEmployerDto.getStatutEmploiyee());
        employer.setSexe(createEmployerDto.getSexe());
        employer.setAge(createEmployerDto.getAge());
        employer.setDateCreation(utils.convertStringToLocalDate(createEmployerDto.getDateCreation()));
        employer.setEmailAddress(createEmployerDto.getEmailAddress());
        employer.setSalaire(createEmployerDto.getSalaire());
      /* Post post = postRepository.findById(id).orElseThrow();
Departement departement=departementRepository.findById(id).orElseThrow();
employer.setPost(post);

           /* var departement = departementRepository.findById(id).orElseThrow(() -> new RuntimeException("Departement not found with id " + id));;
            employer.setDepartement(departement.get());*/

        Optional<Departement> departementOptional = Optional.ofNullable(departementRepository.findById(createEmployerDto.getDepartementId()));
        Departement departement = departementOptional.orElseThrow(() -> new RuntimeException("Departement not found with id " + createEmployerDto.getDepartementId()));
        employer.setDepartement(departement);

        Optional<Post> postOptional = Optional.ofNullable(postRepository.findById(createEmployerDto.getPostId()));
        Post post =postOptional.orElseThrow(()-> new RuntimeException("post not found with id"+createEmployerDto.getPostId()));
        employer.setPost(post);

        employer.setDateCreation(LocalDate.now());

/*
          Optional<EmployerTime> employerTimeOptional=employerTimeRepository.findById(createEmployerDto.getEmployerTimeId());
          EmployerTime employerTime=employerTimeOptional.orElseThrow(()-> new RuntimeException("EmployerTime not foud with id"+createEmployerDto.getEmployerTimeId()));
          employer.setEmployerTime(employerTime);
*/

        return employerRepository.save(employer);
        }

    @Override
    public List<Employer> lire() {
        return employerRepository.findAll();
    }

     //ou afficher les employers par ordre crossant de salaire
   /* public List<Employer> lire() {
        List<Employer> employers = employerRepository.findAll();
        return employers.stream()
                .sorted(Comparator.comparingDouble(Employer::getSalaire))
                .collect(Collectors.toList());
    }*/
    // utilisation de a methode de recherche dychotomique.



    /*

    En résumé, cette méthode utilise une approche récursive pour trier les employeurs par salaire en trouvant et en retirant successivement l’employeur avec le salaire le plus bas.
    public List<Employer> sortEmployersBySalary(List<Employer> employers) {
        if (employers.size() <= 1) {
            return employers; // already sorted
        }

        Employer minEmployer = findMinEmployer(employers);
        employers.remove(minEmployer);
        List<Employer> sortedEmployers = new ArrayList<>();
        sortedEmployers.add(minEmployer);
        sortedEmployers.addAll(sortEmployersBySalary(employers));
        return sortedEmployers;
    }
    private Employer findMinEmployer(List<Employer> employers) {
        Employer minEmployer = employers.get(0);
        for (Employer employer : employers) {
            if (employer.getSalaire() < minEmployer.getSalaire()) {
                minEmployer = employer;
            }
        }
        return minEmployer;
    }*/




    @Override
    public Employer lire(long id) {

            var res= employerRepository.findById(id).orElse(null);

            return res;

    }

   /* public Employer getEmployerById(Long id, List<Employer> employers) {
        return employers.stream()
                .filter(employer -> employer.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }*/


    /*@Override

    recherche des employers par la methode dychotomique
    public Employer rechercheEmployer(int idRecherche) {
        List<Employer> employers = lire();
        Collections.sort(employers, Comparator.comparingInt(Employer::getId)); // sort by id
        int low = 0;
        int high = employers.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Employer employer = employers.get(mid);
            if (employer.getId() == idRecherche) {
                return employer;
            } else if (employer.getId() < idRecherche) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null; // not found
    }*/


    @Override

    public Employer modifier(long id, UpdateEmployerDto updateEmployerDto) {
        Employer existingEmployer = employerRepository.findById(id).orElseThrow(()->new
                RuntimeException("l'elementnoexist"));

        existingEmployer.setFirstName(updateEmployerDto.getFirstName());
        existingEmployer.setLastName(updateEmployerDto.getLastName());
      //  existingEmployer.setDateNaissance(updateEmployerDto.getDateNaissance());
        existingEmployer.setDateEmbauche(updateEmployerDto.getDateEmbauche());
        existingEmployer.setAdresse(updateEmployerDto.getAdresse());
       existingEmployer.setNumeroTelephone(updateEmployerDto.getNumeroTelefone());
        existingEmployer.setStatutEmploiyee(existingEmployer.getStatutEmploiyee());
        existingEmployer.setSexe(updateEmployerDto.getSexe());
        existingEmployer.setAge(updateEmployerDto.getAge());
        existingEmployer.setDateCreation(updateEmployerDto.getDateCreation());
        existingEmployer.setEmailAddress(updateEmployerDto.getEmailAddress());
        existingEmployer.setSalaire(updateEmployerDto.getSalaire());

        //existingEmployer.setPost(updateEmployerDto.getPost());

        //Post post = existingEmployer.getPost();
       //si j'ai besoin d'importer les attribut de poste, je pocede de maniere suivant
        //post.setLibelle(employer.getPost().getLibelle());
        //        post.setDescription(employer.getPost().getDescription());
        return employerRepository.save(existingEmployer);

/*

Eleve existingEleve = eleveRepository.findById(eleve.getId()).orElse(null);
        existingEleve.setNom(eleve.getNom());
        existingEleve.setPrenom(eleve.getPrenom());
        existingEleve.setAge(eleve.getAge());
        return eleveRepository.save(existingEleve);
    }
        if (employer1 != null) {

            employer1.setSalaire(employer.getSalaire());
            return employerRepository.save(employer1);
*/


        //.ornew RuntimeException("l'employer n'existe pas!!"));



    }

    @Override
    public String supprimer(long id) {
      employerRepository.deleteById(id);
        return"employer suprimer!!";
        }

    /*@Override

    La méthode commence par récupérer les heures d’arrivée et de départ de l’employé à partir de l’objet . Elle les convertit ensuite en objets pour pouvoir calculer la durée entre les deux heures.EmployerLocalTime

    public Double calculeteHoursWorked(Employer employer) {
        Date heureArrivee = employer.getHeureArrivee();
        Date heureDepart = employer.getHeureDepart();

        // Convert Date to LocalTime
        LocalTime startTime = heureArrivee.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime endTime = heureDepart.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Calculate the duration between start and end time
        long duration = ChronoUnit.MINUTES.between(startTime, endTime);

        // Convert minutes to hours

        double hoursWorked = (double) duration / 60;

        return hoursWorked;
    }*/
}











