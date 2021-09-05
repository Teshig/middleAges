package com.pilotProject.middleAges.config;

import com.pilotProject.middleAges.engine.repository.RoomRepository;
import com.pilotProject.middleAges.in.jpa.mongo.RoomRepositoryImpl;
import com.pilotProject.middleAges.in.jpa.mongo.repository.RoomJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.pilotProject.middleAges.in.jpa.mongo.repository")
@EntityScan("com.pilotProject.middleAges.in.jpa.mongo.entity")
public class RepositoryConfig {

  @Bean
  public RoomRepository roomRepository(RoomJpaRepository roomJpaRepository) {
    return new RoomRepositoryImpl(roomJpaRepository);
  }
}
