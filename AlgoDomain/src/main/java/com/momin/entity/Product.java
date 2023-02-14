package com.momin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product{
	@Id
	private String productId;
	private String name;
	private String productType;
	private String category;
	private String basePrice;
	private double discount;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Charges charge;
	private String finalPrice;
	
	
	public Product(String productId, String name, String productType, String category, String basePrice,
			double discount, Charges charge, String finalPrice) {
		super();
		
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.category = category;
		this.basePrice = basePrice;
		this.discount = discount;
		this.charge = charge;
		this.finalPrice = finalPrice;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public Integer getPid() {
//		return pid;
//	}





	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public Charges getCharge() {
		return charge;
	}


	public void setCharge(Charges charge) {
		this.charge = charge;
	}


	public String getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
	
	
}
