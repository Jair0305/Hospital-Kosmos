package com.kosmos.hospital.jair.Hospital.repositories;

import com.kosmos.hospital.jair.Hospital.models.Cita;
import com.kosmos.hospital.jair.Hospital.models.Consultorio;
import com.kosmos.hospital.jair.Hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    boolean existsByConsultorioAndHorario(Consultorio consultorio, LocalDateTime horario);
    boolean existsByDoctorAndHorario(Doctor doctor, LocalDateTime horario);
    boolean existsByNombreDelPacienteAndHorario(String nombreDelPaciente, LocalDateTime horario);
    @Query("SELECT COUNT(c) FROM Cita c WHERE c.doctor = :doctor AND FUNCTION('DATE', c.horario) = :fecha")
    int countByDoctorAndFecha(Doctor doctor, LocalDate fecha);
    List<Cita> findByHorarioBetweenAndConsultorioId(LocalDateTime start, LocalDateTime end, Long consultorioId);
    List<Cita> findByHorarioBetweenAndDoctorId(LocalDateTime start, LocalDateTime end, Long doctorId);


    boolean existsByNombreDelPacienteAndHorarioBetween(String nombreDelPaciente, LocalDateTime dosHorasAntes, LocalDateTime dosHorasDespues);

    List<Cita> findByHorarioBetween(LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
