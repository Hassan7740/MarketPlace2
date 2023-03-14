package iti.jets.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import iti.jets.marketplace.dtos.CategoryDTO;
import iti.jets.marketplace.dtos.HomePageDTO;
import iti.jets.marketplace.dtos.ProductDTO;
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
    @Autowired
    ProductService productService;

    @Autowired
    CategroyService cateogryService;

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseViewModel<HomePageDTO > getHomePage(@PathVariable Integer id) {
        return homePageService.getHomePage(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<ProductDTO> findAll(@RequestParam int pageNum ,@RequestParam int pageSize){
      return productService.findAll(pageNum, pageSize);
    }

    @GetMapping("/categories")

    public ResponseViewModel<List<CategoryDTO>> getCategories() {
        var x = cateogryService.getAllCategory();
        System.out.println(x);

        return x;
    }
}
