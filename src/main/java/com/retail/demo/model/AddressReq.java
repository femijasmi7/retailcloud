package com.retail.demo.model;

import javax.validation.constraints.NotBlank;

public class AddressReq {

	@NotBlank(message = "StreetAddress is mandatory")
	private String streetAddress;

	@NotBlank(message = "City is mandatory")
	private String city;

	@NotBlank(message = "State is mandatory")
	private String state;

	@NotBlank(message = "Country is mandatory")
	private String country;

	@NotBlank(message = "ZipCode is mandatory")
	private String zipCode;

	public AddressReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressReq(@NotBlank(message = "StreetAddress is mandatory") String streetAddress,
			@NotBlank(message = "City is mandatory") String city,
			@NotBlank(message = "State is mandatory") String state,
			@NotBlank(message = "Country is mandatory") String country,
			@NotBlank(message = "ZipCode is mandatory") String zipCode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "AddressReq [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zipCode=" + zipCode + "]";
	}

}
