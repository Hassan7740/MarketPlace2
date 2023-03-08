package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.servcies.UserService;
import iti.jets.marketplace.utils.ResponseViewModel;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.http.HttpStatus;
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
    return new ResponseViewModel<UserDTO>("Done",5, userDTO) ;
  }

  
  @PatchMapping
  public ResponseViewModel<Object> updateUser(@RequestBody UserDTO userDTO) {
    userService.updateUser(userDTO);
    return new ResponseViewModel<Object>("Updated", HttpStatus.ACCEPTED.value(), null);
  }

}
