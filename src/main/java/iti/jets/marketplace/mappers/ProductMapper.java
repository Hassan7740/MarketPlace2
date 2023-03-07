package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.models.Product;

@Mapper
public interface ProductMapper {
    
    ProductDTO producToProductDto(Product product);

    Product productDtoToProduct(ProductDTO productDTO);
}
