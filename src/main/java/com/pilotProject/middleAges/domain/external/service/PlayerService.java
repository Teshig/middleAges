package com.pilotProject.middleAges.domain.external.service;

import com.pilotProject.middleAges.domain.entity.Player;

public interface PlayerService {

  Player login(String name, String password);
}
