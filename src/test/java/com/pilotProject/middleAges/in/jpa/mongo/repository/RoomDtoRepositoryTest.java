package com.pilotProject.middleAges.in.jpa.mongo.repository;

import com.pilotProject.middleAges.in.jpa.mongo.entity.RoomDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoomDtoRepositoryTest {

  @Autowired
  RoomJpaRepository repository;

  @Test
  public void readFirstRoom() {
    Iterable<RoomDto> all = repository.findAll();
    System.out.println(all);
  }
}
