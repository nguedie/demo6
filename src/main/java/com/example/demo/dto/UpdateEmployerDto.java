package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateEmployerDto {
    private String firstName;
    @Column(length=255)

    private String lastName;
    @Column(length = 255)
/*
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate dateOfBirth;*/

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateNaissance;

    private Date dateEmbauche;

    @Column(length = 17)
    private String adresse;

    @Column(length = 17)
    private String numeroTelefone;

    /*@Column(length = 17)
    private String departement;*/

    @Column(length = 17)
    private String manager;

    private String statutEmploiyee;

    @Column(length = 1)
    private String Sexe;

    private int Age;
    //pour specifier l'heure et les minutes je peut ecrire
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    //priv


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;

    @JsonProperty("heureArrive")
    private Date heureArrive;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heureDepart")
    private Date heureDepart;


    @JsonProperty("emailAddress")
    private String emailAddress;

    @Column(length = 13)
    private double Salaire;
   // private LanguesParlees languesParlees;

 /*   private Competences competences;
    private EvaluationsPerformance evaluationsPerformance;
    private Formation formation;
    private LanguesParlees languesParlees;*/




}
