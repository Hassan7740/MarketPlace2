package iti.jets.marketplace.dtos;


import lombok.Data;

@Data
public class ProductDTO {

    private Integer productId;
    private CategoryDTO category;
    private String productName;
    private String productDescription;
    private int productAmount;
    private float price;
}
