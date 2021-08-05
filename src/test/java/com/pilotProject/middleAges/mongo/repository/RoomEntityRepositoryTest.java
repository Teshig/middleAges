package com.pilotProject.middleAges.mongo.repository;

import com.pilotProject.middleAges.mongo.entity.RoomEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoomEntityRepositoryTest {

  @Autowired
  RoomRepository repository;

  @Test
  public void readFirstRoom() {
    Iterable<RoomEntity> all = repository.findAll();
    System.out.println(all);
  }
}
