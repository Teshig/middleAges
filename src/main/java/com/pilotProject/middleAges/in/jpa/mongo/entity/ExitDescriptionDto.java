package com.pilotProject.middleAges.in.jpa.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExitDescriptionDto {
  public static final String PROP_NAME = "exitTo";

  private String exitTo;
}
