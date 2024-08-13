package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private long departementId;
    private String nom;
    private String description;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateCreation;

    private String localisation;
   // private int ombreEmployes;

   /* @ElementCollenction
  private List<String> projets;*/

   /* @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Employer> employers;*/



}
