package com.pilotProject.middleAges.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
  private String name;
  private String location;
}
