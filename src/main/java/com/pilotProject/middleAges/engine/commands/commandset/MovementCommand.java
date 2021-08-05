package com.pilotProject.middleAges.engine.commands;

import com.pilotProject.middleAges.engine.entity.CommandResult;
import com.pilotProject.middleAges.engine.entity.ExitDirection;
import com.pilotProject.middleAges.engine.world.World;
import com.pilotProject.middleAges.engine.world.WorldState;

public class MovementCommand implements ICommand {
  private final ExitDirection direction;

  public MovementCommand(ExitDirection direction) {
    this.direction = direction;
  }

  @Override
  public CommandResponse execute(World world, String[] commandTokens) {
    WorldState response = world.movePlayerTo("firstPerson", direction);
    String direction;
    String message;
    switch ("name") {
      case "север":
        direction = "NORTH";
        message = "вы поплелись на север!";
        break;
      case "восток":
        direction = "EAST";
        message = "вы поплелись на восток!";
        break;
      case "юг":
        direction = "SOUTH";
        message = "вы поплелись на юг!";
        break;
      case "запад":
        direction = "WEST";
        message = "вы поплелись на запад!";
        break;
      default:
        direction = "";
        message = "Вы не можее туда пройти!";
        break;
    }
//    CommandResult response = world.movePlayerTo("firstPerson", direction);
//    if (!response.isSuccess()) {
//      message = "Вы не можее туда пройти!";
//    }
    return null;
  }
}
