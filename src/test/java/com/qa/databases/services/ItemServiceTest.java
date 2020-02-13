package com.qa.databases.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.database.dao.Dao;
import com.qa.database.services.ItemServices;
import com.qa.databases.Item;
	@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
		
		@Mock
		private Dao<Item> itemDao;
		
		@InjectMocks
		private ItemServices itemServices;
		
		@Test
		public void itemServicesCreate() {
			Item item = new Item(100f,"yasha");
			itemServices.create(item);
			Mockito.verify(itemDao, Mockito.times(1)).create(item);
		}
		
		@Test
		public void itemServicesRead() {
			itemServices.readAll();
			Mockito.verify(itemDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void itemServicesUpdate() {
			Item item = new Item( 100f,"yasha");
			itemServices.update(item);
			Mockito.verify(itemDao, Mockito.times(1)).update(item);
		}
		
		@Test
		public void itemServicesDelete() {
			itemServices.delete(1L);
			Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
		}
		
	}