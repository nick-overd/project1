package com.qa.databases;

public class ItemOrder {
	
	private Long itorid;
	private Long itemid;
	private Long orderid;
	
	
	public ItemOrder(Long itorid, Long itemid, Long orderid) {
		super();
		this.itorid = itorid;
		this.itemid = itemid;
		this.orderid = orderid;
	}
	
	public ItemOrder(Long itemid, Long orderid) {
		super();
		this.itemid = itemid;
		this.orderid = orderid;
	}
	
	
	public Long getItorid() {
		return itorid;
	}
	public void setItorid(Long itorid) {
		this.itorid = itorid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

public String toString(){
		
		return "idorid:" + itorid + " orderid:"+ orderid + " itemid:" + itemid ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((itorid == null) ? 0 : itorid.hashCode());
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
		ItemOrder other = (ItemOrder) obj;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (itorid == null) {
			if (other.itorid != null)
				return false;
		} else if (!itorid.equals(other.itorid))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		return true;
	}

	

}