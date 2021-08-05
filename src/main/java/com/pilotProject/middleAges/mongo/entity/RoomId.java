package com.pilotProject.middleAges.mongo;

import java.io.Serializable;
import lombok.Data;

@Data
public class RoomId implements Serializable {
  private String zoneId;
  private String roomId;
}
