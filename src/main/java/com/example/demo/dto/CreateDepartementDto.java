package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class CreateDepartementDto {
    private long departementId;
    private String nom;
    private String description;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateCreation;

    private String localisation;
}
