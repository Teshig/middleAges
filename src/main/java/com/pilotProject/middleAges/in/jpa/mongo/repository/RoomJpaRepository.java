package com.pilotProject.middleAges.in.jpa.mongo.repository;

import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomDto;
import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomIdDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomJpaRepository extends MongoRepository<RoomDto, RoomIdDto> {
}
