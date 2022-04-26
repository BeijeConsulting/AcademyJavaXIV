package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitems")
public class Carts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "users_id")
	private int usersId;
	
	@Column(name = "products_id")
	private int productsId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ order id : ").append(this.usersId)
				.append(", product id : ").append(this.productsId).append(" }");
		
		return builder.toString();
	}
}
