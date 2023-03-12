package iti.jets.marketplace.controllers;


import iti.jets.marketplace.Security.Response.TokenResponse;
import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.servcies.SignUpServices;
import iti.jets.marketplace.utils.ResponseViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/signup")
public class SignUpController {

    private final SignUpServices signUpServices;

    SignUpController(SignUpServices signUpServices){
        this.signUpServices = signUpServices;
    }

    @PostMapping
    public ResponseEntity<TokenResponse> addNewUser(@RequestBody UserDTO signUpDTO ){

        return ResponseEntity.ok(signUpServices.saveUser(signUpDTO));
    }

}