package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateChomageDto {
    private long chomageId;
    private long employerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jour;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private String debutHeureChomage;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private String finHeureChomage;

    private String justification;
}
