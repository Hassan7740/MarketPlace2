package iti.jets.marketplace.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private AddressDTO address;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String email;
    private String password;
    private String creditCard;

}
