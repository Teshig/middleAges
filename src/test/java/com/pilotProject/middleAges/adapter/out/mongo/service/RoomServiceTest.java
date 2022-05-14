package com.pilotProject.middleAges.adapter.out.mongo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import com.pilotProject.middleAges.domain.entity.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

  @Mock
  private RoomMongoRepository repository;

  @InjectMocks
  private RoomServiceImpl target;

  @Test
  public void findAllRooms() {
    when(repository.findAll()).thenReturn(new ArrayList<>());
    Map<String, Room> result = target.findAllRoom();

    assertNotNull(result);
    verify(repository, times(1)).findAll();
  }
}
