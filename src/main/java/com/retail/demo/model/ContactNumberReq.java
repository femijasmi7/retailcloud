package com.retail.demo.model;

import javax.validation.constraints.NotNull;

public class ContactNumberReq {
	@NotNull(message = "countryCode is mandatory")
	private String countryCode;
	@NotNull(message = "phoneNumber is mandatory")
	private String phoneNumber;

	public ContactNumberReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactNumberReq(@NotNull(message = "countryCode is mandatory") String countryCode,
			@NotNull(message = "phoneNumber is mandatory") String phoneNumber) {
		super();
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactNumberReq [countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + "]";
	}

}
