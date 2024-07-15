package com.kosmos.hospital.jair.Hospital.controllers;

import com.kosmos.hospital.jair.Hospital.models.Consultorio;
import com.kosmos.hospital.jair.Hospital.services.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllConsultorios(){
        try {
            return ResponseEntity.ok(consultorioService.getAllConsultorios());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los consultorios");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsultorioById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(consultorioService.getConsultorioById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener el consultorio: " + e.getMessage());
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> saveConsultorio(@RequestBody Consultorio consultorio){
        try {
            return ResponseEntity.ok(consultorioService.saveConsultorio(consultorio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el consultorio");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteConsultorio(Long id){
        try {
            consultorioService.deleteConsultorio(id);
            return ResponseEntity.ok("Consultorio eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el consultorio");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateConsultorio(){
        try {
            return ResponseEntity.ok(consultorioService.updateConsultorio(null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el consultorio");
        }
    }
}
