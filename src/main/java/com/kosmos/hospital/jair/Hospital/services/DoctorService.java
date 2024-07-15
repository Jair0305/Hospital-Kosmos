package com.kosmos.hospital.jair.Hospital.services;

import com.kosmos.hospital.jair.Hospital.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    Doctor getDoctorById(Long id);
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    List<Doctor> getAllDoctors();
}
