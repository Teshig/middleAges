package com.pilotProject.middleAges.domain.world.commands;

import static com.pilotProject.middleAges.domain.world.commands.CommandName.EAST;
import static com.pilotProject.middleAges.domain.world.commands.CommandName.LOGIN;
import static com.pilotProject.middleAges.domain.world.commands.CommandName.NORTH;
import static com.pilotProject.middleAges.domain.world.commands.CommandName.NO_SUCH_COMMAND;
import static com.pilotProject.middleAges.domain.world.commands.CommandName.SOUTH;
import static com.pilotProject.middleAges.domain.world.commands.CommandName.WEST;

import com.pilotProject.middleAges.domain.external.service.PlayerService;
import com.pilotProject.middleAges.domain.world.commands.commandset.LoginCommand;
import com.pilotProject.middleAges.domain.world.commands.commandset.MovementCommand;
import com.pilotProject.middleAges.domain.world.commands.commandset.NoSuchCommand;
import com.pilotProject.middleAges.domain.entity.ExitDirection;
import com.pilotProject.middleAges.domain.entity.Person;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class CommandFactory {
  private static final Map<CommandName, ICommand> commands = new HashMap<>();

  private final PlayerService personDb;

  static {
    commands.put(NO_SUCH_COMMAND, new NoSuchCommand());
    commands.put(LOGIN, new LoginCommand(personDb));
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
