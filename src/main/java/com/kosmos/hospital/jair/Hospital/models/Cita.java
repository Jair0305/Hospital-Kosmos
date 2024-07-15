package com.kosmos.hospital.jair.Hospital.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime horario;

    private String nombreDelPaciente;

    @ManyToOne
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id")
    private Doctor doctor;

}
