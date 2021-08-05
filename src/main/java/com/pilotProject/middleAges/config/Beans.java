package com.pilotProject.middleAges.config;

import com.pilotProject.middleAges.WorldInitializer;
import com.pilotProject.middleAges.engine.Game;
import com.pilotProject.middleAges.engine.commands.CommandFactory;
import com.pilotProject.middleAges.mongo.repository.RoomRepository;
import com.pilotProject.middleAges.utils.UTF8Control;
import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

  @Bean
  public Game game(WorldInitializer worldInitializer) {
    CommandFactory commandFactory = new CommandFactory();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("ru", ""), new UTF8Control());
    return new Game(worldInitializer, commandFactory, resourceBundle);
  }

  @Bean
  public WorldInitializer worldInitializer(RoomRepository roomRepository) {
    return new WorldInitializer(roomRepository);
  }
}
