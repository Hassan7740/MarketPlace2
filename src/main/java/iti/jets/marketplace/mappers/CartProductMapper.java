package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;

import iti.jets.marketplace.dtos.CartProductDTO;
import iti.jets.marketplace.models.Product;

@Mapper(componentModel = "spring")
public interface CartProductMapper {
	CartProductDTO map (Product product);
	Product map(CartProductDTO cartProductDTO);
}
