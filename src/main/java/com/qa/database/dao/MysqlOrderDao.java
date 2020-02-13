package com.qa.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.databases.Order;

public class MysqlOrderDao implements Dao<Order>{

	
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("order_id");
		return new Order(orderid);
	}
	
	
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(customer_id) values( " + order.getCustomerid() + ");");
		} catch (Exception e) {
		
		}
		return order;
	}

	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root" ,"root12");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long orderid = resultSet.getLong("order_id");
				Long customerid = resultSet.getLong("customer_id");
				Order order = new Order(orderid, customerid);
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return orders;
	}

	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update orders set '"  + " where order_id=" + order.getOrderid() + ";");
		} catch (Exception e) {
		}
		return order;
	}

	public void delete(long id)  {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from orders where order_id=" + id + ";");
		} catch (Exception e) {
		
		}
		}
}
