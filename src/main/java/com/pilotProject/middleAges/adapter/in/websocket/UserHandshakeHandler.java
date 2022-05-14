package com.pilotProject.middleAges.adapter.in.websocket;

import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class UserHandshakeHandler extends DefaultHandshakeHandler {

  @Override
  protected Principal determineUser(
      ServerHttpRequest request,
      WebSocketHandler wsHandler,
      Map<String, Object> attributes) {
    String randomId = UUID.randomUUID().toString();
    UserPrincipal userPrincipal = new UserPrincipal(randomId);
    log.info("User connected: {}", userPrincipal);
    return userPrincipal;
  }
}
