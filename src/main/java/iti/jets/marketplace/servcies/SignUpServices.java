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


    private ResponseViewModel responseViewModel;

    public SignUpServices(UserRepo userRepo, UserMapper userMapper, AddressMapper addressMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    
    public ResponseViewModel saveUser(UserDTO signUpDTO){

        responseViewModel = new ResponseViewModel();

        if(userRepo.getUserByEmail(signUpDTO.getEmail()) == null){

            Address address = addressMapper.map(signUpDTO.getAddress());
            User user = userMapper.map(signUpDTO);
            user.setAddress(address);
            user.setType("customer");
            userRepo.save(user);



            user.setPassword(null);

            responseViewModel.setResponseBody("User Saved Successfully", HttpStatus.valueOf(200), user);
            
        }else{

            responseViewModel.setResponseBody("User Already Exist", HttpStatus.valueOf(406), null );
        }
        
        return responseViewModel; 
    }
}
