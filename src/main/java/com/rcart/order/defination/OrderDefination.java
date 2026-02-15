package com.rcart.order.defination;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcart.order.model.Cart;

@RestController
@RequestMapping("/api")
public interface OrderDefination {
	
	@PostMapping("/placeOrder")
	public ResponseEntity placeOrder(@RequestBody Cart cart) throws Exception;
	
	

}
