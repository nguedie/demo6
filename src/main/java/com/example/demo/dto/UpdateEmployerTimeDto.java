package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UpdateEmployerTimeDto {
   private long employerId;
  private  LocalDate jour;
   private  LocalDateTime heureDepart;
}
