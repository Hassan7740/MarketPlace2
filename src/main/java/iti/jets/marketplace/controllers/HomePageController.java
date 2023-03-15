package iti.jets.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import iti.jets.marketplace.dtos.HomePageDTO;
import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.dtos.productcards.ProductCardDTO;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.servcies.*;
import iti.jets.marketplace.servcies.CategroyService;
import iti.jets.marketplace.servcies.ProductService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RequestMapping("/homepage")
@RestController
public class HomePageController {
    @Autowired
    HomePageService homePageService;

    @GetMapping("{id}")
    public ResponseViewModel<HomePageDTO > getHomePage(@PathVariable Integer id) {
        return homePageService.getHomePage(id);
    }

    @GetMapping
    // @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<ProductCardDTO> findAll(@RequestParam int offset ,@RequestParam int limit){

      return productService.getAllProduct(offset, limit);
    }

    @GetMapping("/categories")
    public ResponseViewModel<List<CategoryDTO>> getCategories() {
        var x = cateogryService.getAllCategory();
        System.out.println(x);

        return x;
    }
}
