package iti.jets.marketplace.servcies;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.testDTO;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.models.User;
import iti.jets.marketplace.models.Userorderproduct;
import iti.jets.marketplace.repos.OrderStatusRepo;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.repos.UserRepo;
@Service
public class TestService {
    @Autowired
    OrderStatusRepo oRepo;
    @Autowired
    UserRepo uRepo;
    @Autowired
    ProductRepo pRepo;

    public void setOrder(testDTO tDto) {
        Integer[] products = tDto.getProductId();
        User u = uRepo.getUserByEmail(tDto.getEmail());
        for (int i = 0; i < products.length; i++) {
           oRepo.save(new Userorderproduct(pRepo.getProductByproductId(products[i]), u,tDto.getStatus(),tDto.getProudctAmount()[i],new java.util.Date()));
        }
    }
}
