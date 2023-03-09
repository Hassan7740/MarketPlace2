package iti.jets.marketplace.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.servcies.OrderStatusService;
import iti.jets.marketplace.utils.ResponseViewModel;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {
	
	private final OrderStatusService orderStatusService;
	public OrderStatusController(OrderStatusService orderStatusService){
		this.orderStatusService = orderStatusService;
	}

	@PostMapping
	public ResponseViewModel<Object> addToCart(@RequestBody UserorderproductDTO userorderproductDTO){
		
		return orderStatusService.addToCart(userorderproductDTO);
	}

}
