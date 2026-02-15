package com.rcart.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.rcart.order.defination.OrderDefination;
import com.rcart.order.model.Cart;
import com.rcart.order.service.OrderService;

@Component
public class OrderController implements OrderDefination{
	
	@Autowired
	private OrderService orderService;

	@Override
	public ResponseEntity placeOrder(@RequestBody Cart cart) throws Exception {
		return new ResponseEntity(orderService.placeOrder(cart),HttpStatusCode.valueOf(200));
	}

}
