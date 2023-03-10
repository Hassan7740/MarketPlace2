package iti.jets.marketplace.mappers;


import org.mapstruct.Mapper;
import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.models.Userorderproduct;

import java.util.*;

@Mapper(componentModel = "spring")
public interface UserorderproductMapper {

    UserorderproductDTO map(Userorderproduct userorderproduct);

    Userorderproduct map(UserorderproductDTO userorderproductDTO);

    List<UserorderproductDTO> EntToDTO(List<Userorderproduct> userorderproduct);

    List<Userorderproduct> DTOtoEnt(List<UserorderproductDTO> userorderproductDTO);

    
    
}
