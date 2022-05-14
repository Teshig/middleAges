package com.pilotProject.middleAges.domain.world.commands;

import java.util.HashMap;
import java.util.Map;

public enum CommandName {
  NO_SUCH_COMMAND("no_command"),
  LOGIN("login"),
  NORTH("north"),
  EAST("east"),
  SOUTH("south"),
  WEST("west");

  private final String value;

  private CommandName(String value) {
    this.value = value;
    CommandAliases.lookup.put(value, this);
  }

  public static CommandName fromString(String value) {
    CommandName commandName = CommandAliases.lookup.get(value);
    return commandName == null
        ? NO_SUCH_COMMAND
        : commandName;
  }

  static class CommandAliases {
    public static final Map<String, CommandName> lookup = new HashMap<>();
  }
}
