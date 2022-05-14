package com.pilotProject.middleAges.domain.world.commands;

import com.pilotProject.middleAges.domain.entity.Person;
import com.pilotProject.middleAges.domain.entity.Room;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandResponse {
  private Room roomState;
  private Person personState;
  private String keyForDisplaying;
}
