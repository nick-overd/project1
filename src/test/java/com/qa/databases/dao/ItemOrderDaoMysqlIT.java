package com.qa.databases.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.database.dao.MysqlItemOrderDao;
import com.qa.databases.ItemOrder;

public class ItemOrderDaoMysqlIT {
	@Test
	public void testDatabaseHasValues() {
		MysqlItemOrderDao ItemOrderDaoMysql = new MysqlItemOrderDao();
		List<ItemOrder> ItemOrders = ItemOrderDaoMysql.readAll();
		assertTrue(ItemOrders.size()>0);
	}
}
