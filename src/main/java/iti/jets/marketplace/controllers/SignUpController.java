package iti.jets.marketplace.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import iti.jets.marketplace.servcies.SignUpServices;
import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.utils.ResponseViewModel;
import iti.jets.marketplace.utils.ResponseViewModel.ResponseViewModelBuilder;
import java.util.Map;


@RestController
@RequestMapping("/signup")
public class SignUpController {


    private final SignUpServices signUpServices;


    SignUpController(SignUpServices signUpServices){
        this.signUpServices = signUpServices;
    }


    @PostMapping
    public ResponseViewModel<Object> addNewUser(@RequestBody UserDTO signUpDTO ){
        UserDTO signUpDTORes = signUpServices.saveUser(signUpDTO);

        if( signUpDTORes != null){
            return ResponseViewModel.<Object>builder().data(signUpDTORes).message("User Saved Successfully").statusCode(HttpStatus.ACCEPTED.value()).build();

        }
        return ResponseViewModel.<Object>builder().data(null).message("User Already Exist").statusCode(HttpStatus.NOT_FOUND.value()).build();
    }

}