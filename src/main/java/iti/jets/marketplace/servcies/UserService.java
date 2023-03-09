package iti.jets.marketplace.servcies;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.mappers.UserMapper;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.repos.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserDTO findUserById(int id) throws ResourceNotFoundException {
        if (userRepo.findById(id).isEmpty()) {
            throw new ResourceNotFoundException(id);
        } else {
            UserDTO userDTO = userMapper.map(userRepo.findById(id).get());
            return userDTO;
        }
    }

    public void updateUser(UserDTO userDTO) {
        userRepo.save(userMapper.map(userDTO));
    }


    public List<UserDTO> findAllUser (){
        List<User> allUsers = userRepo.findAll();
        List<UserDTO> allUsersDTO = userMapper.map(allUsers);
        return allUsersDTO ;
    }

    
}
