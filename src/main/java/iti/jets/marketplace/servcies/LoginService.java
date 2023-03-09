package iti.jets.marketplace.servcies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.mappers.LoingResponceMapper;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.repos.UserRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

 

@Service
public class LoginService {
    @Autowired
    UserRepo re;
    
    @Autowired
    LoingResponceMapper loingResponceMapper ;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public LoginService() {
 
    }

    public ResponseViewModel<LoginResponceDTO>userValidation(LoginDTO ldto) {
         
       User u =(User) re.getUserByEmail(ldto.getEmail());
    //    String hsing = encoder.encode(ldto.getPassword());
       
       if(u == null)
       {
       return  new ResponseViewModel<LoginResponceDTO>("user name or password in valid!",401,null);
       }
       else if(encoder.matches(ldto.getPassword(), u.getPassword()))
       {
        return  new ResponseViewModel<LoginResponceDTO>("login Sucessfully",200,loingResponceMapper.map(u));
       }else
       {
        return  new ResponseViewModel<LoginResponceDTO>("user name or password in valid!",401,null);

       }
         
    }
}
