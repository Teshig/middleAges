package com.pilotProject.middleAges.engine.world.commands.commandset;

import com.pilotProject.middleAges.engine.MessageKeys;
import com.pilotProject.middleAges.engine.world.commands.CommandResponse;
import com.pilotProject.middleAges.engine.world.commands.ICommand;
import com.pilotProject.middleAges.engine.world.World;

public class NoSuchCommand implements ICommand {

  @Override
  public CommandResponse execute(String personId, World world, String[] commandTokens) {
    CommandResponse commandResponse = new CommandResponse();
    commandResponse.setKeyForDisplaying(MessageKeys.ACTION_NO_SUCH_ACTION.toString());
    return commandResponse;
  }
}
