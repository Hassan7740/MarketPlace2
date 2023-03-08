package iti.jets.marketplace.dtos;
import lombok.Data;

@Data
public class UserreviewproductDTO {


    private UserDTO user;
    private Integer noStars;
    private String comment;

}
