package iti.jets.marketplace.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.UserorderproductDTO;
import iti.jets.marketplace.exceptions.ResourceNotFoundException;
import iti.jets.marketplace.models.Userorderproduct;
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
	public ResponseViewModel<Userorderproduct> addToCart(@RequestBody UserorderproductDTO userorderproductDTO)throws ResourceNotFoundException{
		return orderStatusService.addToCart(userorderproductDTO);
	}

	// @PostMapping
	// public ResponseViewModel<List<Userorderproduct>> addToCart(@RequestBody List<UserorderproductDTO> userorderproductDTO){
		
	// 	return orderStatusService.addToCart(userorderproductDTO);
	// }

	@PatchMapping("/checkout")
	public ResponseViewModel<Object> checkout(@RequestBody List<UserorderproductDTO> userorderproductDTO){
		return orderStatusService.checkout(userorderproductDTO);
	}

	@PatchMapping("/delivered")
	public ResponseViewModel<Object> delivered(@RequestBody List<UserorderproductDTO> userorderproductDTO){
		return orderStatusService.delivered(userorderproductDTO);
	}

	@DeleteMapping("{id}")
	public ResponseViewModel<Object> deleteOrderById(@PathVariable Integer id){
		return orderStatusService.deleteOrderById(id);
	}
}
