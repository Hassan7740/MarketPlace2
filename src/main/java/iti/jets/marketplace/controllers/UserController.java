package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.servcies.UserService;
import iti.jets.marketplace.utils.ResponseViewModel;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("{id}")
  public ResponseViewModel<UserDTO> findUserById(@PathVariable int id) throws ResourceNotFoundException {
    UserDTO userDTO = userService.findUserById(id);
    return new ResponseViewModel<UserDTO>("Done",HttpStatus.OK.value(), userDTO) ;
  }


  @PatchMapping
  public ResponseViewModel<Object> updateUser(@RequestBody UserDTO userDTO) {
    userService.updateUser(userDTO);
    return new ResponseViewModel<Object>("Updated", HttpStatus.ACCEPTED.value(), null);
  }

  @GetMapping("/all")
  public ResponseViewModel<Object> getAllUsers(){
    List<UserDTO> allUsers =  userService.findAllUser();
    return new ResponseViewModel<Object>("Done" ,HttpStatus.OK.value(),allUsers);
  }

  @GetMapping
  public ResponseEntity<String> getString(){
    return ResponseEntity.ok("Hello World");
  }

}
