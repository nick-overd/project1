package com.qa.database.runner;

import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.database.dao.MysqlCustomerDao;
import com.qa.database.dao.MysqlItemDao;
import com.qa.database.dao.MysqlItemOrderDao;
import com.qa.database.dao.MysqlOrderDao;
import com.qa.databases.Customer;
import com.qa.databases.Item;
import com.qa.databases.ItemOrder;
import com.qa.databases.Order;

public class Runner2 {

	public static void main(String[] args) throws SQLException{
		// customer
		MysqlCustomerDao customerdao = new MysqlCustomerDao();
		ArrayList<Customer> customers = customerdao.readAll();
		for(Customer customer : customers) {
			System.out.println(customer.getId() + " " + customer.getName());
			}
		//order
		MysqlOrderDao orderdao = new MysqlOrderDao();
		ArrayList<Order> orders = orderdao.readAll();
		for(Order order : orders) {
			System.out.println(order.getOrderid() + " " + order.getCustomerid());
		}
		//item
		MysqlItemDao itemdao = new MysqlItemDao();
		ArrayList<Item> items = itemdao.readAll();
		for(Item item : items) {
			System.out.println(item.getId() + " " + item.getName() + " " +  item.getCost());
		}
		//itemorder
		MysqlItemOrderDao itemorderdao = new MysqlItemOrderDao();
		ArrayList<ItemOrder> itemorders = itemorderdao.readAll();
		for(ItemOrder ItemOrder : itemorders) {
			System.out.println(ItemOrder.getItorid() + " " + ItemOrder.getOrderid() + " " + ItemOrder.getItemid());
		
		}	
	}

}
