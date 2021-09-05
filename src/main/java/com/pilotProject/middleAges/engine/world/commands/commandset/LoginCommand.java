package com.pilotProject.middleAges.engine.world.commands.commandset;

import com.pilotProject.middleAges.engine.MessageKeys;
import com.pilotProject.middleAges.engine.world.commands.CommandResponse;
import com.pilotProject.middleAges.engine.world.commands.ICommand;
import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.world.World;
import com.pilotProject.middleAges.engine.world.WorldState;
import java.util.Map;

public class LoginCommand implements ICommand {

  private final Map<String, Person> personDb;

  public LoginCommand(
      Map<String, Person> personDb) {
    this.personDb = personDb;
  }

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {
    WorldState worldResponse = world.enterTheWorld(personDb.get(personId));
    CommandResponse commandResponse = new CommandResponse();

    if (worldResponse.isSuccess()) {
      commandResponse.setKeyForDisplaying(MessageKeys.ACTION_WOKE_UP.toString());
    }

    commandResponse.setRoomState(worldResponse.getRoomState());
    commandResponse.setPersonState(worldResponse.getPlayerState());
    return commandResponse;
  }
}
