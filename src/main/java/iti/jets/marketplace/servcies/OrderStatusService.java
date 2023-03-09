// package iti.jets.marketplace.servcies;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;

// import iti.jets.marketplace.dtos.OrderStatusDTO;
// import iti.jets.marketplace.mappers.OrderStatusMapper;
// import iti.jets.marketplace.models.Userorderproduct;
// import iti.jets.marketplace.repos.OrderStatusRepo;
// import iti.jets.marketplace.utils.ResponseViewModel;

// @Service
// public class OrderStatusService {

// 	@Autowired
// 	private final OrderStatusRepo orderStatusRepo;
// 	private final OrderStatusMapper orderStatusMapper;

// 	public OrderStatusService(OrderStatusRepo orderStatusRepo,OrderStatusMapper orderStatusMapper){
// 		this.orderStatusRepo = orderStatusRepo;
// 		this.orderStatusMapper = orderStatusMapper;
// 	}

// 	public ResponseViewModel<Object> addToCart(OrderStatusDTO orderStatusDTO){
// 		Userorderproduct userorderproduct = orderStatusMapper.orderStatusDtoToUserOrderProduct(orderStatusDTO);
// 		orderStatusRepo.saveAndFlush(userorderproduct);
// 		return ResponseViewModel.<Object>builder().data(null).message("Added to Cart").statusCode(HttpStatus.OK.value()).build();
// 	}
// }
