package com.retail.demo.model;

public class EmployeeRes {

	private String name;
	private AddressRes address;
	private String contactNumber;
	private String designation;
	private String email;
	private Double ctc;
	private Double experience;
	private String bloodGroup;

	public EmployeeRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRes(String name, AddressRes address, String contactNumber, String designation, String email,
			Double ctc, Double experience, String bloodGroup) {
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

	public AddressRes getAddress() {
		return address;
	}

	public void setAddress(AddressRes address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "EmployeeRes [name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", designation=" + designation + ", email=" + email + ", ctc=" + ctc + ", experience=" + experience
				+ ", bloodGroup=" + bloodGroup + "]";
	}

}
