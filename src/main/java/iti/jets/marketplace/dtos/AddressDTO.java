package iti.jets.marketplace.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer addressId;
    private String country;
    private String area;
    private String street;
    private Integer buildNo;
    private Integer floorNo;
}
