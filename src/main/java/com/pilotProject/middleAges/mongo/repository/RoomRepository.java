package com.pilotProject.middleAges.repository;

import com.pilotProject.middleAges.engine.world.Room;
import com.pilotProject.middleAges.engine.world.RoomId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, RoomId> {
}
