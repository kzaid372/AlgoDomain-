package com.momin.service;

import java.util.List;

import com.momin.entity.Product;


public interface ProductService {
	public Product getProduct(String pid);
	public List<Product> getProducts();
	public Product saveProduct(Product e);
	public Product updateProduct(Product e);
	public boolean deleteProduct(String pid);
	
	

}
