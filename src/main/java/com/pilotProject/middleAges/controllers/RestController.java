package com.pilotProject.middleAges.controllers;

import com.pilotProject.middleAges.engine.Game;
import com.pilotProject.middleAges.engine.GameResponse;
import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.util.Strings;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  private static final String BLANK = " ";
  private final Game game;

  private final SimpMessagingTemplate template;
  private final Map<String, String> hashedKey = new HashMap<>();
  private static final Map<String, String> userDb = new HashMap<>();
  static {
    userDb.put("Bob", "pass1");
    userDb.put("Jerry", "pass2");
  }

  @Autowired
  public RestController(
      SimpMessagingTemplate template,
      Game game) {
    this.template = template;
    this.game = game;
  }

  @MessageMapping("/command")
  public void extra(CommandMessage message) {

    GameResponse response = game.processCommand(message.getPlayerId(), splitStringToTokens(message.getCommand()));
//    template.convertAndSend("/personal-channel/" + message.getPlayerId(), new GameStateResponse("just extra channel", new Person("1", "qwqer"), new Room("1", "title", "descriptio", new HashMap(), new HashMap<>())));
    template.convertAndSend("/personal-channel/" + message.getPlayerId(), new GameStateResponse(response.getMessage(), response.getPersonState(), response.getRoomState()));
  }

  @PostMapping(path = "/login")
  public String login(@RequestBody LoginRequest request) throws JSONException {
    String userPassword = userDb.get(request.getName());
    if (Strings.isEmpty(userPassword) || !userPassword.equals(request.getPassword())) {
      return "{}";
    }
    System.out.println(request.getName());
    hashedKey.put(request.getName(), request.getName());
    String[] command = {"login"};
    GameResponse response = game.processCommand(request.getName(), command);
    template.convertAndSend("/personal-channel/" + request.getName(), new GameStateResponse(response.getMessage(), response.getPersonState(), response.getRoomState()));
    return "{\"id\": \"" + request.getName() + "\", \"value\": \"OK!\"}";
  }

  private String[] splitStringToTokens(String commandString) {
    if (Strings.isEmpty(commandString)) {
      return new String[0];
    }
    return commandString.trim().split(BLANK);
  }
}
