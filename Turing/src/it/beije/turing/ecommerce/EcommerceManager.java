package it.beije.turing.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.beije.turing.db.JPAentityManagerFactory;

public class EcommerceManager {

	public static void main(String[] args) {
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		
		Query queryOrders = entityManager.createQuery("SELECT c FROM Orders as c ");
		List<Orders> ordersAll = queryOrders.getResultList();
		
		Query queryOrderItems = entityManager.createQuery("SELECT c FROM OrderItems as c ");
		List<OrderItems> orderItems = queryOrderItems.getResultList();
		
		for(Orders orders : ordersAll) {
			System.out.println("\n" + orders);
			Users user = entityManager.find(Users.class, orders.getUsersId());
			System.out.println("\n\t" + user);

			for(OrderItems orderItem : orderItems) {
				if(orderItem.getOrdersId() == orders.getId()) {
					System.out.println("\n\t" + orderItem);
					Products product = entityManager.find(Products.class, orderItem.getProductsId());
					System.out.println("\n\t\t" + product);
				}
			}
		}
		
		entityManager.close();
	}

}
