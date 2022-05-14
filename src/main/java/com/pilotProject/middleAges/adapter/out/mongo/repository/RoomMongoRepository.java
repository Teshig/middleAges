package com.pilotProject.middleAges.adapter.out.mongo.repository;

import com.pilotProject.middleAges.adapter.out.mongo.entity.RoomEntity;
import com.pilotProject.middleAges.adapter.out.mongo.entity.RoomIdEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMongoRepository extends MongoRepository<RoomEntity, RoomIdEntity> {
}
