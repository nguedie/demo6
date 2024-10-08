package com.example.demo.service.Interface;

import com.example.demo.dto.EmployerTimeDto;
import com.example.demo.model.EmployerTime;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Component

public interface EmployerTimeService {

    EmployerTime creer (/*EmployerTime employerTim ,*/EmployerTimeDto employerTimeDto);

    EmployerTime lire(long id);

    List<EmployerTime> lire();

   // EmployerTime creerListjustificationDansEmployerTime(EmployerTime employerTime);
    Long calculateTotalOccupiedTime(long id, LocalDate jour,long congesId);

   EmployerTime updateHeureDepart(long id ,LocalDate jour);

   String suprimer (long id);


}
