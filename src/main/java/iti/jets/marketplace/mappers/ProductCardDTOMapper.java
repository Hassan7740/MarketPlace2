package iti.jets.marketplace.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.productcards.ProductCardDTO;
import iti.jets.marketplace.dtos.productcards.categoryCardDto;
import iti.jets.marketplace.models.*;


@Service
public class ProductCardDTOMapper {

    public List<ProductCardDTO> getAllProduct(List<Product> EntitesProduct){

        List<ProductCardDTO> productsCardDTO = new ArrayList<>();
        for(Product x : EntitesProduct){
            ProductCardDTO p = new ProductCardDTO();
            p.setId(x.getProductId());
            p.setTitle(x.getProductName());
            p.setPrice(x.getPrice());
            p.setDescription(x.getProductDescription());

            List<String> images = new ArrayList<>();
            for(Image imgObj: x.getImages()){
                images.add(imgObj.getImageUrl());
            }
            p.setImages(images);

            categoryCardDto categoryCard = new categoryCardDto();
            categoryCard.setId(x.getCategory().getCategoryId());
            categoryCard.setName(x.getCategory().getCategoryName());

            p.setCategory(categoryCard);

            // add obj to list
            productsCardDTO.add(p);

        }

        return productsCardDTO;


    }
    
}
