package iti.jets.marketplace.dtos;


import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {

    private Integer productId;
    private CategoryDTO category;
    private String productName;
    private String productDescription;
    private int productAmount;
    private float price;
    private List<ImageDTO> images;
    private List<UserreviewproductDTO> userreviewproducts;
    private List<UserorderproductDTO> userorderproducts;

}
