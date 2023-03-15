package iti.jets.marketplace.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class CartDTO {
	private CartProductDTO CartProductDTO;
	private String status;
    private Integer productCount;
    private Date orderDate;
}
