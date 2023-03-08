package iti.jets.marketplace.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;
import iti.jets.marketplace.utils.ResponseViewModel.ResponseViewModelBuilder;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productName}")
    public ResponseViewModel<ProductDTO> searchProductByName(@PathVariable String productName)
    {
      return  productService.searchByName(productName);
    }


    @PostMapping
    public ResponseViewModel<Product> addProduct(@RequestBody ProductDTO productDTO) {
        
       return productService.add(productDTO);

    }

    @DeleteMapping("{id}")
      public ResponseViewModelBuilder<Object> deleteProductById(@PathVariable Integer id){
      return  productService.deleteProductById(id);
    }

    @PutMapping("/update")
      public ResponseViewModelBuilder<Object> updateProduct(@RequestBody ProductDTO productDTO){
      return productService.updateProduct(productDTO);
    }
    
    
}
