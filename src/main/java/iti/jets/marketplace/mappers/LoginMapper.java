package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.models.User;

public class LoginMapper {
     public LoginDTO mapUser(User u)
     {
        LoginDTO temp = new LoginDTO();
        temp.setEmail(u.getEmail());
        temp.setPassword(temp.getPassword());
        return temp ;
     }
}
