package com.example.demo.repository;

import com.example.demo.model.Departement;
import com.example.demo.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
//   Optional<Employer> findById(long employerId);
   List<Employer> findAllByDepartement(Departement departement);

   Optional<Employer> findById(long id);
}
