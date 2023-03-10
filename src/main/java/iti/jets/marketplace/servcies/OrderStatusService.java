package iti.jets.marketplace.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.ProductDTO;
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
			orderStatusRepo.updateOrderStatus("checkout",userorderproductDTO2.getUser().getUserId());
		}
		return ResponseViewModel.<Object>builder().data(null).message("Added to Checkout").statusCode(HttpStatus.OK.value()).build();
	}

	// public ResponseViewModel<Object> checkout(List<UserorderproductDTO> userorderproductDTO){
	// 	// Userorderproduct userorderproduct;
	// 	// Optional<Userorderproduct> productCheck = orderStatusRepo.findById(userorderproductDTO.getProduct().getProductId());
	// 	// Optional<Userorderproduct> userCheck =  orderStatusRepo.findById(userorderproductDTO.getUser().getUserId());
	// 	// Optional<Userorderproduct> dateCheck =  orderStatusRepo.findByOrderDate(userorderproductDTO.getOrderDate());
	// 	// Optional<Userorderproduct> statusCheck =  orderStatusRepo.findByStatus(userorderproductDTO.getStatus());
	// 	// Optional<Userorderproduct> orderCheck =  orderStatusRepo.getByuserorderproductId(userorderproduct.getUserorderproductId());

	// 	// if(productCheck.isPresent() && userCheck.isPresent()){
	// 		for (UserorderproductDTO userorderproductDTO2 : userorderproductDTO) {
	// 			// userorderproductDTO2.setStatus("checkout");
	// 			// List<Userorderproduct> userorderproduct3 = userorderproductMapper.DTOtoEnt(userorderproductDTO);
	// 			// orderStatusRepo.saveAll(userorderproductMapper.DTOtoEnt(userorderproductDTO));
	// 			orderStatusRepo.updateOrderStatus("checkout",userorderproductDTO2.getUser().getUserId());
	// 		}
	// 		// userorderproductDTO.setStatus("checkout");
	
	// 		return ResponseViewModel.<Object>builder().data(null).message("Added to Checkout").statusCode(HttpStatus.OK.value()).build();
	// 	// }
	// 	// else{
	// 	// 	return ResponseViewModel.<Userorderproduct>builder().data(null).message("Can't checkout product").statusCode(HttpStatus.OK.value()).build();
	// 	// }
	// }
}