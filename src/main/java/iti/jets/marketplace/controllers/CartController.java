package iti.jets.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.CartDTO;
import iti.jets.marketplace.servcies.CartService;

@RestController
@RequestMapping("auth/test")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = { RequestMethod.POST })
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class CartController {
    @Autowired
    CartService testService;
    @PostMapping
    public ResponseEntity<Object> test(@RequestBody CartDTO o) {
        System.out.println(o);
        testService.setOrder(o);
         return ResponseEntity.ok(null);
    }
}
