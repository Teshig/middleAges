package com.pilotProject.middleAges.mongo.repository;

import com.pilotProject.middleAges.mongo.entity.RoomEntity;
import com.pilotProject.middleAges.mongo.entity.RoomId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, RoomId> {
}
