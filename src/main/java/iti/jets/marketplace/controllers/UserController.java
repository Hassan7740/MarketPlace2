package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.servcies.UserService;
import iti.jets.marketplace.utils.ResponseViewModel;
import iti.jets.marketplace.utils.ResponseViewModel.ResponseViewModelBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

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
    //response.setResponseBody("user found", HttpStatus.OK, userDTO);
    return ResponseViewModel.<UserDTO>builder().data(userDTO).message("user found").statusCode(HttpStatus.ACCEPTED.value()).build();

  }

  
  @PatchMapping
  public ResponseViewModelBuilder<Object> updateUser(@RequestBody UserDTO userDTO) {
    userService.updateUser(userDTO);
    // response.setResponseBody("user updated successfully", HttpStatus.ACCEPTED, "Done");
    return ResponseViewModel.builder().data(null).message("user updated").statusCode(HttpStatus.ACCEPTED.value());
  }

}
