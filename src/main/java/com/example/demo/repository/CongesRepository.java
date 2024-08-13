package com.example.demo.repository;

import com.example.demo.model.Conges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongesRepository extends JpaRepository<Conges ,Long> {
    Conges findByCongeId(long congeId);
}
