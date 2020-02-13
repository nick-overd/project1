package com.qa.database.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.database.services.CrudServices;
import com.qa.database.utils.Utils;
import com.qa.databases.Item;

public class ItemController implements CrudController<Item>{

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	
	public String getInput() {
		return Utils.getInput();
	}
	int getNumInput() {
		return Utils.getNumInput();
		}
	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates a item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter a name");
		String firstName = getInput();
		LOGGER.info("Please enter the id of the Item you would like to update");
		Float cost = Float.valueOf(getInput());
		Item item = itemService.create(new Item( cost ,firstName));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter the price of the Item ");
		Float cost = Float.valueOf(getInput());
		LOGGER.info("Please enter the name of the item");
		String firstName = getInput();
		Item item = itemService.update(new Item(id, cost ,firstName));
		LOGGER.info("Customer Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the item
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
	}
	
}
