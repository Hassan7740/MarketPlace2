package iti.jets.marketplace.servcies;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.mappers.UserMapper;
import iti.jets.marketplace.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
@Autowired
private UserRepo userRepo ;
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

public UserDTO findUserById(int id){
    UserDTO userDTO = userMapper.map(userRepo.findById(id).get());
    return  userDTO ;

}
}
