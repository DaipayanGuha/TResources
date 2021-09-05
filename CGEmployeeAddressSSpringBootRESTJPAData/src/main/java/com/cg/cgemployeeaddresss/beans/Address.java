package com.cg.cgemployeeaddresss.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
//@Embeddable
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	
	private String road;
	private String city;
	private String state;
	private int pincode;
	
	@MapKey
	@OneToMany(mappedBy="address",fetch=FetchType.EAGER)
	public Map<Integer,Address> address=new HashMap<Integer, Address>();

	public Address() {}

	public Address(String road, String city, String state, int pincode) {
		super();
		this.road = road;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + pincode;
		result = prime * result + ((road == null) ? 0 : road.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (pincode != other.pincode)
			return false;
		if (road == null) {
			if (other.road != null)
				return false;
		} else if (!road.equals(other.road))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [road=" + road + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
