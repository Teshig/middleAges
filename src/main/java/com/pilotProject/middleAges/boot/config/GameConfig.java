package com.pilotProject.middleAges.boot.config;

import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import com.pilotProject.middleAges.adapter.out.mongo.service.RoomServiceImpl;
import com.pilotProject.middleAges.domain.Game;
import com.pilotProject.middleAges.domain.external.service.PlayerService;
import com.pilotProject.middleAges.domain.world.commands.CommandFactory;
import com.pilotProject.middleAges.domain.external.service.RoomService;
import com.pilotProject.middleAges.domain.world.WorldInitializer;
import com.pilotProject.middleAges.boot.utils.UTF8Control;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class GameConfig {

  public static final String TRANSLATIONS_FILE_NAME = "message";
  public static final String RU = "ru";
  public static final String ANY_COUNTRY = "";

  @Bean
  public Game game(WorldInitializer worldInitializer, CommandFactory commandFactory) {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(
        TRANSLATIONS_FILE_NAME,
        new Locale(RU, ANY_COUNTRY),
        new UTF8Control());

    return new Game(worldInitializer, commandFactory, resourceBundle);
  }

  @Bean
  public WorldInitializer worldInitializer(RoomService roomService) {
    return new WorldInitializer(roomService);
  }

  @Bean
  public CommandFactory commandFactory(PlayerService playerService) {
    return new CommandFactory(playerService);
  }

  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }
}
