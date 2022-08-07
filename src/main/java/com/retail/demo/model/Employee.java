package com.retail.demo.model;

import org.springframework.data.annotation.Id;

public class Employee {
	@Id
	private long id;
	private String name;
	private Address address;
	private String contactNumber;
	private String designation;
	private String email;
	private Double ctc;
	private Double experience;
	private String bloodGroup;
	// resigned or employee not working with this firm are marked as delete
	private boolean delete;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String name, Address address, String contactNumber, String designation, String email,
			Double ctc, Double experience, String bloodGroup, boolean delete) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.designation = designation;
		this.email = email;
		this.ctc = ctc;
		this.experience = experience;
		this.bloodGroup = bloodGroup;
		this.delete = delete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", designation=" + designation + ", email=" + email + ", ctc=" + ctc + ", experience=" + experience
				+ ", bloodGroup=" + bloodGroup + ", delete=" + delete + "]";
	}

}
