package it.beije.ecommerce;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "order_data")
	private Date orderData;
	
	@Column(name = "arrival_data")
	private Date arrivalData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	public Date getOrderData() {
		return orderData;
	}

	public void setOrderData(Date orderData) {
		this.orderData = orderData;
	}

	public Date getArrivalData() {
		return arrivalData;
	}

	public void setArrivalData(Date arrivalData) {
		this.arrivalData = arrivalData;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", id User : ").append(this.idUser)
				.append(", Order Data : ").append(this.orderData.toString())
				.append(", Arrival Data : ").append(this.arrivalData.toString())
				.append(" }");
		
		return builder.toString();
	}
	
	
}
