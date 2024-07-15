package com.kosmos.hospital.jair.Hospital.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;


}
