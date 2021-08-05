package com.pilotProject.middleAges.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExitDescriptionEntity {
  public static final String PROP_NAME = "exitTo";

  private String exitTo;
}
