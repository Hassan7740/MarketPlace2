package iti.jets.marketplace.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCardDTO {
    private Integer productId;
    private String title;
    private float price;
    private String productDescription;
    private List<ImageDTO> images;
    private CategoryDTO category;
}
