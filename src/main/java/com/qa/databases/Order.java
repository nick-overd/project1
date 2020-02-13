package com.qa.databases;

public class Order {
	
	private Long orderid ;
	private Long customerid;
	
	public Order(Long customerid) {
		this.customerid = customerid;
	}
	
	
	public Order(Long orderid, Long customerid) {
		this.orderid = orderid;
		this.customerid = customerid;
	}
	
	
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
public String toString(){
		
		return "orderid:" + orderid + " customerid:" + customerid;
	}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
	result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	if (customerid == null) {
		if (other.customerid != null)
			return false;
	} else if (!customerid.equals(other.customerid))
		return false;
	if (orderid == null) {
		if (other.orderid != null)
			return false;
	} else if (!orderid.equals(other.orderid))
		return false;
	return true;
}

	

}