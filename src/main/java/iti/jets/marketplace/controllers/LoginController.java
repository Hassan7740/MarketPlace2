package iti.jets.marketplace.controllers;

import iti.jets.marketplace.Security.Response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.servcies.LoginService;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/auth/login")
@CrossOrigin(origins = {"http://localhost:4200"},methods = {RequestMethod.POST})
public class LoginController {
  @Autowired
  LoginService loginService;

  @PostMapping
  public ResponseEntity<TokenResponse> login(@RequestBody LoginDTO lDto) {

    return ResponseEntity.ok(loginService.userValidation(lDto));

  }
}
