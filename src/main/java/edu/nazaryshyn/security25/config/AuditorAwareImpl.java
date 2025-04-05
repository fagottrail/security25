package edu.nazaryshyn.security25.config;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class AuditorAwareImpl
  @version 1.0.0
  @since 05.04.2025 - 20.31
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

 @Override
 public Optional<String> getCurrentAuditor() {
  return Optional.of(System.getProperty("user.name"));
 }

}
