package com.pilotProject.middleAges.mongo.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RoomId implements Serializable {
  private String zoneId;
  private String roomId;
}
