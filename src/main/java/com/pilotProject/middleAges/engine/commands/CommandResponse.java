package com.pilotProject.middleAges.engine.commands;

import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import lombok.Data;

@Data
public class CommandResponse {
  private Room roomState;
  private Person personState;
  private String keyForDisplaying;
}
