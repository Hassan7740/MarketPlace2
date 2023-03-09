package iti.jets.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import iti.jets.marketplace.dtos.HomePageDTO;
import iti.jets.marketplace.servcies.HomePageService;
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

}
