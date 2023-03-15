package iti.jets.marketplace.dtos;

import lombok.Data;

 @Data
public class CartDTO {
    String email;
    String status;
    int count  ;
    Integer[] productId;
    Integer[] proudctAmount;
}
