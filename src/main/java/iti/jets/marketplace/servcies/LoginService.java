package iti.jets.marketplace.servcies;

import iti.jets.marketplace.Security.Response.TokenResponse;
import iti.jets.marketplace.Security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce.Cluster.Refresh;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.LoginDTO;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.mappers.LoingResponceMapper;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.repos.UserRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

import java.util.HashMap;
import java.util.Optional;

@Service

public class LoginService {

        @Autowired
        private UserRepo re;

        @Autowired
        private LoingResponceMapper loingResponceMapper;

        @Autowired
        private JwtService jwtService;
        @Autowired
        private AuthenticationManager authenticationManager;

        private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        private String refresh_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsImlhdCI6MTY3ODc5Nzg0MSwiZXhwIjoxNjc4ODMzODQxfQ.CZ0IOiF1ytLrE7zQDPSd2TeKG-ocE3BAwBrdLG7CH-M";

        public LoginService() {

        }

        public TokenResponse userValidation(LoginDTO ldto) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                ldto.getEmail(),
                                                ldto.getPassword()));

                User u = re.findByEmail(ldto.getEmail()).orElseThrow();
                HashMap h = new HashMap<>();
                        h.put("name", u.getFirstName() + " " + u.getLastName());
                        h.put("address", u.getAddress().getCountry() + " " + u.getAddress().getStreet() + " "
                                        + u.getAddress().getArea());
                        h.put("phone",u.getPhone());

                String jwtToken = jwtService.generateToken(h,u);

                return new TokenResponse(jwtToken, refresh_token);
        }
}
