package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class CreateCongesDto {
    private long congeId;
    private long employerId;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jour;


    @Column(name = "debutConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private String debutConges;

    @Column(name = "finConges")
    @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private String finConges;
}
