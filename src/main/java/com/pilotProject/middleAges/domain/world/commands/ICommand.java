package com.pilotProject.middleAges.domain.world.commands;

import com.pilotProject.middleAges.domain.world.World;

public interface ICommand {
  CommandResponse execute(String personId, World world, String[] commandTokens);
}
