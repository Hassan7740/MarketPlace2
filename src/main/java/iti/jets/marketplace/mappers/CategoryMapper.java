package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import iti.jets.marketplace.dtos.CategoryDTO;
import iti.jets.marketplace.models.Category;

@Mapper(componentModel = "spring" )
@Component
public interface CategoryMapper {
    CategoryDTO map(Category category);
    Category map(CategoryDTO categoryDTO);
}
