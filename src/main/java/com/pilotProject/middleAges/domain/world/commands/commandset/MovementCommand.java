package com.pilotProject.middleAges.domain.world.commands.commandset;

import com.pilotProject.middleAges.domain.valueobject.MessageKeys;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse.CommandResponseBuilder;
import com.pilotProject.middleAges.domain.world.commands.ICommand;
import com.pilotProject.middleAges.domain.entity.ExitDirection;
import com.pilotProject.middleAges.domain.world.World;
import com.pilotProject.middleAges.domain.world.WorldState;

public class MovementCommand implements ICommand {
  private final ExitDirection direction;

  public MovementCommand(ExitDirection direction) {
    this.direction = direction;
  }

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {
    WorldState worldResponse = world.movePlayerTo(personId, direction);
    CommandResponseBuilder responseBuilder = CommandResponse.builder();

    responseBuilder.roomState(worldResponse.getRoomState());
    responseBuilder.personState(worldResponse.getPlayerState());

    setKeyForDisplaying(worldResponse, responseBuilder);

    return responseBuilder.build();
  }

  private void setKeyForDisplaying(WorldState worldResponse, CommandResponseBuilder responseBuilder) {
    if (worldResponse.isSuccess()) {
      responseBuilder.keyForDisplaying(MessageKeys.ACTION_MOVEMENT + direction.toString());
    } else {
      responseBuilder.keyForDisplaying(MessageKeys.ACTION_FAILED_MOVE.toString());
    }
  }
}
