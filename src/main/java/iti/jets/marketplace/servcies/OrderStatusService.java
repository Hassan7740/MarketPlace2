package iti.jets.marketplace.servcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.mappers.UserorderproductMapper;
import iti.jets.marketplace.models.Userorderproduct;
import iti.jets.marketplace.repos.OrderStatusRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class OrderStatusService {

	@Autowired
	private final OrderStatusRepo orderStatusRepo;
	private final UserorderproductMapper userorderproductMapper;

	public OrderStatusService(OrderStatusRepo orderStatusRepo,UserorderproductMapper userorderproductMapper){
		this.orderStatusRepo = orderStatusRepo;
		this.userorderproductMapper = userorderproductMapper;
	}

	public ResponseViewModel<Object> addToCart(UserorderproductDTO userorderproductDTO){
		Userorderproduct userorderproduct = userorderproductMapper.map(userorderproductDTO);
		orderStatusRepo.saveAndFlush(userorderproduct);
		return ResponseViewModel.<Object>builder().data(null).message("Added to Cart").statusCode(HttpStatus.OK.value()).build();
	}
}
