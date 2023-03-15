package iti.jets.marketplace.servcies;

import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.productcards.ProductCardDTO;
import iti.jets.marketplace.mappers.ProductCardDTOMapper;
import iti.jets.marketplace.mappers.ProductMapper;
import iti.jets.marketplace.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import iti.jets.marketplace.utils.ResponseViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;





@Service
public class ProductCard {


    @Autowired
	private final ProductRepo productRepo;
	private final ProductMapper productMapper;
	private final ProductCardDTOMapper productCardDTOMapper;

	public ProductCard(ProductRepo productRepo,ProductMapper productMapper,ProductCardDTOMapper productCardDTOMapper){
		this.productRepo = productRepo;
		this.productMapper = productMapper;
		this.productCardDTOMapper = productCardDTOMapper;
	}



	public List<ProductCardDTO> getAllProduct(int offset ,int limit){

        PageRequest pr = PageRequest.of(offset, limit);
        List<ProductCardDTO> products = productCardDTOMapper.getAllProduct(productRepo.findAll(pr).toList());


        return products;
    }
}
