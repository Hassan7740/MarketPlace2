package iti.jets.marketplace.controllers;

import org.springframework.web.bind.annotation.*;
import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RestController
@RequestMapping("/productpage")
public class ProductPageController {

  private final ProductService productService;

  public ProductPageController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("product/{id}")
  public ResponseViewModel<ProductDTO> searchProductById(@PathVariable int id) {
    return productService.searchById(id);
  }

}