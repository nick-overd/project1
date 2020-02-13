package com.qa.databases.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.databases.Order;

import com.qa.database.controller.OrderController;
import com.qa.database.services.OrderServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the order controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(3L,1L));
		orders.add(new Order(2L, 1L));
		orders.add(new Order(2L, 3L));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		String itemid = "1";
		String customerid = "1";
		Mockito.doReturn(itemid).when(orderController).getInput();
		Order order = new Order(1l , 1l);
		Order savedOrder = new Order(1L, 1L);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}

	@Test
	public void updateTest() {
		String customerid = "1L";
		String itemid = "2l";
		Mockito.doReturn(customerid, itemid).when(orderController).getInput();
		Order order = new Order(1L, 2L);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}
	
}