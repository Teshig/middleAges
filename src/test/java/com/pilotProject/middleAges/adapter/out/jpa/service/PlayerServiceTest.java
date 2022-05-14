package com.pilotProject.middleAges.adapter.out.jpa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pilotProject.middleAges.adapter.out.jpa.entity.PlayerDto;
import com.pilotProject.middleAges.adapter.out.jpa.repository.PlayerJpaRepository;
import com.pilotProject.middleAges.domain.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

  private static final String NAME = "Bobbie";
  private static final String SECRET = "secret";

  @Mock
  private PlayerJpaRepository repository;

  @InjectMocks
  private PlayerServiceImpl target;

  @Test
  public void returnPlayerAfterLogin() {
    when(repository.findPlayerByNameAndSecret(NAME, SECRET)).thenReturn(PlayerDto.builder().build());
    Player result = target.login(NAME, SECRET);

    assertNotNull(result);
    verify(repository, times(1)).findPlayerByNameAndSecret(NAME, SECRET);
  }
}
