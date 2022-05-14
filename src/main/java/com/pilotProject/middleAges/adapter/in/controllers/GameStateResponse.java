package com.pilotProject.middleAges.adapter.in.controllers;

import com.pilotProject.middleAges.domain.entity.Person;
import com.pilotProject.middleAges.domain.entity.Room;
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
