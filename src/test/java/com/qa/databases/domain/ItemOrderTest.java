package com.qa.databases.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.databases.ItemOrder;

public class ItemOrderTest {
	
	private ItemOrder itemorder;
	private ItemOrder other;
	
	@Before
	public void setUp() {
		itemorder = new ItemOrder(1L, 1l);
		other = new ItemOrder(1L, 1l);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(itemorder.getItorid());
		assertNotNull(itemorder.getOrderid());
		assertNotNull(itemorder.getItemid());
		
		itemorder.setItorid(null);
		assertNull(itemorder.getItorid());
		itemorder.setItemid(null);
		assertNull(itemorder.getItemid());
		itemorder.setItorid(null);
		assertNull(itemorder.getOrderid());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(itemorder.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(itemorder.equals(new Object()));
	}
	
	@Test
	public void createItemOrderWithId() {
		assertEquals(1L, itemorder.getItorid(), 0);
		assertEquals(1l ,itemorder.getItemid(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(itemorder.equals(itemorder));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(itemorder.equals(other));
	}
	
	@Test
	public void itemorderNameNullButOtherNameNotNull() {
		itemorder.setOrderid(null);
		assertFalse(itemorder.equals(other));
	}
	
	@Test
	public void itemorderNamesNotEqual() {
		other.setOrderid(2l);
		assertFalse(itemorder.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		itemorder.setOrderid(null);
		other.setOrderid(null);
		assertTrue(itemorder.equals(other));
	}
	
	@Test
	public void nullId() {
		itemorder.setItorid(null);
		assertFalse(itemorder.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		itemorder.setItorid(null);
		other.setItorid(null);
		assertTrue(itemorder.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setItorid(2L);
		assertFalse(itemorder.equals(other));
	}
	
	
	@Test
	public void constructorWithoutId() {
		ItemOrder itemorder = new ItemOrder(1l, 1l);
		assertNull(itemorder.getItorid());
		assertNotNull(itemorder.getOrderid());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(itemorder.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		ItemOrder itemorder = new ItemOrder(null, null);
		ItemOrder other = new ItemOrder(null, null);
		assertEquals(itemorder.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "itemid:1  orderid:1";
		assertEquals(toString, itemorder.toString());
	}
}