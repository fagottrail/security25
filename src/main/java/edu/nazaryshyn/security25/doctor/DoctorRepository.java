package edu.nazaryshyn.security25.doctor;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class DoctorRepository
  @version 1.0.0
  @since 30.03.2025 - 21.20
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
