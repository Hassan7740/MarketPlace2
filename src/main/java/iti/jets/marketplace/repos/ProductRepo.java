package iti.jets.marketplace.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Product;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
    public List<Product> findProductByproductName(String productName);
    public Product getProductByproductId(int id);
}
