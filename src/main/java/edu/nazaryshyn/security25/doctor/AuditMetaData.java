package edu.nazaryshyn.security25.doctor;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class AuditMetaData
  @version 1.0.0
  @since 05.04.2025 - 20.27
*/

@Data
public class AuditMetaData {

    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
}
