package com.pilotProject.middleAges.domain.valueobject;

public enum MessageKeys {
  ACTION_NO_SUCH_ACTION("action.nosuchaction"),
  ACTION_WOKE_UP("action.wokeup"),
  ACTION_MOVEMENT("action.movement."),
  ACTION_FAILED_MOVE("action.movement.cantmovethere"),
  ;

  private String value;

  MessageKeys(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
