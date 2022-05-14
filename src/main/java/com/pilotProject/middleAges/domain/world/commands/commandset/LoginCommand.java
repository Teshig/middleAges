package com.pilotProject.middleAges.domain.world.commands.commandset;

import com.pilotProject.middleAges.domain.external.service.PlayerService;
import com.pilotProject.middleAges.domain.valueobject.MessageKeys;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse.CommandResponseBuilder;
import com.pilotProject.middleAges.domain.world.commands.ICommand;
import com.pilotProject.middleAges.domain.entity.Person;
import com.pilotProject.middleAges.domain.world.World;
import com.pilotProject.middleAges.domain.world.WorldState;
import java.util.Map;

public class LoginCommand implements ICommand {

  private final PlayerService personDb;

  public LoginCommand(PlayerService personDb) {
    this.personDb = personDb;
  }

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {
    WorldState worldResponse = world.enterTheWorld(personDb.login(commandTokens[0], commandTokens[1]));
    CommandResponseBuilder responseBuilder = CommandResponse.builder();

    if (worldResponse.isSuccess()) {
      responseBuilder.keyForDisplaying(MessageKeys.ACTION_WOKE_UP.toString());
    }

    return responseBuilder
        .roomState(worldResponse.getRoomState())
        .personState(worldResponse.getPlayerState())
        .build();
  }
}
