package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import lombok.Data;

@Data
public class WorldState {
  private boolean success;
  private Person playerState;
  private Room roomState;
}
