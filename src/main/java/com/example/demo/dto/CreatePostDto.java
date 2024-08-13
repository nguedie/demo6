package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CreatePostDto {


    private Long postId;
    private String description;
    private String niveau;
    private String lieu;
    @Column(name = "heureArrivee")
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private String heureArrivee;

    @Column(name = "heureDepart")
   // @DateTimeFormat(pattern ="YYYY-MM-dd'T'HH:mm:ss.SSS" )
    private String heureDepart;


}
