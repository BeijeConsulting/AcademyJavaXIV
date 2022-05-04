package it.beije.turing.ecommerce;

import java.util.ArrayList;

public class Shopping_Cart {
	private ArrayList<Product> products;
	private double price;
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
