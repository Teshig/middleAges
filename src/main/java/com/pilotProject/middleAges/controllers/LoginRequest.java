package com.pilotProject.middleAges.controllers;

import lombok.Data;

@Data
public class LoginRequest {
  private String name;
  private String password;
}
