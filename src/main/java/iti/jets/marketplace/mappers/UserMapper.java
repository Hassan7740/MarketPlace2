package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@Component
public interface UserMapper {
    UserDTO map(User user);
    User map(UserDTO userDTO);
}
