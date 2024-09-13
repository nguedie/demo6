package com.example.demo.repository;

import com.example.demo.model.EmployerTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface EmployerTimeRepository extends JpaRepository<EmployerTime,Long> {
    EmployerTime findEmployerTimeByIdAndJour(long id ,LocalDate jour);
}


