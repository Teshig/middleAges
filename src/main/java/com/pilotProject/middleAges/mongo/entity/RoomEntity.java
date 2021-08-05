package com.pilotProject.middleAges.mongo.entity;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "zone_001")
public class Room {
  @Id
  private RoomId id;

  private String title;
  private String description;
  private Map<ExitDirection, ExitDescription> exits;
}
