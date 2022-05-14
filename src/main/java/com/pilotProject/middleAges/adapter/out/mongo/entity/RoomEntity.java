package com.pilotProject.middleAges.adapter.out.mongo.entity;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "zone_001")
public class RoomEntity {
  @Id
  private RoomIdEntity id;

  private String title;
  private String description;
  private Map<ExitDirectionEntity, ExitDescriptionEntity> exits;
}
