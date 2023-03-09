package iti.jets.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.servcies.LoginService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RestController
@RequestMapping("/login")
public class LoginController {
  @Autowired
  LoginService loginService;

  @PostMapping
  public ResponseViewModel<LoginResponceDTO> login(@RequestBody LoginDTO lDto) {

    return loginService.userValidation(lDto);

  }
}
