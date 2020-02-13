package com.qa.databases.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.database.dao.MysqlItemDao;
import com.qa.databases.Item;

public class ItemDaoMysqlIT {
		@Test
		public void testDatabaseHasValues() {
			MysqlItemDao itemDaoMysql = new MysqlItemDao();
			List<Item> items = itemDaoMysql.readAll();
			assertTrue(items.size()>0);
		}
	}
