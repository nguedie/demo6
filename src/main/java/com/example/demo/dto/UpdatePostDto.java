package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UpdatePostDto {
    private String description;
    private String niveau;
    /*@ElementCollection
    private List<String> competences;*/
    private String lieu;
    private String typeContrat;
}
