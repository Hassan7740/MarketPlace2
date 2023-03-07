package iti.jets.marketplace.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.models.Product;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    
    ProductDTO producToProductDto(Product product);

    Product productDtoToProduct(ProductDTO productDTO);
}
