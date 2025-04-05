package edu.nazaryshyn.security25.doctor;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class DoctorRestController
  @version 1.0.0
  @since 30.03.2025 - 21.23
*/

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@AllArgsConstructor
public class DoctorRestController {

    private final DoctorService service;

    @GetMapping
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getOne(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Doctor save(@RequestBody Doctor doctor) {
        return service.create(doctor);
    }

    @PutMapping
    public Doctor update(@RequestBody Doctor doctor) {
        return service.update(doctor);
    }

    @GetMapping("/only-user")
    @PreAuthorize("hasRole('USER')")
    public String helloUser() {
        return "You are common user";
    }

    @GetMapping("/superadmin-and-admin")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public String helloAdmin() {
        return "You are superadmin or admin";
    }

    @GetMapping("/only-superadmin")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public String helloSuperadmin() {
        return "You are superadmin)";
    }

    @GetMapping("/anyone")
    public String helloUnauthenticated() {
        return "You can be anyone";
    }
}
