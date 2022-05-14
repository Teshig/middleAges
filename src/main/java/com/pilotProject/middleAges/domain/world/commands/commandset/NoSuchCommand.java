package com.pilotProject.middleAges.domain.world.commands.commandset;

import com.pilotProject.middleAges.domain.valueobject.MessageKeys;
import com.pilotProject.middleAges.domain.world.World;
import com.pilotProject.middleAges.domain.world.commands.CommandResponse;
import com.pilotProject.middleAges.domain.world.commands.ICommand;

public class NoSuchCommand implements ICommand {

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {

    return CommandResponse.builder()
        .keyForDisplaying(MessageKeys.ACTION_NO_SUCH_ACTION.toString())
        .build();
  }
}
