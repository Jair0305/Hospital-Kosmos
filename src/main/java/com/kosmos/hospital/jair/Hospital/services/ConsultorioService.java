package com.kosmos.hospital.jair.Hospital.services;

import com.kosmos.hospital.jair.Hospital.models.Consultorio;
import com.kosmos.hospital.jair.Hospital.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultorioService {


    Consultorio getConsultorioById(Long id);
    Consultorio saveConsultorio(Consultorio consultorio);
    Consultorio updateConsultorio(Consultorio consultorio);
    void deleteConsultorio(Long id);
    List<Consultorio> getAllConsultorios();
}
