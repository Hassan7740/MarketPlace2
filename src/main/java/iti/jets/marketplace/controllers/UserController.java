package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.servcies.UserService;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
  UserService userService;
  ResponseViewModel response = new ResponseViewModel();



  UserController(UserService userService ){
    this.userService = userService ;
  }
  @GetMapping("{id}")
  public Map<String,Object> findUserById(@PathVariable int id) {
    UserDTO userDTO = userService.findUserById(id);
   response.setResponseBody("user found", HttpStatus.OK, userDTO);
    return response.getResponseBody();
  }

}
