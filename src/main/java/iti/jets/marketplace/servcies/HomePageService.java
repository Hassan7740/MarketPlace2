package iti.jets.marketplace.servcies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.CategoryDTO;
import iti.jets.marketplace.dtos.HomePageDTO;
import iti.jets.marketplace.dtos.UserDTO;
import iti.jets.marketplace.mappers.CategoryMapper;
import iti.jets.marketplace.mappers.UserMapper;
import iti.jets.marketplace.models.Category;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.repos.CategoryRepo;
import iti.jets.marketplace.repos.UserRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class HomePageService {
    @Autowired
    private CategoryRepo catRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryMapper catMapper;
    @Autowired
    UserMapper userMapper;

    HomePageDTO homePageDTO;

    UserDTO userDTO;

    List<CategoryDTO> listCatDTO;

    public ResponseViewModel<HomePageDTO> getHomePage(int id) {
        homePageDTO = new HomePageDTO();
        List<Category> categoryList = catRepo.findAll();
        listCatDTO = new ArrayList<>();

        Optional<User> userOp = userRepo.findById(id);
        for (Category c : categoryList) {
            listCatDTO.add(catMapper.map(c));
        }
        if (!userOp.isPresent()) {
            homePageDTO.setCategoryDTO(listCatDTO);
            homePageDTO.setUserDTO(null);
            return new ResponseViewModel<HomePageDTO>("The user not found ", 401, homePageDTO);
        }
        userDTO = userMapper.map(userOp.get());
        homePageDTO.setCategoryDTO(listCatDTO);
        homePageDTO.setUserDTO(userDTO);
        return new ResponseViewModel<HomePageDTO>("HomePage", 200, homePageDTO);
    }
}
