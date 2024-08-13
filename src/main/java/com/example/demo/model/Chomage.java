package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chomage")

public class Chomage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long chomageId;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate jour;

    @Column(name = "debutHeureChomage")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime debutHeureChomage;

    @Column(name = "finHeureChomage")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime finHeureChomage;


    private String justification;

    @ManyToOne
   @JoinColumn(name="employer_id",nullable = false)
//@ManyToOne(fetch = FetchType.LAZY,optional = false)
//@JoinColumn(name="employer_id")
    private Employer employer;


}
