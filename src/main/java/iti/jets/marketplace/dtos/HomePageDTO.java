package iti.jets.marketplace.dtos;

import java.util.List;

public class HomePageDTO {
    UserDTO userDTO;
    List<CategoryDTO> categoryDTO;
    public UserDTO getUserDTO() {
        return userDTO;
    }
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public List<CategoryDTO> getCategoryDTO() {
        return categoryDTO;
    }
    public void setCategoryDTO(List<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
