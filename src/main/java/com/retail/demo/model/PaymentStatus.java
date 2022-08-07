package com.retail.demo.model;

public class PaymentStatus {
	private long overPaidEmployees;
	private long underPaidEmployees;

	public PaymentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentStatus(long overPaidEmployees, long underPaidEmployees) {
		super();
		this.overPaidEmployees = overPaidEmployees;
		this.underPaidEmployees = underPaidEmployees;
	}

	public long getOverPaidEmployees() {
		return overPaidEmployees;
	}

	public void setOverPaidEmployees(long overPaidEmployees) {
		this.overPaidEmployees = overPaidEmployees;
	}

	public long getUnderPaidEmployees() {
		return underPaidEmployees;
	}

	public void setUnderPaidEmployees(long underPaidEmployees) {
		this.underPaidEmployees = underPaidEmployees;
	}

	@Override
	public String toString() {
		return "PaymentStatus [overPaidEmployees=" + overPaidEmployees + ", underPaidEmployees=" + underPaidEmployees
				+ "]";
	}

}
