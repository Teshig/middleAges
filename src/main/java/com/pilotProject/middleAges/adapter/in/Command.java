package com.pilotProject.middleAges.adapter.in;

import com.pilotProject.middleAges.domain.world.commands.CommandName;
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