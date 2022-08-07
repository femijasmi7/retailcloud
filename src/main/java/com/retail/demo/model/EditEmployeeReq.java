package com.retail.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditEmployeeReq {

	@NotBlank(message = "Name is mandatory")
	private String name;

	private AddressReq address;

	private ContactNumberReq contactNumber;

	@Min(value = 1, message = "invalid designation")
	@Max(value = 5, message = "invalid designation")
	private Integer designation;

	private String email;

	private Double ctc;

	private Double experience;

	@Min(value = 1, message = "invalid bloodGroup")
	@Max(value = 8, message = "invalid bloodGroup")
	private Integer bloodGroup;

	public EditEmployeeReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditEmployeeReq(@NotBlank(message = "Name is mandatory") String name, AddressReq address,
			ContactNumberReq contactNumber,
			@Min(value = 1, message = "invalid designation") @Max(value = 5, message = "invalid designation") Integer designation,
			String email, Double ctc, Double experience,
			@Min(value = 1, message = "invalid bloodGroup") @Max(value = 8, message = "invalid bloodGroup") Integer bloodGroup) {
		super();
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.designation = designation;
		this.email = email;
		this.ctc = ctc;
		this.experience = experience;
		this.bloodGroup = bloodGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressReq getAddress() {
		return address;
	}

	public void setAddress(AddressReq address) {
		this.address = address;
	}

	public ContactNumberReq getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(ContactNumberReq contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getDesignation() {
		return designation;
	}

	public void setDesignation(Integer designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Integer getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "EditEmployeeReq [name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", designation=" + designation + ", email=" + email + ", ctc=" + ctc + ", experience=" + experience
				+ ", bloodGroup=" + bloodGroup + "]";
	}

}
