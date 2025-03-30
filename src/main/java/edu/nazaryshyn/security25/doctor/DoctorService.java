package edu.nazaryshyn.security25.doctor;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class DoctorService
  @version 1.0.0
  @since 30.03.2025 - 21.22
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    private List<Doctor> doctors;

    @PostConstruct
    void init() {
        doctors.add(new Doctor("1", "Ihor", "5453425342", "Cardiologist", 4));
        doctors.add(new Doctor("2", "Vasyl", "53252352", "Neurologist", 4));
        doctors.add(new Doctor("3", "Pedro", "97874937574", "Dermatologist ", 22));
        repository.saveAll(doctors);
    }

    public List<Doctor> getAll() {
        return repository.findAll();
    }

    public Doctor getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor update(Doctor doctor) {
        return repository.save(doctor);
    }
}
