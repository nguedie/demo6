package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employer")

@Setter
@Getter
@NoArgsConstructor
@Data
public class Employer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  long id;

    private long employerId;
    private String firstName;
    @Column(length=255)

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
    private LocalDate dateCreation;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @Column(length = 13)
    private double salaire;


    //@ManyToOne(fetch = FetchType.LAZY)

   /* @ManyToOne
    @JoinColumn(name = "post_id")


   @DateTimeFormat(pattern = "HH:mm")
   @JsonProperty("startTime")
   private Date startTime;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonProperty("heureDepart")
    private Date heureDepart;
   /* @JoinTable(
           name = "employer_post",
           joinColumns = {@JoinColumn(name = "employer_id")},
           inverseJoinColumns = {@JoinColumn(name = "post_id")}
    )*/

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "employer")
    private List<EmployerTime> employerTimes;

    @OneToMany(mappedBy = "employer")
    private List<Conges> conges;



}
