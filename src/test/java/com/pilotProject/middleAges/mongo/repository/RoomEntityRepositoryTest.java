package com.pilotProject.middleAges.mongo.repository;

import com.pilotProject.middleAges.mongo.entity.Room;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoomRepositoryTest {

  @Autowired
  RoomRepository repository;

  @Test
  public void readFirstRoom() {
    Iterable<Room> all = repository.findAll();
    System.out.println(all);
  }
}
