package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.AddressDTO;
import iti.jets.marketplace.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddressMapper {
    AddressDTO map(Address address);
    Address map(AddressDTO addressDTO);
}
