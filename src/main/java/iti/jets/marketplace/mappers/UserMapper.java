package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDTO map(User user);


    User map(UserDTO userDTO);
}
