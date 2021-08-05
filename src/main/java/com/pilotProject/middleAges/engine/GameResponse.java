package com.pilotProject.middleAges.engine.entity;

import lombok.Data;

@Data
public class CommandResult {
  private boolean success;
  private String message;
  private String playerState;
  private Room roomState;
}
