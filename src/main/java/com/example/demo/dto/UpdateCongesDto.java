package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
@Setter
@Getter
@NoArgsConstructor

public class UpdateCongesDto {
    private  long congeId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jour;


    @Column(name = "debutConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private String DebutConges;

    @Column(name = "finConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private String finConges;
}
