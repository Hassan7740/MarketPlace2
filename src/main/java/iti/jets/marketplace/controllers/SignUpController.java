package iti.jets.marketplace.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import iti.jets.marketplace.servcies.SignUpServices;
import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.utils.ResponseViewModel;
import java.util.Map;


@RestController
@RequestMapping("/signup")
public class SignUpController {


    private final SignUpServices signUpServices;


    SignUpController(SignUpServices signUpServices){
        this.signUpServices = signUpServices;
    }


    @PostMapping
    public Object addNewUser(@RequestBody UserDTO signUpDTO ){
        UserDTO signUpDTORes = signUpServices.saveUser(signUpDTO);

        if( signUpDTORes != null){
            responseViewModel.setResponseBody("User Saved Successfully", HttpStatus.valueOf(200), signUpDTORes);

        }else{
            responseViewModel.setResponseBody("User Already Exist", HttpStatus.valueOf(406), signUpDTORes);

        }
        return responseViewModel.getResponseBody();
    }

}