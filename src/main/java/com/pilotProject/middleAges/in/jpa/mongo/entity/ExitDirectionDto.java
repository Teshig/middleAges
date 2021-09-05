package com.pilotProject.middleAges.in.jpa.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum ExitDirectionDto {
  NORTH(), EAST(), SOUTH(), WEST(), UP(), DOWN(), WRONG_DIRECTION;

  public static final String PROP_NAME = "direction";

  public static ExitDirectionDto fromString(String direction) {
    for (ExitDirectionDto exitDirection : ExitDirectionDto.values()) {
      if (exitDirection.toString().equalsIgnoreCase(direction)) {
        return exitDirection;
      }
    }
    return WRONG_DIRECTION;
  }
}
