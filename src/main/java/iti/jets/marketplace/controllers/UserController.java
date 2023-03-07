package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.servcies.UserService;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
 private ResponseViewModel response = new ResponseViewModel();

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("{id}")
  public Map findUserById(@PathVariable int id) {
    UserDTO userDTO = userService.findUserById(id);
   response.setResponseBody("user found", HttpStatus.OK, userDTO);
    return response.getResponseBody();
  }

    @PostMapping
    public Map updateUser(@RequestBody  UserDTO userDTO){
        userService.updateUser(userDTO);
        response.setResponseBody("user updated successfully" , HttpStatus.ACCEPTED , "Done");
        return response.getResponseBody();
  }

}
