package com.pilotProject.middleAges.engine.world.commands;

import static com.pilotProject.middleAges.engine.world.commands.CommandName.EAST;
import static com.pilotProject.middleAges.engine.world.commands.CommandName.LOGIN;
import static com.pilotProject.middleAges.engine.world.commands.CommandName.NORTH;
import static com.pilotProject.middleAges.engine.world.commands.CommandName.NO_SUCH_COMMAND;
import static com.pilotProject.middleAges.engine.world.commands.CommandName.SOUTH;
import static com.pilotProject.middleAges.engine.world.commands.CommandName.WEST;

import com.pilotProject.middleAges.engine.world.commands.commandset.LoginCommand;
import com.pilotProject.middleAges.engine.world.commands.commandset.MovementCommand;
import com.pilotProject.middleAges.engine.world.commands.commandset.NoSuchCommand;
import com.pilotProject.middleAges.engine.model.ExitDirection;
import com.pilotProject.middleAges.engine.model.Person;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
  private static final Map<CommandName, ICommand> commands = new HashMap<>();
  private static final Map<String, Person> personDb = new HashMap<>();

  static {
    initializePersonDb();
    commands.put(NO_SUCH_COMMAND, new NoSuchCommand());
    commands.put(LOGIN, new LoginCommand(personDb));
    commands.put(NORTH, new MovementCommand(ExitDirection.NORTH));
    commands.put(EAST, new MovementCommand(ExitDirection.EAST));
    commands.put(SOUTH, new MovementCommand(ExitDirection.SOUTH));
    commands.put(WEST, new MovementCommand(ExitDirection.WEST));
  }

  private static void initializePersonDb() {
    personDb.put("Bob", new Person("Bob", "00010000"));
    personDb.put("Jerry", new Person("Jerry", "00010000"));
  }

  public ICommand getCommand(String[] commandTokens) {
    if (commandTokens.length == 0) {
      return commands.get(NO_SUCH_COMMAND);
    }
    CommandName commandName = CommandName.fromString(commandTokens[0]);
    return commands.get(commandName);
  }
}
