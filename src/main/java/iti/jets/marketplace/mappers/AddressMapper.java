package iti.jets.marketplace.mappers;

import iti.jets.marketplace.dtos.AddressDTO;
import iti.jets.marketplace.models.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface AddressMapper {
    AddressDTO map(Address address);
    Address map(AddressDTO addressDTO);
}
