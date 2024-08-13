package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateEmployerDto {

private long employerId;
    private long departementId;
    private long congesId;

    //private long employerTimeId;
    private long postId;
    @Column(length=255)

    private String firstName;

    private String lastName;
    @Column(length = 255)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateEmbauche;

    @Column(length = 17)
    private String adresse;

    @Column(length = 17)
    private String numeroTelephone;

    @Column(length = 17)
    private String manager;

    private String statutEmploiyee;

    @Column(length = 1)
    private String sexe;

    private int age;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateCreation;

    @JsonProperty("emailAddress")
    private String emailAddress;
    @Column(length = 13)
    private double salaire;

}
