package com.infybuzz.response;

import com.infybuzz.entity.Address;
import com.infybuzz.request.Status;

public class AddressResponse {

	private long addressId;

	private String street;

	private String city;
	
	private Status status;
	
	
	public AddressResponse(Address address, Status status) {
		this.addressId = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
		this.status = status;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
