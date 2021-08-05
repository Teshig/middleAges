package com.pilotProject.middleAges.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum ExitDirectionEntity {
  NORTH(), EAST(), SOUTH(), WEST(), UP(), DOWN(), WRONG_DIRECTION;

  public static final String PROP_NAME = "direction";

  public static ExitDirectionEntity fromString(String direction) {
    for (ExitDirectionEntity exitDirection : ExitDirectionEntity.values()) {
      if (exitDirection.toString().equalsIgnoreCase(direction)) {
        return exitDirection;
      }
    }
    return WRONG_DIRECTION;
  }
}
