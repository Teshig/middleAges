package com.pilotProject.middleAges.in;

import com.pilotProject.middleAges.engine.world.commands.CommandName;
import lombok.Data;

@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Command {
  private String personId;
  private CommandName command;
}

/*
{
  "personId": "myPerson",
  "command": "north"
}

*/