package com.pilotProject.middleAges.in.jpa.mongo.entity;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "zone_001")
public class RoomDto {
  @Id
  private RoomIdDto id;

  private String title;
  private String description;
  private Map<ExitDirectionDto, ExitDescriptionDto> exits;
}
