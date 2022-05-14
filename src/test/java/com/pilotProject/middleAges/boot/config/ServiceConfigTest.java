package com.pilotProject.middleAges.boot.config;

import com.pilotProject.middleAges.adapter.out.jpa.repository.PlayerJpaRepository;
import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import com.pilotProject.middleAges.domain.external.service.PlayerService;
import com.pilotProject.middleAges.domain.external.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class ServiceConfigTest {

  @InjectMocks
  private ServiceConfig target;

  @MockBean
  private PlayerJpaRepository playerRepository;
  @MockBean
  private RoomMongoRepository roomRepository;

  @Test
  public void notNullPlayerService() {
    PlayerService playerService = target.playerService(playerRepository);

    Assertions.assertNotNull(playerService, "PlayerService shouldn't be null.");
  }

  @Test
  public void notNullRoomService() {
    RoomService roomService = target.roomService(roomRepository);

    Assertions.assertNotNull(roomService);
  }
}
