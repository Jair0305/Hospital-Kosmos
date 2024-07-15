package com.kosmos.hospital.jair.Hospital.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultorios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numeroDeConsultorio;
    private Long piso;
}
