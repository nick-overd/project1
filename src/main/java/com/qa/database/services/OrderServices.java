package com.qa.database.services;

import java.util.List;

import com.qa.database.dao.Dao;
import com.qa.databases.Order;

public class OrderServices implements CrudServices<Order> {

	Dao<Order> orderDao;
	
	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}
	
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order order) {
		return orderDao.create(order);
	}

	public Order update(Order order) {
		return orderDao.update(order);
	}

	public void delete(Long id) {
		orderDao.delete(id);
	}

	
		
	}

