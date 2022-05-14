package com.pilotProject.middleAges.adapter.out.jpa.mapper;

import com.pilotProject.middleAges.adapter.out.jpa.entity.PlayerDto;
import com.pilotProject.middleAges.domain.entity.Player;

public class PlayerMapper {

  public static Player map(PlayerDto playerDto) {
    return Player.builder()
        .name(playerDto.getName())
        .location(playerDto.getInitialLocation())
        .build();
  }
}
