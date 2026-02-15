package com.rcart.order.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Embedded
	private CustomerDetails customerName;
	
	private String paymentMode;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> items;
	
	private Double totalAmount;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerDetails getCustomerName() {
		return customerName;
	}

	public void setCustomerName(CustomerDetails customerName) {
		this.customerName = customerName;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Integer getId() {
		return orderId;
	}

	public Order(Integer id, CustomerDetails customerName, String paymentMode, List<OrderItem> items) {
		super();
		this.orderId = id;
		this.customerName = customerName;
		this.paymentMode = paymentMode;
		this.items = items;
	}

	public Order() {
		super();
	}
	
	
	
   
}
