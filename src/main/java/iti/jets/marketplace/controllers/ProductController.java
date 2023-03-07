package iti.jets.marketplace.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseViewModel addProduct(@RequestBody ProductDTO productDTO) {
        
       return productService.add(productDTO);

    }
    
    
}
