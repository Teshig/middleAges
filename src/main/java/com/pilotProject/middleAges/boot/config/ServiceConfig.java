package com.pilotProject.middleAges.boot.config;

import com.pilotProject.middleAges.adapter.out.jpa.repository.PlayerJpaRepository;
import com.pilotProject.middleAges.adapter.out.jpa.service.PlayerServiceImpl;
import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import com.pilotProject.middleAges.adapter.out.mongo.service.RoomServiceImpl;
import com.pilotProject.middleAges.domain.external.service.PlayerService;
import com.pilotProject.middleAges.domain.external.service.RoomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Bean
  public RoomService roomService(RoomMongoRepository repository) {
    return new RoomServiceImpl(repository);
  }

  @Bean
  public PlayerService playerService(PlayerJpaRepository repository) {
    return new PlayerServiceImpl(repository);
  }
}
