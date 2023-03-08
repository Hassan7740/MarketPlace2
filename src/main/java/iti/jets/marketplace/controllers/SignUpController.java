package iti.jets.marketplace.controllers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.servcies.SignUpServices;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/signup")
public class SignUpController {


    private final SignUpServices signUpServices;

    SignUpController(SignUpServices signUpServices){
        this.signUpServices = signUpServices;
    }


    @PostMapping
    public ResponseViewModel addNewUser(@RequestBody UserDTO signUpDTO ){
        return signUpServices.saveUser(signUpDTO);
    }
    
}
