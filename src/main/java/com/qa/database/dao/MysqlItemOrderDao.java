package com.qa.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.databases.ItemOrder;

public class MysqlItemOrderDao implements Dao<ItemOrder>{
	
//	private Connection connection;
	
	
	ItemOrder itemorderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("order_id");
		Long customerid = resultSet.getLong("customer_id");
		return new ItemOrder(orderid, customerid);
	}
	

	public ItemOrder create(ItemOrder itemsorders) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items_orders(customer_id) values( " + itemsorders.getItemid() + "," + itemsorders.getOrderid() + ");");
		} catch (Exception e) {
		
		}
		return itemsorders;
	}

	public ArrayList<ItemOrder> readAll() {
		ArrayList<ItemOrder> itemorders = new ArrayList<ItemOrder>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root" ,"root12");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items_orders");
			while (resultSet.next()) {
				Long itorid = resultSet.getLong("it_or_id");
				Long itemid = resultSet.getLong("item_id");
				Long orderid = resultSet.getLong("order_id");
				ItemOrder itemorder = new ItemOrder(itorid, itemid, orderid);
				itemorders.add(itemorder);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return itemorders;
	}

	public ItemOrder update(ItemOrder itemorder) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update items_orders set item_id = " + itemorder.getItemid() + ", set order_id = " + itemorder.getOrderid() + "  where item_id=" + itemorder.getItorid() + ";");
		} catch (Exception e) {
		}
		return itemorder;
	}

	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from items_orders where it_or_id=" + id + ";");
		} catch (Exception e) {
		}	
	}

}
