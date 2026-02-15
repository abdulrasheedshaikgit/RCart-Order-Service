package com.rcart.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcart.order.model.Product;

@FeignClient("rcart-product-service")
public interface ProductClient {
	
	@GetMapping("api/getProduct/{id}")
	public Product getProductById(@PathVariable Integer id);

}
