package iti.jets.marketplace.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private List<ImageDTO> images;
    private Date creationAt;
    private Date updatedAt;
    private CategoryDTO category;
}
