package iti.jets.marketplace.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productName}")
    public Map searchProductByName(@PathVariable String productName)
    {
      return  productService.searchByName(productName);
    }


    @PostMapping
    public Map addProduct(@RequestBody ProductDTO productDTO) {
        
       return productService.add(productDTO);

    }

    @DeleteMapping("{id}")
      public ResponseViewModel deleteProductById(@PathVariable Integer id){
      return  productService.deleteProductById(id);
    }

    @PutMapping("/update")
      public ResponseViewModel updateProduct(@RequestBody ProductDTO productDTO){
      return productService.updateProduct(productDTO);
    }
    
    
}
