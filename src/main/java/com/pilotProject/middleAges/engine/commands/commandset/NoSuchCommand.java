package com.pilotProject.middleAges.engine.commands;

import com.pilotProject.middleAges.engine.world.World;

public class NoSuchCommand implements ICommand {

  @Override
  public CommandResponse execute(World world, String[] commandTokens) {
    return null;
  }
}
