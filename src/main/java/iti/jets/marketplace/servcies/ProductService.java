package iti.jets.marketplace.servcies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.mappers.ProductMapper;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class ProductService {
    
    @Autowired
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private ResponseViewModel response = new ResponseViewModel();

    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public Map add(ProductDTO productDTO)
    {
        Product p = productMapper.productDtoToProduct(productDTO);

        productRepo.saveAndFlush(p);

        response.setResponseBody("Product added successfully", HttpStatus.OK , p);

        return response.getResponseBody();
    }

    public Map searchByName(String productName)
    {

        Product p = productRepo.findProductByproductName(productName);
        ProductDTO productDTO = productMapper.producToProductDto(p);
        response.setResponseBody("done",HttpStatus.valueOf(200),productDTO);

        return response.getResponseBody();
    }


}
