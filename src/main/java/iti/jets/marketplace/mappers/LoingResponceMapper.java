package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import iti.jets.marketplace.dtos.LoginResponceDTO;
import iti.jets.marketplace.models.User;

@Mapper(componentModel = "spring")
public interface LoingResponceMapper {
    LoginResponceDTO map(User user);
    User map(LoginResponceDTO userResDTO);
}
 
