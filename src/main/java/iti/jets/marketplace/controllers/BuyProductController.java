package iti.jets.marketplace.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.BuyProductDTO;
import iti.jets.marketplace.servcies.BuyProductService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RestController
@RequestMapping("/buy")
public class BuyProductController {
    @Autowired
    BuyProductService buyProductService;
    @PostMapping
    public ResponseViewModel<Integer> buyProduct(@RequestBody BuyProductDTO buyProductDTO)
    {
           
           return buyProductService.getProdcutNumber(buyProductDTO);
    } 
}
