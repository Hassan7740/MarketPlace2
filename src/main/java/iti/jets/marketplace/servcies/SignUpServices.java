package iti.jets.marketplace.servcies;

import iti.jets.marketplace.Security.Response.TokenResponse;
import iti.jets.marketplace.Security.config.JwtService;
import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.mappers.AddressMapper;
import iti.jets.marketplace.mappers.UserMapper;
import iti.jets.marketplace.models.Address;
import iti.jets.marketplace.models.Role;
import iti.jets.marketplace.repos.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import iti.jets.marketplace.models.User;

@Service
public class SignUpServices {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private String refresh_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsImlhdCI6MTY3ODc5Nzg0MSwiZXhwIjoxNjc4ODMzODQxfQ.CZ0IOiF1ytLrE7zQDPSd2TeKG-ocE3BAwBrdLG7CH-M";

    private final JwtService jwtService;

    public SignUpServices(UserRepo userRepo, UserMapper userMapper, AddressMapper addressMapper, JwtService jwtService) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.jwtService = jwtService;
    }

    public TokenResponse saveUser(UserDTO signUpDTO) {

//        if (userRepo.getUserByEmail(signUpDTO.getEmail()) == null) {

            Address address = addressMapper.map(signUpDTO.getAddress());
            address.setUsers(null);

            User user = userMapper.map(signUpDTO);
            user.setAddress(address);
            user.setRole(Role.USER);
            System.out.println(user.getRole());
            user.setPassword(encoder.encode(signUpDTO.getPassword()));
            userRepo.save(user);

            String jwtToken = jwtService.generateToken(user);

//            signUpDTO = userMapper.map(user);

//        } else {
//            signUpDTO = null;
//        }


        return new TokenResponse(jwtToken, refresh_token);


    }
}