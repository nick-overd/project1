package com.qa.databases.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.database.dao.Dao;
import com.qa.database.services.ItemOrderServices;
import com.qa.databases.ItemOrder;
@RunWith(MockitoJUnitRunner.class)
public class ItemOrderServicesTest {
		
		@Mock
		private Dao<ItemOrder> itemorderDao;
		
		@InjectMocks
		private ItemOrderServices itemorderServices;
		
		@Test
		public void itemorderServicesCreate() {
			ItemOrder itemorder = new ItemOrder(1l,1l,1l);
			itemorderServices.create(itemorder);
			Mockito.verify(itemorderDao, Mockito.times(1)).create(itemorder);
		}
		
		@Test
		public void itemorderServicesRead() {
			itemorderServices.readAll();
			Mockito.verify(itemorderDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void itemorderServicesUpdate() {
			ItemOrder itemorder = new ItemOrder(1l, 1l);
			itemorderServices.update(itemorder);
			Mockito.verify(itemorderDao, Mockito.times(1)).update(itemorder);
		}
		
		@Test
		public void itemorderServicesDelete() {
			itemorderServices.delete(1L);;
			Mockito.verify(itemorderDao, Mockito.times(1)).delete(1L);
		}
	}