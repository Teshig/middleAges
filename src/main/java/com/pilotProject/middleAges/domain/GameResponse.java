package com.pilotProject.middleAges.domain;

import com.pilotProject.middleAges.domain.entity.Person;
import com.pilotProject.middleAges.domain.entity.Room;
import lombok.Data;

@Data
public class GameResponse {
  private String message;
  private Person personState;
  private Room roomState;
}
