package com.pilotProject.middleAges;

import com.pilotProject.middleAges.engine.entity.ExitDescription;
import com.pilotProject.middleAges.engine.entity.ExitDirection;
import com.pilotProject.middleAges.engine.entity.Room;
import com.pilotProject.middleAges.mongo.entity.ExitDescriptionEntity;
import com.pilotProject.middleAges.mongo.entity.ExitDirectionEntity;
import com.pilotProject.middleAges.mongo.entity.RoomEntity;
import com.pilotProject.middleAges.mongo.entity.RoomId;
import java.util.HashMap;
import java.util.Map;

public class RoomMapper {

  public Room map(RoomEntity roomEntity) {
    Room room = new Room();
    RoomId roomId = roomEntity.getId();
    room.setId(roomId.getZoneId() + roomId.getRoomId());
    room.setTitle(roomEntity.getTitle());
    room.setDescription(roomEntity.getDescription());

    room.setExits(map(roomEntity.getExits()));
    room.setPeopleInside(new HashMap<>());
    return room;
  }

  private Map<ExitDirection, ExitDescription> map(Map<ExitDirectionEntity, ExitDescriptionEntity> exitsEntries) {
    Map<ExitDirection, ExitDescription> exits = new HashMap<>();

    for (ExitDirectionEntity exitDirectionEntity : exitsEntries.keySet()) {
      exits.put(map(exitDirectionEntity), map(exitsEntries.get(exitDirectionEntity)));
    }

    return exits;
  }

  private ExitDescription map(ExitDescriptionEntity exitDescriptionEntity) {
    ExitDescription exitDescription = new ExitDescription();
    exitDescription.setExitTo(exitDescriptionEntity.getExitTo());
    return exitDescription;
  }

  private ExitDirection map(ExitDirectionEntity exitDirectionEntity) {
    return ExitDirection.valueOf(exitDirectionEntity.name());
  }
}
