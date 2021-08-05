package com.pilotProject.middleAges.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum ExitDirection {
  NORTH(), EAST(), SOUTH(), WEST(), UP(), DOWN();

  public static final String PROP_NAME = "direction";

  public static ExitDirection fromString(String direction) {
    for (ExitDirection exitDirection : ExitDirection.values()) {
      if (exitDirection.toString().equalsIgnoreCase(direction)) {
        return exitDirection;
      }
    }
    return null;
  }
}
