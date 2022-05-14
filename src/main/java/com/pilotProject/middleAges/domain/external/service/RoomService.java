package com.pilotProject.middleAges.domain.external.service;

import com.pilotProject.middleAges.domain.entity.Room;

import java.util.Map;

public interface RoomService {

  Map<String, Room> findAllRoom();
}