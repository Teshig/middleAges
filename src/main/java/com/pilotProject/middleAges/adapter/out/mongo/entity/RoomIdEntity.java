package com.pilotProject.middleAges.adapter.out.mongo.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RoomIdEntity implements Serializable {
  private String zoneId;
  private String roomId;
}
