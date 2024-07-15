package com.kosmos.hospital.jair.Hospital.repositories;

import com.kosmos.hospital.jair.Hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
