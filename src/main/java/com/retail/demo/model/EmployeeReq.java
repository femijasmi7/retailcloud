package com.retail.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeReq {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotNull(message = "Address is mandatory")
	private AddressReq address;

	@NotNull(message = "ContactNumber is mandatory")
	private ContactNumberReq contactNumber;

	@NotNull(message = "Designation is mandatory")
	@Min(value = 1, message = "invalid designation")
	@Max(value = 5, message = "invalid designation")
	private Integer designation;

	@NotNull(message = "email is mandatory")
	private String email;

	@NotNull(message = "ctc is mandatory")
	private Double ctc;

	@NotNull(message = "experience is mandatory")
	private Double experience;

	@NotNull(message = "bloodGroup is mandatory")
	@Min(value = 1, message = "invalid bloodGroup")
	@Max(value = 8, message = "invalid bloodGroup")
	private Integer bloodGroup;

	public EmployeeReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeReq(@NotBlank(message = "Name is mandatory") String name,
			@NotNull(message = "Address is mandatory") AddressReq address,
			@NotNull(message = "ContactNumber is mandatory") ContactNumberReq contactNumber,
			@NotNull(message = "Designation is mandatory") Integer designation, String email,
			@NotNull(message = "ctc is mandatory") Double ctc, Double experience,
			@NotNull(message = "Designation is mandatory") Integer bloodGroup) {
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
		return "EmployeeReq [name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", designation=" + designation + ", email=" + email + ", ctc=" + ctc + ", experience=" + experience
				+ ", bloodGroup=" + bloodGroup + "]";
	}

}
