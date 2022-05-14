package com.pilotProject.middleAges.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.pilotProject.middleAges.adapter.out.jpa.repository")
@EntityScan("com.pilotProject.middleAges.adapter.out.jpa.entity")
public class JpaConfig {

}
