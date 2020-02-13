package com.qa.databases.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.qa.database.controller.ItemController;
import com.qa.database.services.ItemServices;
import com.qa.databases.Item;

public class ItemControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, 100F, "yasha"));
		items.add(new Item(2L, 100F, "kaya"));
		items.add(new Item(3L, 100F, "sange"));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String itemid = "1";
		String cost = "100f";
		String name = "yasha";
		Mockito.doReturn(itemid, cost, name).when(itemController).getInput();
		Item item = new Item(1l, 100f, "yasha" );
		Item savedItem = new Item(1L, 100f, "yasha");
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	@Test
	public void updateTest() {
		String cost = "1";
		String itemid = "1";
		String name = "yasha";
		Mockito.doReturn(itemid, cost, name).when(itemController).getInput();
		Item item = new Item(100f, "yasha");
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
}