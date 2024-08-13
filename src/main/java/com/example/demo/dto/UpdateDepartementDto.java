package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class UpdateDepartementDto {
    private String nom;
    private String description;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateCreation;

    private String localisation;
    private int nombreEmployes;
}
