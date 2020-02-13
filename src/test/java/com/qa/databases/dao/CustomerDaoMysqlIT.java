package com.qa.databases.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.database.dao.MysqlCustomerDao;
import com.qa.databases.Customer;

public class CustomerDaoMysqlIT {
	@Test
	public void testDatabaseHasValues() {
		MysqlCustomerDao customerDaoMysql = new MysqlCustomerDao();
		List<Customer> customers = customerDaoMysql.readAll();
		assertTrue(customers.size()>0);
	}
}
