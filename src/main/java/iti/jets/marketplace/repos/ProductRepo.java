package iti.jets.marketplace.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import iti.jets.marketplace.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("select p.productAmount from Product p where p.productId = :id")
    public Optional<Integer> findNumberOfproduct(@Param("id") int id);
    @Transactional
    @Modifying
    @Query("update Product p set p.productAmount = ?1 where p.productId = ?2")
    public Integer updateNumberOfProduct(int amount, int id);

    public List<Product> findProductByproductName(String productName);

    public Product getProductByproductId(int id);

}
