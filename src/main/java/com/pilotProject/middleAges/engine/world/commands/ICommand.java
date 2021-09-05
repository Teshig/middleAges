package com.pilotProject.middleAges.engine.world.commands;

import com.pilotProject.middleAges.engine.world.World;

public interface ICommand {
  CommandResponse execute(String personId, World world, String[] commandTokens);
}
