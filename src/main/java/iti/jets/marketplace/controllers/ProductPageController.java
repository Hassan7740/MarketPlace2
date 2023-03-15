package iti.jets.marketplace.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import iti.jets.marketplace.dtos.productcards.ProductCardDTO;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;
import jakarta.annotation.security.RolesAllowed;

@RestController
// @RolesAllowed("ADMIN")
// @RolesAllowed("ADMIN")
// @PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/productpage")
public class ProductPageController {

  private final ProductService productService;

  public ProductPageController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("product/{id}")
  public ProductCardDTO searchProductById(@PathVariable int id) {
    
    return productService.searchById(id);
  }
  @GetMapping("category/{id}")
  public List<ProductCardDTO> getProductsByCategoryId(@PathVariable int id) {
    
    return productService.getProductsByCategoryId(id);
  }

}