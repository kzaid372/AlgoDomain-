package com.momin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.momin.entity.Product;
import com.momin.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService services;
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product s) {
			
				return services.saveProduct(s);
	}
	
	
	@DeleteMapping("/products/{pid}")
	public boolean deleteProduct(@PathVariable String pid) {
		return services.deleteProduct(pid);
	}
	
	
	@GetMapping("/products/{pid}")
	public  Product getProduct(@PathVariable String pid) {
		return services.getProduct(pid);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {

       return services.getProducts();
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product p){
		
		return services.updateProduct(p);
	}
}
