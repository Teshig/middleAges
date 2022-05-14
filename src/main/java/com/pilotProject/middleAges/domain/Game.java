package com.pilotProject.middleAges.domain;

import com.pilotProject.middleAges.domain.world.commands.CommandFactory;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse;
import com.pilotProject.middleAges.domain.world.commands.ICommand;
import com.pilotProject.middleAges.domain.world.World;
import com.pilotProject.middleAges.domain.world.WorldInitializer;

import java.util.ResourceBundle;

import org.springframework.web.util.HtmlUtils;

public class Game {

  private final World world;
  private final CommandFactory commandFactory;
  private final ResourceBundle resourceBundle;

  public Game(
      WorldInitializer worldI,
      CommandFactory commandFactory,
      ResourceBundle resourceBundle) {
    this.world = worldI.createWorld();
    this.commandFactory = commandFactory;
    this.resourceBundle = resourceBundle;
  }

  public GameResponse processCommand(String personId, String[] commandTokens) {
    ICommand command = commandFactory.getCommand(commandTokens);
    CommandResponse commandResponse = command.execute(personId, world, commandTokens);

    GameResponse gameResponse = new GameResponse();
    gameResponse.setMessage(getMessageForKey(commandResponse));
    gameResponse.setPersonState(commandResponse.getPersonState());
    gameResponse.setRoomState(commandResponse.getRoomState());

    return gameResponse;
  }

  private String getMessageForKey(CommandResponse commandResponse) {
    return HtmlUtils.htmlEscape(resourceBundle.getString(commandResponse.getKeyForDisplaying()));
  }
}
