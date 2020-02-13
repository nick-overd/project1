package com.qa.database.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.database.services.CrudServices;
import com.qa.database.utils.Utils;
import com.qa.databases.Order;


public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	public String getInput() {
		return Utils.getInput();
	}
	int getNumInput() {
		return Utils.getNumInput();
		}
	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the id of the order you would like to create");
		Long customerid = Long.valueOf(getInput());
		Order order = orderService.create(new Order(customerid));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the customer you ordered under");
		Long customerid = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the order");
		Long orderid = Long.valueOf(getInput());
		Order order = orderService.update(new Order(orderid, customerid));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
	}
	
}