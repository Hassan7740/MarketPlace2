package iti.jets.marketplace.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.exceptions.handlers.DataIntegrityExceptionHandler;
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

	public ResponseViewModel<Userorderproduct> addToCart(UserorderproductDTO userorderproductDTO){
		Userorderproduct userorderproduct = userorderproductMapper.map(userorderproductDTO);
		orderStatusRepo.saveAndFlush(userorderproduct);
		return ResponseViewModel.<Userorderproduct>builder().data(userorderproduct).message("Added to Cart").statusCode(HttpStatus.OK.value()).build();
	}

	// public ResponseViewModel<List<Userorderproduct>> addToCart(List<UserorderproductDTO> userorderproductDTO){
	// 	List<Userorderproduct> userorderproduct = userorderproductMapper.DTOtoEnt(userorderproductDTO);
	// 	orderStatusRepo.saveAllAndFlush(userorderproduct);
	// 	return ResponseViewModel.<List<Userorderproduct>>builder().data(userorderproduct).message("Added to Cart").statusCode(HttpStatus.OK.value()).build();
	// }

	public ResponseViewModel<Object> checkout(List<UserorderproductDTO> userorderproductDTO){
		for (UserorderproductDTO userorderproductDTO2 : userorderproductDTO) {
			orderStatusRepo.checkoutOrder("checkout",userorderproductDTO2.getUser().getUserId());
		}
		return ResponseViewModel.<Object>builder().data(null).message("Added to Checkout").statusCode(HttpStatus.OK.value()).build();
	}

	public ResponseViewModel<Object> delivered(List<UserorderproductDTO> userorderproductDTO){
		for (UserorderproductDTO userorderproductDTO2 : userorderproductDTO) {
			orderStatusRepo.deliveredOrder("delivered",userorderproductDTO2.getUser().getUserId(),userorderproductDTO2.getProduct().getProductId());
		}
		return ResponseViewModel.<Object>builder().data(null).message("Added to Delivered").statusCode(HttpStatus.OK.value()).build();
	}


    public ResponseViewModel<Object> deleteOrderById(@PathVariable Integer id){
		Optional<Userorderproduct> order = orderStatusRepo.findById(id);
		if(order.isPresent() ){
			orderStatusRepo.deleteById(id);
			return ResponseViewModel.<Object>builder().data(null).message("Order Removed from Cart").statusCode(HttpStatus.OK.value()).build();
		}
		else{
            return ResponseViewModel.<Object>builder().data(null).message("Couldn't remove product").statusCode(HttpStatus.NOT_FOUND.value()).build();
		}
	}
}