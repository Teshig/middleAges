package com.pilotProject.middleAges.adapter.in.controllers;

import com.pilotProject.middleAges.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
  private static final String BLANK = " ";

  private final Game game;

  @Autowired
  public MainController(Game game) {
    this.game = game;
  }

//  @MessageMapping("/hello")
//  @SendTo("/topic/greetings")
//  public GameStateResponse greeting(CommandMessage message) {
//    GameResponse response = game.processCommand(splitStringToTokens(message.getCommand()));
//    return new GameStateResponse(response.getMessage(), response.getPersonState(), response.getRoomState());
//  }
//
//  private String[] splitStringToTokens(String commandString) {
//    if (Strings.isEmpty(commandString)) {
//      return new String[0];
//    }
//    return commandString.trim().split(BLANK);
//  }

}
