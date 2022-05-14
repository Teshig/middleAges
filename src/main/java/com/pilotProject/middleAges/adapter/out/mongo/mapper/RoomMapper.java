package com.pilotProject.middleAges.adapter.out.mongo.mapper;

import com.pilotProject.middleAges.adapter.out.mongo.entity.ExitDescriptionEntity;
import com.pilotProject.middleAges.adapter.out.mongo.entity.ExitDirectionEntity;
import com.pilotProject.middleAges.adapter.out.mongo.entity.RoomIdEntity;
import com.pilotProject.middleAges.domain.entity.ExitDescription;
import com.pilotProject.middleAges.domain.entity.ExitDirection;
import com.pilotProject.middleAges.domain.entity.Room;
import com.pilotProject.middleAges.adapter.out.mongo.entity.RoomEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RoomMapper {

  public static Map<String, Room> map(Iterable<RoomEntity> roomEntities) {
    Map<String, Room> rooms = new TreeMap<>();
    for (RoomEntity roomEntity : roomEntities) {
      Room room = map(roomEntity);
      rooms.put(room.getId(), room);
    }
    return rooms;
  }

  public static Room map(RoomEntity roomEntity) {
    RoomIdEntity roomIdEntity = roomEntity.getId();
    return Room.builder()
        .id(roomIdEntity.getZoneId() + roomIdEntity.getRoomId())
        .title(roomEntity.getTitle())
        .description(roomEntity.getDescription())
        .exits(map(roomEntity.getExits()))
        .peopleInside(new HashMap<>())
        .build();
  }

  private static Map<ExitDirection, ExitDescription> map(Map<ExitDirectionEntity, ExitDescriptionEntity> exitsEntries) {
    Map<ExitDirection, ExitDescription> exits = new HashMap<>();

    for (ExitDirectionEntity exitDirectionEntity : exitsEntries.keySet()) {
      exits.put(map(exitDirectionEntity), map(exitsEntries.get(exitDirectionEntity)));
    }

    return exits;
  }

  private static ExitDescription map(ExitDescriptionEntity exitDescriptionEntity) {
    ExitDescription exitDescription = new ExitDescription();
    exitDescription.setExitTo(exitDescriptionEntity.getExitTo());
    return exitDescription;
  }

  private static ExitDirection map(ExitDirectionEntity exitDirectionEntity) {
    return ExitDirection.valueOf(exitDirectionEntity.name());
  }
}
