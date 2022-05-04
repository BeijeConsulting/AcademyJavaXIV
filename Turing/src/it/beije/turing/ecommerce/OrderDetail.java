package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "order_id")
	private int order_id;
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "quantity")
	private int quantity;
}
