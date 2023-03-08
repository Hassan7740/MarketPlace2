package iti.jets.marketplace.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import iti.jets.marketplace.dtos.ImageDTO;
import iti.jets.marketplace.models.Image;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface ImageMapper {

    Image  map(ImageDTO imageDTO);
    ImageDTO  map(Image image);


    //lists
    List<Image> ImgToDTO(List<ImageDTO> listImageDTO);
    List<ImageDTO> DTOtoImg(List<Image> listImage);
    
}
