package com.kosmos.hospital.jair.Hospital.controllers;

import com.kosmos.hospital.jair.Hospital.models.Cita;
import com.kosmos.hospital.jair.Hospital.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return citaService.getCitaById(id);
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.saveCita(cita);
    }

    @PutMapping("/{id}")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        cita.setId(id);
        return citaService.updateCita(cita);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
    }

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Cita> getCitasByDoctorAndFecha(@PathVariable Long doctorId, @RequestParam LocalDateTime fecha) {
        return citaService.getCitasByDoctorAndFecha(doctorId, fecha);
    }

    @GetMapping("/consultorio/{consultorioId}")
    public List<Cita> getCitasByConsultorioAndFecha(@PathVariable Long consultorioId, @RequestParam LocalDateTime fecha) {
        return citaService.getCitasByConsultorioAndFecha(consultorioId, fecha);
    }

    @GetMapping("/fecha")
    public List<Cita> getCitasByFecha(@RequestParam LocalDateTime fecha) {
        return citaService.getCitasByFecha(fecha);
    }
}
