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
    
    @Autowired
    LoingResponceMapper loingResponceMapper ;

    public LoginService() {
 
    }

    public ResponseViewModel<LoginResponceDTO>userValidation(LoginDTO ldto) {
         
       User u =(User) re.getUserByEmail(ldto.getEmail());
       
       if(u == null)
       {
       return  new ResponseViewModel<LoginResponceDTO>("user name or password in valid!",401,null);
       }
       else if(u.getPassword().equals(ldto.getPassword()))
       {
        return  new ResponseViewModel<LoginResponceDTO>("login Sucessfully",200,loingResponceMapper.map(u));
       }else
       {
        return  new ResponseViewModel<LoginResponceDTO>("user name or password in valid!",401,null);

       }
         
    }
}
