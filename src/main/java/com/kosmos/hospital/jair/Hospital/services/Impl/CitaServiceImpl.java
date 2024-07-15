package com.kosmos.hospital.jair.Hospital.services.Impl;

import com.kosmos.hospital.jair.Hospital.models.Cita;
import com.kosmos.hospital.jair.Hospital.repositories.CitaRepository;
import com.kosmos.hospital.jair.Hospital.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita getCitaById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita saveCita(Cita cita) {
        if (citaRepository.existsByConsultorioAndHorario(cita.getConsultorio(), cita.getHorario())) {
            throw new IllegalArgumentException("Ya existe una cita en este consultorio a la misma hora");
        }
        if (citaRepository.existsByDoctorAndHorario(cita.getDoctor(), cita.getHorario())) {
            throw new IllegalArgumentException("El doctor ya tiene una cita a esta hora");
        }
        LocalDateTime dosHorasAntes = cita.getHorario().minusHours(2);
        LocalDateTime dosHorasDespues = cita.getHorario().plusHours(2);
        if (citaRepository.existsByNombreDelPacienteAndHorarioBetween(cita.getNombreDelPaciente(), dosHorasAntes, dosHorasDespues)) {
            throw new IllegalArgumentException("El paciente ya tiene una cita a esta hora o con menos de 2 horas de diferencia");
        }
        if (citaRepository.countByDoctorAndFecha(cita.getDoctor(), cita.getHorario().toLocalDate()) >= 8) {
            throw new IllegalArgumentException("El doctor no puede tener más de 8 citas en el día");
        }
        return citaRepository.save(cita);
    }

    @Override
    public Cita updateCita(Cita cita) {
        return saveCita(cita);  // Reutilizamos las mismas validaciones de saveCita
    }

    @Override
    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public List<Cita> getCitasByDoctorAndFecha(Long doctorId, LocalDateTime fecha) {
        return citaRepository.findByHorarioBetweenAndDoctorId(fecha.withHour(0).withMinute(0).withSecond(0), fecha.withHour(23).withMinute(59).withSecond(59), doctorId);
    }

    @Override
    public List<Cita> getCitasByConsultorioAndFecha(Long consultorioId, LocalDateTime fecha) {
        return citaRepository.findByHorarioBetweenAndConsultorioId(fecha.withHour(0).withMinute(0).withSecond(0), fecha.withHour(23).withMinute(59).withSecond(59), consultorioId);
    }

    @Override
    public List<Cita> getCitasByFecha(LocalDateTime fecha) {
        return citaRepository.findByHorarioBetween(fecha.withHour(0).withMinute(0).withSecond(0), fecha.withHour(23).withMinute(59).withSecond(59));
    }
}
