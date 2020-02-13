package com.qa.databases.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.database.dao.MysqlOrderDao;
import com.qa.databases.Order;

public class OrderDaoMysqlIT {
	@Test
	public void testDatabaseHasValues() {
		MysqlOrderDao OrderDaoMysql = new MysqlOrderDao();
		List<Order> Orders = OrderDaoMysql.readAll();
		assertTrue(Orders.size()>0);
	}
}
