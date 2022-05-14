package com.pilotProject.middleAges.adapter.out.jpa.service;

import com.pilotProject.middleAges.adapter.out.jpa.entity.PlayerDto;
import com.pilotProject.middleAges.adapter.out.jpa.mapper.PlayerMapper;
import com.pilotProject.middleAges.adapter.out.jpa.repository.PlayerJpaRepository;
import com.pilotProject.middleAges.domain.entity.Player;
import com.pilotProject.middleAges.domain.external.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

  private final PlayerJpaRepository repository;

  @Override
  public Player login(String name, String password) {
    PlayerDto player = repository.findPlayerByNameAndSecret(name, password);
    return PlayerMapper.map(player);
  }
}
