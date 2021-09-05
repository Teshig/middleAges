package com.pilotProject.middleAges.engine.model;

public enum ExitDirection {
  NORTH("north"),
  EAST("east"),
  SOUTH("south"),
  WEST("west"),
  UP("up"),
  DOWN("down"),
  WRONG_DIRECTION("wrongdirection");

  private String value;

  ExitDirection(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
