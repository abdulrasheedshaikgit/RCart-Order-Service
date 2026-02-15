package com.rcart.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcart.order.client.ProductClient;
import com.rcart.order.model.Cart;
import com.rcart.order.model.CartItem;
import com.rcart.order.model.CustomerDetails;
import com.rcart.order.model.Order;
import com.rcart.order.model.OrderItem;
import com.rcart.order.model.Product;
import com.rcart.order.repository.OrderRepository;

import feign.FeignException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductClient productClient;

	

	public Order placeOrder(Cart cart) throws Exception {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();
		double total = 0;
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setName("test");
		customerDetails.setAddress("Demo");
		order.setCustomerName(customerDetails);
		for(CartItem cartItem : cart.getCart())
		{
			try
			{
			Product product = productClient.getProductById(cartItem.getProductId());
	        if (product.getQuantity() < cartItem.getQuantity()) {
	            throw new RuntimeException("Not enough stock for product " + product.getProductName());
	        }

	        OrderItem orderItem = new OrderItem();
	        orderItem.setProductId(product.getId());
	        orderItem.setProductName(product.getProductName());
	        orderItem.setQuantity(cartItem.getQuantity());
	        orderItem.setPrice(product.getPrice());
	        orderItems.add(orderItem);

	        total += product.getPrice() * cartItem.getQuantity();
	    }catch (FeignException e) {
			throw new Exception(e.getMessage());
		}

	    order.setItems(orderItems);
	    order.setTotalAmount(total);
		}
	    return orderRepository.save(order);
		
		
	}
}
