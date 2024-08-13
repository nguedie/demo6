package com.example.demo.repository;

import com.example.demo.model.Chomage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChomageRepository extends JpaRepository<Chomage,Long> {

    Chomage findByChomageId(long chomageId);
}
