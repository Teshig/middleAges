package com.pilotProject.middleAges.config;

import com.pilotProject.middleAges.engine.Game;
import com.pilotProject.middleAges.engine.world.commands.CommandFactory;
import com.pilotProject.middleAges.engine.repository.RoomRepository;
import com.pilotProject.middleAges.engine.world.WorldInitializer;
import com.pilotProject.middleAges.utils.UTF8Control;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class Beans {

  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

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
