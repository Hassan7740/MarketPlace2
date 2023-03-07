package iti.jets.marketplace.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
