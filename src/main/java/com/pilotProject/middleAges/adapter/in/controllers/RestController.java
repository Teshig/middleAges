package com.pilotProject.middleAges.adapter.in.controllers;

import com.pilotProject.middleAges.domain.Game;
import com.pilotProject.middleAges.domain.GameResponse;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.util.Strings;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
  public void extra(CommandMessage message, Principal principal) {
    System.out.println(principal.getName());
    GameResponse response = game.processCommand(message.getPlayerId(), splitStringToTokens(message.getCommand()));
//    template.convertAndSend("/personal-channel/" + message.getPlayerId(), new GameStateResponse("just extra channel", new Person("1", "qwqer"), new Room("1", "title", "descriptio", new HashMap(), new HashMap<>())));
    template.convertAndSend("/personal-channel/" + message.getPlayerId(), new GameStateResponse(response.getMessage(), response.getPersonState(), response.getRoomState()));
  }

  @PostMapping(path = "/login")
//  public String login(@RequestBody LoginRequest request, Principal principal) throws JSONException {
  public String login(@RequestBody LoginRequest request) throws JSONException {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (!(authentication instanceof AnonymousAuthenticationToken)) {
//      UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
//      System.out.println("User principal name =" + userPrincipal.getUsername());
//      System.out.println("Is user enabled =" + userPrincipal.isEnabled());
//    }
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
