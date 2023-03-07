package iti.jets.marketplace.dtos;

import java.util.HashSet;
import java.util.Set;

import iti.jets.marketplace.models.Image;
import lombok.Data;

@Data
public class ProductDTO {

    private Integer productId;
    private CategoryDTO category;
    private String productName;
    private String productDescription;
    private int productAmount;
    private float price;
    private Set<Image> images = new HashSet<Image>(0);
}
