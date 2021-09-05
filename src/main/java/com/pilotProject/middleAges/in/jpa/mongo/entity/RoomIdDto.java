package com.pilotProject.middleAges.in.jpa.mongo.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RoomIdDto implements Serializable {
  private String zoneId;
  private String roomId;
}
