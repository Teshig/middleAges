package com.pilotProject.middleAges.adapter.out.jpa.repository;

import com.pilotProject.middleAges.adapter.out.jpa.entity.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerJpaRepository extends JpaRepository<PlayerDto, Long> {

  PlayerDto findPlayerByNameAndSecret(String name, String secret);

}
