package iti.jets.marketplace.mappers;

import org.mapstruct.Mapper;

import iti.jets.marketplace.dtos.ImageDTO;
import iti.jets.marketplace.models.Image;


@Mapper(componentModel = "spring")
public interface ImageMapper {
	ImageDTO map(Image image);
	Image map (ImageDTO imageDTO);
}
