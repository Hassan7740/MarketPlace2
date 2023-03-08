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


<<<<<<< HEAD
    private ResponseViewModel responseViewModel;
=======

>>>>>>> b6566a6ca6dbbd705b7a0a4e424a75b306cc5d8e

    public SignUpServices(UserRepo userRepo, UserMapper userMapper, AddressMapper addressMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    
<<<<<<< HEAD
    public ResponseViewModel saveUser(UserDTO signUpDTO){

        responseViewModel = new ResponseViewModel();

        if(userRepo.getUserByEmail(signUpDTO.getEmail()) == null){

            Address address = addressMapper.map(signUpDTO.getAddress());
=======
    public UserDTO saveUser(UserDTO signUpDTO){

        if(userRepo.getUserByEmail(signUpDTO.getEmail()) == null){
            Address address = addressMapper.map(signUpDTO.getAddress());
            address.setUsers(null);
>>>>>>> b6566a6ca6dbbd705b7a0a4e424a75b306cc5d8e
            User user = userMapper.map(signUpDTO);
            user.setAddress(address);
            user.setType("customer");
            userRepo.save(user);
<<<<<<< HEAD

            user.setPassword(null);
            responseViewModel.setResponseBody("User Saved Successfully", HttpStatus.valueOf(200), user);

        }else{

            responseViewModel.setResponseBody("User Already Exist", HttpStatus.valueOf(406), null );
        }

        return responseViewModel;
=======
            user.setPassword(null);

            signUpDTO = userMapper.map(user);

        }else{
            signUpDTO = null;
        }
        
        return signUpDTO;
>>>>>>> b6566a6ca6dbbd705b7a0a4e424a75b306cc5d8e
    }
}
