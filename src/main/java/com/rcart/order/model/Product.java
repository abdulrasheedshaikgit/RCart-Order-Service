package com.rcart.order.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Product {
	
	private Integer id;
	
	private String productName;
	
	private String productCategory;
	
	private Integer quantity;
	
	private Date addedDate;
	
	
	private String dealerDetails;

	private Double price;


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	


	public String getDealerDetails() {
		return dealerDetails;
	}


	public void setDealerDetails(String dealerDetails) {
		this.dealerDetails = dealerDetails;
	}


	public Integer getId() {
		return id;
	}


	public Product(Integer id, String productName, String productCategory, Integer quantity, Date addedDate,
			String dealerDetails,Double price) {
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.quantity = quantity;
		this.addedDate = addedDate;
		this.dealerDetails = dealerDetails;
		this.price=price;
	}
	
	
	
	

}
