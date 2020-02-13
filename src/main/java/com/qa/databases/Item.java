package com.qa.databases;

public class Item {
	
	private	Float cost;
	private String name;
	private Long id;
	
	
	
	public Item(Long id, Float cost, String name ) {
		this.cost = cost;
		this.name = name;
		this.id = id;
	}
	
	public Item(Float cost, String name) {
		this.cost = cost;
		this.name = name;
	}
	
	
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}



public String toString(){
		
		return "id:" + id + " cost:"+ cost + " name:" + name ;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cost == null) ? 0 : cost.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Item other = (Item) obj;
	if (cost == null) {
		if (other.cost != null)
			return false;
	} else if (!cost.equals(other.cost))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}


	
	

}