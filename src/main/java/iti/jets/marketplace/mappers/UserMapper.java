package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.models.User;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO map(User user);
    User map(UserDTO userDTO);
    List<UserDTO> map(List<User> allUsers);
}
