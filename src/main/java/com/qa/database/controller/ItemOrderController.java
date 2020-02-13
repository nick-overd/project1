package com.qa.database.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.database.services.CrudServices;
import com.qa.database.utils.Utils;
import com.qa.databases.ItemOrder;

public class ItemOrderController implements CrudController<ItemOrder>{

	public static final Logger LOGGER = Logger.getLogger(ItemOrderController.class);
	
	private CrudServices<ItemOrder> itemorderService;
	
	public ItemOrderController(CrudServices<ItemOrder> itemorderService) {
		this.itemorderService = itemorderService;
	}
	
	public String getInput() {
		return Utils.getInput();
	}
	int getNumInput() {
		return Utils.getNumInput();
		}
	/**
	 * Reads all itemorders to the logger
	 */
	@Override
	public List<ItemOrder> readAll() {
		List<ItemOrder> itemorders = itemorderService.readAll();
		for(ItemOrder itemorder: itemorders) {
			LOGGER.info(itemorder.toString());
		}
		return itemorders;
	}

	/**
	 * Creates a itemorder by taking in user input
	 */
	@Override
	public ItemOrder create() {
		LOGGER.info("Please enter the id of the itemorder you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the item you would like to update");
		Long itemid = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderid = Long.valueOf(getInput());
		ItemOrder itemorder = itemorderService.create(new ItemOrder(id, itemid, orderid));
		LOGGER.info("ItemOrder created");
		return itemorder;
	}

	/**
	 * Updates an existing itemorder by taking in user input
	 */
	@Override
	public ItemOrder update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long itemid = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderid = Long.valueOf(getInput());
		ItemOrder itemorder = itemorderService.update(new ItemOrder(itemid, orderid));
		LOGGER.info("ItemOrder Updated");
		return itemorder;
	}

	/**
	 * Deletes an existing itemorder by the id of the itemorder
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the itemorder you would like to delete");
		Long id = Long.valueOf(getInput());
		itemorderService.delete(id);
	}
	
}