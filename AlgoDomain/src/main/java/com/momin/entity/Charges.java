package com.momin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="charges")
public class Charges{
	
	@Id
	private String id;
	private String gst;
	private String delivery;
	
	
	public Charges(String id, String gst, String delivery) {
		super();
		this.id = id;
		this.gst = gst;
		this.delivery = delivery;
	}


	public Charges() {
		super();
		
	}



	public void setId(String id) {
		this.id = id;
	}


	public String getGst() {
		return gst;
	}


	public void setGst(String gst) {
		this.gst = gst;
	}


	public String getDelivery() {
		return delivery;
	}


	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
	
}
