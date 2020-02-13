package com.qa.database.services;

import java.util.List;

import com.qa.database.dao.Dao;
import com.qa.databases.ItemOrder;


public class ItemOrderServices implements CrudServices<ItemOrder> {

	Dao<ItemOrder> itemorderDao;
	
	public ItemOrderServices(Dao<ItemOrder> itemorderDao) {
		this.itemorderDao = itemorderDao;
	}
	
	public List<ItemOrder> readAll() {
		return itemorderDao.readAll();
	}

	public ItemOrder create(ItemOrder itemorder) {
		return itemorderDao.create(itemorder);
	}

	public ItemOrder update(ItemOrder itemorder) {
		return itemorderDao.update(itemorder);
	}

	public void delete(Long id) {
		itemorderDao.delete(id);
	}

	
		
	}