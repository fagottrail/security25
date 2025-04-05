package edu.nazaryshyn.security25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class AuditionConfig
  @version 1.0.0
  @since 05.04.2025 - 20.33
*/

@EnableMongoAuditing
@Configuration
public class AuditionConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
