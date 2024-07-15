package com.kosmos.hospital.jair.Hospital.controllers;

import com.kosmos.hospital.jair.Hospital.models.Doctor;
import com.kosmos.hospital.jair.Hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllDoctors(){
        try {
            return ResponseEntity.ok(doctorService.getAllDoctors());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los doctores");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(doctorService.getDoctorById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener el doctor");
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor){
        try {
            return ResponseEntity.ok(doctorService.saveDoctor(doctor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el doctor");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteDoctor(Long id){
        try {
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok("Doctor eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el doctor");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateDoctor(){
        try {
            return ResponseEntity.ok(doctorService.updateDoctor(null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el doctor");
        }
    }
}
