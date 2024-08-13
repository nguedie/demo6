package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "conges")
public class Conges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  long congeId;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate jour;


    @Column(name = "debutConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private LocalDateTime debutConges;

    @Column(name = "finConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private LocalDateTime finConges;

    @ManyToOne
    @JoinColumn(name="employer_id",nullable = false)
    private Employer employer;



}
