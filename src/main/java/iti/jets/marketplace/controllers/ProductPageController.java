package iti.jets.marketplace.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import iti.jets.marketplace.dtos.ProductDTO;
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
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseViewModel<ProductDTO> searchProductById(@PathVariable int id) {
    var x = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    System.out.println(x);
    return productService.searchById(id);
  }

}