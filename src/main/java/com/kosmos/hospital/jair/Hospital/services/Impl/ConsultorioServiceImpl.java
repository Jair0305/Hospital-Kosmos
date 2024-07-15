package com.kosmos.hospital.jair.Hospital.services.Impl;

import com.kosmos.hospital.jair.Hospital.models.Consultorio;
import com.kosmos.hospital.jair.Hospital.repositories.ConsultorioRepository;
import com.kosmos.hospital.jair.Hospital.services.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultorioServiceImpl implements ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    public ConsultorioServiceImpl(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    @Override
    public Consultorio getConsultorioById(Long id) {
        return consultorioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Consultorio no encontrado con ID: " + id));
    }

    @Override
    public Consultorio saveConsultorio(Consultorio consultorio) {
        if (consultorio == null) {
            throw new IllegalArgumentException("El consultorio no puede ser nulo");
        }
        return consultorioRepository.save(consultorio);
    }

    @Override
    public void deleteConsultorio(Long id) {
        if (!consultorioRepository.existsById(id)) {
            throw new NoSuchElementException("Consultorio no encontrado con ID: " + id);
        }
        consultorioRepository.deleteById(id);
    }

    @Override
    public Consultorio updateConsultorio(Consultorio consultorio) {
        if (consultorio == null || consultorio.getId() == null) {
            throw new IllegalArgumentException("El consultorio o su ID no pueden ser nulos");
        }
        if (!consultorioRepository.existsById(consultorio.getId())) {
            throw new NoSuchElementException("Consultorio no encontrado con ID: " + consultorio.getId());
        }
        return consultorioRepository.save(consultorio);
    }

    @Override
    public List<Consultorio> getAllConsultorios() {
        return consultorioRepository.findAll();
    }
}
