package com.qa.database.runner;

import org.apache.log4j.Logger;

import com.qa.database.controller.Action;
import com.qa.database.controller.CrudController;
import com.qa.database.controller.CustomerController;
import com.qa.database.controller.OrderController;
import com.qa.database.dao.MysqlCustomerDao;
import com.qa.database.services.CustomerServices;
import com.qa.database.utils.Utils;
import com.qa.databases.Domain;

public class Ims {
	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	
	public void imsSystem() {
		while (true) {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		
		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();
		
		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();
		
		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(new CustomerServices(new MysqlCustomerDao()));
			doAction(customerController, action);
			break;
		case ITEM:
			break;
		case ORDER:
//			OrderController orderController = new OrderController(new OrderServices(new MysqlOrderDao()));
//			doAction(orderController, action);
			break;
		case STOP:
			break;
			
		default:
			break;
		}
		
	}
	}
	
	public void doAction(CrudController crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
				imsSystem();
		default:
			break;
		}
	}
}