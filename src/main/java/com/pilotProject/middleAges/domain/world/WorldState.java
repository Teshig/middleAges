package com.pilotProject.middleAges.domain.world;

import com.pilotProject.middleAges.domain.entity.Player;
import com.pilotProject.middleAges.domain.entity.Room;
import lombok.Data;

@Data
public class WorldState {
  private final boolean success;
  private final Player playerState;
  private final Room roomState;
}
