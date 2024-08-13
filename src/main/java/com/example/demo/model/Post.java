package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long postId;
    private String description;
    @Column(length = 255)
    private String niveau;
    private String lieu;


    @Column(name = "heureArrivee")
   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime heureArrivee;

    @Column(name = "heureDepart")
   @DateTimeFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime heureDepart;


    //@OneToMany
    //private List<Employer> employer;
/*

    @ManyToMany(mappedBy = "post")
    private Set<Employer> employers;
*/

}
