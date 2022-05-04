package it.beije.turing.ecommerce;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "customer_id")
	private int customer_Id;
	
	@Column(name = "date_of_order")
	private LocalDate date;
	
	@Column(name = "shipping_address")
	private String shipping_Address;
	
	@Column(name = "payment_method")
	private String payment_Method;
	
	private ArrayList<Product> products;
	
	
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getPayment_Method() {
		return payment_Method;
	}
	public void setPayment_Method(String payment_Method) {
		this.payment_Method = payment_Method;
	}
	public String getShipping_Address() {
		return shipping_Address;
	}
	public void setShipping_Address(String shipping_Address) {
		this.shipping_Address = shipping_Address;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
