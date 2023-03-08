package iti.jets.marketplace.servcies;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.mappers.AddressMapper;
import iti.jets.marketplace.mappers.UserMapper;
import iti.jets.marketplace.models.Address;
import iti.jets.marketplace.repos.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import iti.jets.marketplace.utils.ResponseViewModel;
import iti.jets.marketplace.models.User;



@Service
public class SignUpServices {

    private final UserRepo userRepo ;
    private final UserMapper userMapper ;
    private final AddressMapper addressMapper ;



    public SignUpServices(UserRepo userRepo, UserMapper userMapper, AddressMapper addressMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    
    public UserDTO saveUser(UserDTO signUpDTO){

        if(userRepo.getUserByEmail(signUpDTO.getEmail()) == null){
            Address address = addressMapper.map(signUpDTO.getAddress());
            address.setUsers(null);
            User user = userMapper.map(signUpDTO);
            user.setAddress(address);
            user.setType("customer");
            userRepo.save(user);
            user.setPassword(null);

            signUpDTO = userMapper.map(user);

        }else{
            signUpDTO = null;
        }
        
        return signUpDTO;
    }
}
