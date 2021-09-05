package com.pilotProject.middleAges.in.jpa.mongo.mapper;

import com.pilotProject.middleAges.engine.model.ExitDescription;
import com.pilotProject.middleAges.engine.model.ExitDirection;
import com.pilotProject.middleAges.engine.model.Room;
import com.pilotProject.middleAges.in.jpa.mongo.entity.ExitDescriptionDto;
import com.pilotProject.middleAges.in.jpa.mongo.entity.ExitDirectionDto;
import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomDto;
import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomIdDto;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RoomMapper {

  public static Map<String, Room> map(Iterable<RoomDto> roomDtos) {
    Map<String, Room> rooms = new TreeMap<>();
    for (RoomDto roomDto : roomDtos) {
      Room room = map(roomDto);
      rooms.put(room.getId(), room);
    }
    return rooms;
  }

  public static Room map(RoomDto roomDto) {
    RoomIdDto roomIdDto = roomDto.getId();
    return Room.builder()
        .id(roomIdDto.getZoneId() + roomIdDto.getRoomId())
        .title(roomDto.getTitle())
        .description(roomDto.getDescription())
        .exits(map(roomDto.getExits()))
        .peopleInside(new HashMap<>())
        .build();
  }

  private static Map<ExitDirection, ExitDescription> map(Map<ExitDirectionDto, ExitDescriptionDto> exitsEntries) {
    Map<ExitDirection, ExitDescription> exits = new HashMap<>();

    for (ExitDirectionDto exitDirectionDto : exitsEntries.keySet()) {
      exits.put(map(exitDirectionDto), map(exitsEntries.get(exitDirectionDto)));
    }

    return exits;
  }

  private static ExitDescription map(ExitDescriptionDto exitDescriptionDto) {
    ExitDescription exitDescription = new ExitDescription();
    exitDescription.setExitTo(exitDescriptionDto.getExitTo());
    return exitDescription;
  }

  private static ExitDirection map(ExitDirectionDto exitDirectionDto) {
    return ExitDirection.valueOf(exitDirectionDto.name());
  }
}
