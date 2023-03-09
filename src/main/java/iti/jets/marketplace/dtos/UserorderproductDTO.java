package iti.jets.marketplace.dtos;

import java.sql.Date;
import lombok.Data;

@Data
public class UserorderproductDTO {


    private ProductDTO product;
    private UserDTO user;
    private String status;
    private Integer productCount;
    private Date orderDate;


}
