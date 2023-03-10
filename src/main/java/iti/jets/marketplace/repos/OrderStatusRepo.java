package iti.jets.marketplace.repos;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import iti.jets.marketplace.models.Userorderproduct;

public interface OrderStatusRepo extends JpaRepository<Userorderproduct,Integer> {
	public Optional<Userorderproduct> findByOrderDate(Date orderDate);
	public Optional<Userorderproduct> findByStatus(String status);
	public Optional<Userorderproduct> getByuserorderproductId(Integer id);
	@Transactional
    @Modifying
	// @Query("update Userorderproduct uop set uop.status = ?1 where uop.userId = ?2")
    @Query(value="update userorderproduct set status = ?1 where userId = ?2",nativeQuery = true)
    public Integer updateOrderStatus(String status, int id);

}
