package com.pilotProject.middleAges.engine.commands.commandset;

import com.pilotProject.middleAges.engine.MessageKeys;
import com.pilotProject.middleAges.engine.commands.CommandResponse;
import com.pilotProject.middleAges.engine.commands.ICommand;
import com.pilotProject.middleAges.engine.entity.ExitDirection;
import com.pilotProject.middleAges.engine.world.World;
import com.pilotProject.middleAges.engine.world.WorldState;

public class MovementCommand implements ICommand {
  private final ExitDirection direction;

  public MovementCommand(ExitDirection direction) {
    this.direction = direction;
  }

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {
    WorldState worldResponse = world.movePlayerTo(personId, direction);
    CommandResponse commandResponse = new CommandResponse();

    if (worldResponse.isSuccess()) {
      commandResponse.setKeyForDisplaying(MessageKeys.ACTION_MOVEMENT + direction.toString());
    } else {
      commandResponse.setKeyForDisplaying(MessageKeys.ACTION_FAILED_MOVE.toString());
    }

    commandResponse.setRoomState(worldResponse.getRoomState());
    commandResponse.setPersonState(worldResponse.getPlayerState());
    return commandResponse;
  }
}
