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

import com.qa.database.controller.ItemOrderController;
import com.qa.database.services.ItemOrderServices;
import com.qa.databases.ItemOrder;

@RunWith(MockitoJUnitRunner.class)
public class ItemOrderControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemOrderServices itemorderServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the itemorder controller
	 */
	@Spy
	@InjectMocks
	private ItemOrderController itemorderController;

	@Test
	public void readAllTest() {
		ItemOrderController itemorderController = new ItemOrderController(itemorderServices);
		List<ItemOrder> itemorders = new ArrayList<>();
		itemorders.add(new ItemOrder(3L, 1L));
		itemorders.add(new ItemOrder(2L, 2L));
		itemorders.add(new ItemOrder(1L, 3L));
		Mockito.when(itemorderServices.readAll()).thenReturn(itemorders);
		assertEquals(itemorders, itemorderController.readAll());
	}

	@Test
	public void createTest() {
		String itemid = "1";
		String orderid = "1";
		Mockito.doReturn(itemid, orderid).when(itemorderController).getInput();
		ItemOrder itemorder = new ItemOrder(1l, 1L, 1L);
		ItemOrder savedItemOrder = new ItemOrder(1l, 1L, 1L);
		Mockito.when(itemorderServices.create(itemorder)).thenReturn(savedItemOrder);
		assertEquals(savedItemOrder, itemorderController.create());
	}

	@Test
	public void updateTest() {
		String customerid = "1";
		String itemid = "1";
		Mockito.doReturn(customerid, itemid).when(itemorderController).getInput();
		ItemOrder itemorder = new ItemOrder(1L, 1l);
		Mockito.when(itemorderServices.update(itemorder)).thenReturn(itemorder);
		assertEquals(itemorder, itemorderController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemorderController).getInput();
		itemorderController.delete();
		Mockito.verify(itemorderServices, Mockito.times(1)).delete(1L);
	}
	
}

