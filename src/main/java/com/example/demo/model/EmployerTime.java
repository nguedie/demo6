package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
@Table(name="employertime")
@Entity
public class EmployerTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate jour;


    @Column(name = "heureArrivee")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime heureArrivee;

    @Column(name = "heureDepart")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private LocalDateTime heureDepart;



    @ManyToOne
    //(fetch = FetchType.LAZY,optional = false)
    //@JoinColumn(name="id")
    @JoinColumn(name = "employer_id")
    private Employer employer;

}
