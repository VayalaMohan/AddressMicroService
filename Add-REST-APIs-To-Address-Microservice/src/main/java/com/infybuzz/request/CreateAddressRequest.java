package com.infybuzz.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CreateAddressRequest {

	private long addressId;
	@NotNull(message="Street name size can't be Null")
	@NotEmpty(message="Street name size can't be Empty")
	@Size(max = 100, min = 5, message="Street name size can't be leaa than 5 and grater than 100")
	private String street;
	
	private String city;

	
	public CreateAddressRequest(long addressId, String street, String city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
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

}
