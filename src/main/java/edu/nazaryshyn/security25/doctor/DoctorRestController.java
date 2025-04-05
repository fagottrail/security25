package edu.nazaryshyn.security25.doctor;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class DoctorRestController
  @version 1.0.0
  @since 30.03.2025 - 21.23
*/

import lombok.AllArgsConstructor;
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

    @GetMapping("/user")
    public String helloUser() {
        return "You are common user or higher!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "You are a god of this app, you are admin)";
    }

    @GetMapping("/unauthenticated")
    public String helloUnauthenticated() {
        return "Who are you man?";
    }
}
