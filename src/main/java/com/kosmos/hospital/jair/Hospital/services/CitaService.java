package com.kosmos.hospital.jair.Hospital.services;

import com.kosmos.hospital.jair.Hospital.models.Cita;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface CitaService {
    Cita getCitaById(Long id);
    Cita saveCita(Cita cita);
    Cita updateCita(Cita cita);
    void deleteCita(Long id);
    List<Cita> getAllCitas();
    List<Cita> getCitasByDoctorAndFecha(Long doctorId, LocalDateTime fecha);
    List<Cita> getCitasByConsultorioAndFecha(Long consultorioId, LocalDateTime fecha);
    List<Cita> getCitasByFecha(LocalDateTime fecha);
}
