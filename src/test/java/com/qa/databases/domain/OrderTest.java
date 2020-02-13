package com.qa.databases.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.databases.Order;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(1L, 1L);
		other = new Order(1L, 1L);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrderid());
		assertNotNull(order.getCustomerid());
		
		order.setOrderid(null);
		assertNull(order.getOrderid());
		order.setCustomerid(null);
		assertNull(order.getCustomerid());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithOrderid() {
		assertEquals(1L, order.getOrderid(), 0);
		assertEquals(1L, order.getCustomerid(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderCustomeridNullButOtherCustomeridNotNull() {
		order.setCustomerid(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void orderCustomeridsNotEqual() {
		other.setCustomerid(2l);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullCustomerid() {
		order.setCustomerid(null);
		other.setCustomerid(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullOrderid() {
		order.setOrderid(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullOrderidOnBoth() {
		order.setOrderid(null);
		other.setOrderid(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherOrderidDifferent() {
		other.setOrderid(2L);
		assertFalse(order.equals(other));
	}
	
	
	@Test
	public void constructorWithoutOrderid() {
		Order order = new Order(1l);
		assertNull(order.getOrderid());
		assertNotNull(order.getCustomerid());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null);
		Order other = new Order(null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "orderid:1 customerid:1";
		assertEquals(toString, order.toString());
	}
}