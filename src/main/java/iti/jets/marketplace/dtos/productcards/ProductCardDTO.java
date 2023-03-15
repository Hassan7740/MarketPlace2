package iti.jets.marketplace.dtos.productcards;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import iti.jets.marketplace.dtos.CategoryDTO;
import iti.jets.marketplace.dtos.ImageDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCardDTO {
    private Integer id;
    private String title;
    private float price;
    private String description;
    private List<String> images;
    private categoryCardDto category;
}
