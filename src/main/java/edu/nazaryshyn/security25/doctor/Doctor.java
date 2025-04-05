package edu.nazaryshyn.security25.doctor;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class Doctor
  @version 1.0.0
  @since 30.03.2025 - 21.16
*/

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Doctor extends AuditMetaData{
    @Id
    private String id;
    private String name;
    private String phone;
    private String specialty;
    private int experienceYears;

    public Doctor(String name, String phone, String specialty, int experienceYears) {
        this.name = name;
        this.phone = phone;
        this.specialty = specialty;
        this.experienceYears = experienceYears;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Doctor doctor)) return false;

        return getId().equals(doctor.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
