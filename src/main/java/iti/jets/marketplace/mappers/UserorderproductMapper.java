package iti.jets.marketplace.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.models.Userorderproduct;

import java.util.*;

@Mapper(componentModel = "spring")
public interface UserorderproductMapper {

    UserorderproductDTO map(Userorderproduct userorderproduct);

    Userorderproduct map(UserorderproductDTO userorderproductDTO);

    List<UserorderproductDTO> DTOtoEnt(List<Userorderproduct> userorderproduct);

    List<Userorderproduct> EntToDTO(List<UserorderproductDTO> userorderproductDTO);

    
    
}
