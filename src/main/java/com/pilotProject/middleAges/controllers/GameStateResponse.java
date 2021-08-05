package com.pilotProject.middleAges.controllers;

import com.pilotProject.middleAges.engine.entity.Person;
import com.pilotProject.middleAges.engine.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStateResponse {
  private String message;
  private Person playerState;
  private Room roomState;
}
