package com.momin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momin.entity.Charges;
import com.momin.entity.Product;
import com.momin.repo.ChargesRepo;
import com.momin.repo.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo pRepo;
	@Autowired
	private ChargesRepo cRepo;

	@Override
	public Product saveProduct(Product e) {
		double basePrice = Double.parseDouble(e.getBasePrice());
		String category = e.getCategory();
		double discount = 0;
		double gst =0;
		double delivery =0;
		double finalPrice = 0;
		
		if(category.toLowerCase().equals("electronics"))
		{
			discount= basePrice*0.15;
			gst =(basePrice-discount) * 0.18;
			delivery = 350;
		}
		else if(category.toLowerCase().equals("home appliances"))
		{
			discount= basePrice*0.22;
			gst = (basePrice-discount) * 0.24;
			delivery = 800;
		}
		else if(category.toLowerCase().equals("clothing"))
		{
			discount= basePrice*0.40;
			gst =(basePrice-discount)* 0.12;
			delivery = 0;
		}
		else if(category.toLowerCase().equals("furniture"))
		{
			discount= basePrice*0.10;
			gst = (basePrice-discount) * 0.18;
			delivery = 300;
		}
		e.setDiscount(discount);
		finalPrice = basePrice-discount+gst+delivery;
		
		e.setFinalPrice(String.valueOf(finalPrice));
		Charges charges = new Charges();
		charges.setId(e.getProductId());
		charges.setDelivery(String.valueOf(delivery));
		charges.setGst(String.valueOf(gst));
		e.setCharge(cRepo.save(charges));
		
		Product p = e;
		pRepo.save(p);
        
		return p;
	}

	@Override
	public Product updateProduct(Product e) {
		double basePrice = Double.parseDouble(e.getBasePrice());
		String category = e.getCategory();
		double discount = 0;
		double gst = 0;
		double delivery = 0;
		double finalPrice = 0;
		
		if(category.toLowerCase().equals("electronics")) {
			discount = basePrice * 0.15;
			gst = (basePrice - discount) * 0.18;
			delivery = 350;
		} else if(category.toLowerCase().equals("home appliances")) {
			discount = basePrice * 0.22;
			gst = (basePrice - discount) * 0.24;
			delivery = 800;
		} else if(category.toLowerCase().equals("clothing")) {
			discount = basePrice * 0.40;
			gst = (basePrice - discount) * 0.12;
			delivery = 0;
		} else if(category.toLowerCase().equals("furniture")) {
			discount = basePrice * 0.10;
			gst = (basePrice - discount) * 0.18;
			delivery = 300;
		}
		e.setDiscount(discount);
		finalPrice = basePrice - discount + gst + delivery;
		
		e.setFinalPrice(String.valueOf(finalPrice));
		
			Charges charges = cRepo.findById(e.getProductId()).get();
			charges.setDelivery(String.valueOf(delivery));
			charges.setGst(String.valueOf(gst));
			e.setCharge(cRepo.save(charges));
	
		
		return pRepo.save(e);
	}

	@Override
	public boolean deleteProduct(String pid) {
		 Optional<Product> product = pRepo.findById(pid);
		    if(product.isPresent()){
		        pRepo.deleteById(pid);
		        return true;
		    }
		    return false;
		}
		



	@Override
	public Product getProduct(String pid) {
		return pRepo.findById(pid).get();

	}

	@Override
	public List<Product> getProducts() {
		return pRepo.findAll();
	}
	

}
