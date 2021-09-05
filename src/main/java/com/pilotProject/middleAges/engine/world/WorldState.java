package com.pilotProject.middleAges.engine.world;

import com.pilotProject.middleAges.engine.model.Person;
import com.pilotProject.middleAges.engine.model.Room;
import lombok.Data;

@Data
public class WorldState {
  private final boolean success;
  private final Person playerState;
  private final Room roomState;
}
