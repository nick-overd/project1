package com.qa.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.databases.Customer;



public class MysqlCustomerDao implements Dao <Customer>{
	private Connection connection;
	public static final Logger LOGGER = Logger.getLogger(MysqlCustomerDao.class);
	
	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("first_name");
		return new Customer(id, firstName);
	}
	
	
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(first_name) values(' " + customer.getName() + "')");
			return readLatest();
		} catch (Exception e) {
		
		}
		return customer;
	}
// customer name hard coded since it's the only thing they can change
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers set customer_name = '" + customer.getName() + "' where customer_id=" + customer.getId() + ";");
		} catch (Exception e) {
		}
		
		return customer;
	}

	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12")){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from customers where customer_id=" + id + ";");
		} catch (Exception e) {
		}
		
	}
	
	public Customer readLatest() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root", "root12");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM customers ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.246.46.47:3306/assignment", "root" ,"root12");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
			while (resultSet.next()) {
				Long id = resultSet.getLong("customer_id");
				String firstname = resultSet.getString("customer_name");
				Customer customer = new Customer(id, firstname);
				customers.add(customer);
			}
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} 
		return customers;
	}

	}
