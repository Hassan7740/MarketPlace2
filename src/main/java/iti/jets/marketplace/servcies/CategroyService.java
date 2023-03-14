package iti.jets.marketplace.servcies;

import org.springframework.stereotype.Service;

import iti.jets.marketplace.repos.CategoryRepo;
import iti.jets.marketplace.utils.ResponseViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;
import iti.jets.marketplace.mappers.CategoryMapper;
import iti.jets.marketplace.models.Category;
import iti.jets.marketplace.dtos.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class CategroyService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;


    public ResponseViewModel<List<CategoryDTO>> getAllCategory(){
  


        List<CategoryDTO> categories = categoryMapper.map(categoryRepo.findAll());


        return ResponseViewModel.<List<CategoryDTO>>builder().data(categories).message("Category get successfully").statusCode(HttpStatus.OK.value()).build();
    }
    
}
