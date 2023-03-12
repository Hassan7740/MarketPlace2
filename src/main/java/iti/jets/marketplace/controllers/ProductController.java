package iti.jets.marketplace.controllers;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;
import org.springframework.web.bind.annotation.*;
import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;
import jakarta.annotation.security.RolesAllowed;


@RestController
// @RolesAllowed("ADMIN")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseViewModel<Product> addProduct(@RequestBody ProductDTO productDTO) {
        
       return productService.add(productDTO);
    }

    @GetMapping("{productName}")
    public ResponseViewModel<List<ProductDTO>> searchProductByName(@PathVariable String productName)
    {
      return  productService.searchByName(productName);
    }

    @DeleteMapping("{id}")
      public ResponseViewModel<Object> deleteProductById(@PathVariable Integer id){
      return  productService.deleteProductById(id);
    }

    @PatchMapping("/update")
      public ResponseViewModel<Object> updateProduct(@RequestBody ProductDTO productDTO){
      return productService.updateProduct(productDTO);
    }

    @GetMapping("/filter/{productName}/{categoryName}/{price}")
    public ResponseViewModel<List<ProductDTO>> productFilter(@PathVariable String productName , @PathVariable String categoryName , @PathVariable float price ){
      List<ProductDTO> productsDTO = productService.productFilter(productName, categoryName, price); 
      return new ResponseViewModel<List<ProductDTO>>("done" , HttpStatus.OK.value() , productsDTO) ;
    }

    @GetMapping("/{categoryName}")
    public ResponseViewModel<List<ProductDTO>> productFilterByCategoryName( @PathVariable String categoryName){
      List<ProductDTO> productsDTO = productService.filterByCategoryName(categoryName); 
      return new ResponseViewModel<List<ProductDTO>>("done" , HttpStatus.OK.value() , productsDTO) ;
    }

    @GetMapping("/{price}")
    public ResponseViewModel<List<ProductDTO>> productFilterByPrice(@PathVariable float price ){
      List<ProductDTO> productsDTO = productService.filterByPrice(price); 
      return new ResponseViewModel<List<ProductDTO>>("done" , HttpStatus.OK.value() , productsDTO) ;
    }
    
    
}
