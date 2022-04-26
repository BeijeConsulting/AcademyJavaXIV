package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "orders_id")
	private int ordersId;
	
	@Column(name = "products_id")
	private int productsId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ order id : ").append(this.ordersId)
				.append(", product id : ").append(this.productsId).append(" }");
		
		return builder.toString();
	}
}
