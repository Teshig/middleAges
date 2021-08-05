package com.pilotProject.middleAges.engine.commands;

import static com.pilotProject.middleAges.engine.commands.CommandName.EAST;
import static com.pilotProject.middleAges.engine.commands.CommandName.NORTH;
import static com.pilotProject.middleAges.engine.commands.CommandName.NO_SUCH_COMMAND;
import static com.pilotProject.middleAges.engine.commands.CommandName.SOUTH;
import static com.pilotProject.middleAges.engine.commands.CommandName.WEST;

import com.pilotProject.middleAges.engine.commands.commandset.MovementCommand;
import com.pilotProject.middleAges.engine.commands.commandset.NoSuchCommand;
import com.pilotProject.middleAges.engine.entity.ExitDirection;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
  private static final Map<CommandName, ICommand> commands = new HashMap<>();

  static {
    commands.put(NO_SUCH_COMMAND, new NoSuchCommand());
    commands.put(NORTH, new MovementCommand(ExitDirection.NORTH));
    commands.put(EAST, new MovementCommand(ExitDirection.EAST));
    commands.put(SOUTH, new MovementCommand(ExitDirection.SOUTH));
    commands.put(WEST, new MovementCommand(ExitDirection.WEST));
  }

  public ICommand getCommand(String[] commandTokens) {
    if (commandTokens.length == 0) {
      return commands.get(NO_SUCH_COMMAND);
    }
    CommandName commandName = CommandName.fromString(commandTokens[0]);
    return commands.get(commandName);
  }
}
