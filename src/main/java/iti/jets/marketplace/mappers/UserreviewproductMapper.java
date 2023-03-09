package iti.jets.marketplace.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import iti.jets.marketplace.models.Userreviewproduct;
import iti.jets.marketplace.dtos.UserreviewproductDTO;
import java.util.*;

@Mapper(componentModel = "spring")
public interface UserreviewproductMapper {

    UserreviewproductDTO map(Userreviewproduct userreviewproduct);

    Userreviewproduct map(UserreviewproductDTO userreviewproductDTO);

    List<UserreviewproductDTO> DTOtoEnt(List<Userreviewproduct> userreviewproduct);

    List<Userreviewproduct> EntToDTO(List<UserreviewproductDTO> userreviewproductDTO);

    
    
}