package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;

import iti.jets.marketplace.dtos.CartDTO;
import iti.jets.marketplace.models.Userorderproduct;

@Mapper(componentModel = "spring")
public interface CartMapper {
	CartDTO map(Userorderproduct userorderproduct);
	Userorderproduct map(CartDTO cartDTO);
}
