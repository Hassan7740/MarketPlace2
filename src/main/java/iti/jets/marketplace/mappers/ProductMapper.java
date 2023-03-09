package iti.jets.marketplace.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    ProductDTO producToProductDto(Product product);
    Product productDtoToProduct(ProductDTO productDTO);
    List<ProductDTO> toDTOList(List<Product> products);
}
