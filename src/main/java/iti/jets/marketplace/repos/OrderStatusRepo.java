package iti.jets.marketplace.repos;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.marketplace.models.Userorderproduct;

public interface OrderStatusRepo extends JpaRepository<Userorderproduct,Integer> {
	public Optional<Userorderproduct> findByOrderDate(Date orderDate);
	public Optional<Userorderproduct> findByStatus(String status);
	public Optional<Userorderproduct> getByuserorderproductId(Integer id);


}
