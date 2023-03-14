package iti.jets.marketplace.servcies;

import org.springframework.stereotype.Service;

import iti.jets.marketplace.mappers.ProductMapper;
import iti.jets.marketplace.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import iti.jets.marketplace.utils.ResponseViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;
import iti.jets.marketplace.dtos.ProductCardDTO;





@Service
public class ProductCard {


    @Autowired
	private final ProductRepo productRepo;
	private final ProductMapper productMapper;

	public ProductCard(ProductRepo productRepo,ProductMapper productMapper){
		this.productRepo = productRepo;
		this.productMapper = productMapper;
	}


}
