package iti.jets.marketplace.servcies;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.mappers.LoingResponceMapper;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.repos.UserRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

 

@Component
public class LoginService {
    @Autowired
    UserRepo re;
    ResponseViewModel responseViewModel;
    @Autowired
    LoingResponceMapper loingResponceMapper ; 
    public LoginService() {
 
    }

    public ResponseViewModel userValidation(LoginDTO ldto) {
        responseViewModel = new ResponseViewModel();
       User u =(User) re.getUserByEmail(ldto.getEmail());
       
       if(u == null)
       {
        responseViewModel.setResponseBody("user name or password in valid!",HttpStatus.valueOf(401),"invalid");
       }
       else if(u.getPassword().equals(ldto.getPassword()))
       {
           responseViewModel.setResponseBody("logedin sucessfully",HttpStatus.valueOf(200),loingResponceMapper.map(u));
       }else
       {
        responseViewModel.setResponseBody(" in valid user name or password",HttpStatus.valueOf(401), "invalid");
       }
        return responseViewModel;
    }
}
