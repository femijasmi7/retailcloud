package com.retail.demo.model;

public class Address {
	// employee name
	private String employeeName;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipCode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String employeeName, String streetAddress, String city, String state, String country,
			String zipCode) {
		super();
		this.employeeName = employeeName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
		return "Address [employeeName=" + employeeName + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}

}
