package com.retail.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.demo.controller.EmployeeController;
import com.retail.demo.model.Address;
import com.retail.demo.model.AddressReq;
import com.retail.demo.model.AddressRes;
import com.retail.demo.model.ContactNumberReq;
import com.retail.demo.model.EditEmployeeReq;
import com.retail.demo.model.Employee;
import com.retail.demo.model.EmployeeReq;
import com.retail.demo.model.EmployeeRes;
import com.retail.demo.model.ExceptionMessages;
import com.retail.demo.model.PaymentStatus;
import com.retail.demo.repository.EmployeeRepository;
import com.retail.demo.resources.EmployeeBloodGroup;
import com.retail.demo.resources.EmployeeDesignation;

@Service
public class EmployeeService {

	org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SequenceGenerator sequenceGenerator;

	public List<EmployeeRes> addNewEmployee(@Valid List<EmployeeReq> req) {
		List<EmployeeRes> res = new ArrayList<EmployeeRes>();

		Iterator<EmployeeReq> iterator = req.iterator();
		while (iterator.hasNext()) {
			EmployeeReq employeeReq = (EmployeeReq) iterator.next();

			// address of employee
			AddressReq addressReq = employeeReq.getAddress();
			Address address = new Address(employeeReq.getName(), addressReq.getStreetAddress(), addressReq.getCity(),
					addressReq.getState(), addressReq.getCountry(), addressReq.getZipCode());

			// contact number
			ContactNumberReq contactNumberReq = employeeReq.getContactNumber();
			String contactNumber = contactNumberReq.getCountryCode() + contactNumberReq.getPhoneNumber();

			// designation
			String designation = getDesignation(employeeReq.getDesignation());

			// blood group
			String bloodGroup = getBloodGroup(employeeReq.getBloodGroup());

			Employee employee = new Employee(sequenceGenerator.getNextID(), employeeReq.getName(), address,
					contactNumber, designation, employeeReq.getEmail(), employeeReq.getCtc(),
					employeeReq.getExperience(), bloodGroup, false);
			employeeRepository.save(employee);

			// get response
			res.add(getEmployeeRes(employee));
		}
		return res;
	}

	private String getBloodGroup(Integer bloodgroup) {
		String bloodGroup;
		switch (bloodgroup) {
		case 1:
			bloodGroup = EmployeeBloodGroup.A_POSITIVE;
			break;

		case 2:
			bloodGroup = EmployeeBloodGroup.A_NEGETIVE;
			break;

		case 3:
			bloodGroup = EmployeeBloodGroup.B_POSITIVE;
			break;

		case 4:
			bloodGroup = EmployeeBloodGroup.B_NEGETIVE;
			break;

		case 5:
			bloodGroup = EmployeeBloodGroup.O_POSITIVE;
			break;

		case 6:
			bloodGroup = EmployeeBloodGroup.O_NEGETIVE;
			break;

		case 7:
			bloodGroup = EmployeeBloodGroup.AB_POSITIVE;
			break;

		case 8:
			bloodGroup = EmployeeBloodGroup.AB_NEGETIVE;
			break;

		default:
			bloodGroup = " ";
			break;
		}
		return bloodGroup;
	}

	private String getDesignation(Integer desig) {
		String designation;
		switch (desig) {
		case 1:
			designation = EmployeeDesignation.MANAGER;
			break;

		case 2:
			designation = EmployeeDesignation.DEVELOPER;
			break;

		case 3:
			designation = EmployeeDesignation.TECH_LEAD;
			break;

		case 4:
			designation = EmployeeDesignation.DESIGNER;
			break;

		case 5:
			designation = EmployeeDesignation.TESTER;
			break;

		default:
			designation = "";
			break;
		}
		return designation;
	}

	public List<EmployeeRes> getEmployeeDetails(Long empID) throws ExceptionHandler {
		List<EmployeeRes> res = new ArrayList<EmployeeRes>();

		// empid is null means return all employees
		if (empID == null) {
			List<Employee> findAllEmployees = employeeRepository.findAllEmployees();
			if (findAllEmployees == null) {
				logger.error(" No employees found");
				throw new ExceptionHandler(ExceptionMessages.EMPLOYEE_NOT_FOUND);
			}

			Iterator<Employee> iterator = findAllEmployees.iterator();
			while (iterator.hasNext()) {
				Employee employee = (Employee) iterator.next();
				res.add(getEmployeeRes(employee));
			}
			return res;
		} else {
			Optional<Employee> findByEmployeeID = employeeRepository.findByEmployeeID(empID);
			if (!findByEmployeeID.isPresent()) {
				logger.error("No employee found with given ID");
				throw new ExceptionHandler(ExceptionMessages.EMPLOYEE_NOT_FOUND);
			}
			Employee employee = findByEmployeeID.get();
			res.add(getEmployeeRes(employee));
			return res;
		}
	}

	private EmployeeRes getEmployeeRes(Employee employee) {
		// address
		Address address = employee.getAddress();
		AddressRes addressRes = new AddressRes(address.getStreetAddress(), address.getCity(), address.getState(),
				address.getCountry(), address.getZipCode());

		EmployeeRes res = new EmployeeRes(employee.getName(), addressRes, employee.getContactNumber(),
				employee.getDesignation(), employee.getEmail(), employee.getCtc(), employee.getExperience(),
				employee.getBloodGroup());

		return res;
	}

	public EmployeeRes editOrDeleteEmployee(long empID, boolean isDelete, @Valid EditEmployeeReq editReq)
			throws ExceptionHandler {
		Optional<Employee> findByEmployeeID = employeeRepository.findByEmployeeID(empID);
		if (!findByEmployeeID.isPresent()) {
			throw new ExceptionHandler(ExceptionMessages.BAD_REQUEST);
		}
		Employee employee = findByEmployeeID.get();

		// isDelete is true then employee will be deleted otherwise modify employee
		if (isDelete) {
			// delete tag is used to denote that the employee is deleted
			employee.setDelete(true);
			employeeRepository.save(employee);
			logger.info("employee deleted");
			// response
			return getEmployeeRes(employee);

		} else {
			if (editReq == null) {
				throw new ExceptionHandler(ExceptionMessages.BAD_REQUEST);
			}

			// name
			if (editReq.getName() != null) {
				employee.setName(editReq.getName());
			}

			// address
			Address address = employee.getAddress();
			AddressReq addressReq = editReq.getAddress();
			if (addressReq != null) {
				address = new Address(employee.getName(), addressReq.getStreetAddress(), addressReq.getCity(),
						addressReq.getState(), addressReq.getCountry(), addressReq.getZipCode());
				employee.setAddress(address);
			}

			// contact number
			if (editReq.getContactNumber() != null) {
				employee.setContactNumber(
						editReq.getContactNumber().getCountryCode() + editReq.getContactNumber().getPhoneNumber());
			}

			// designation
			if (editReq.getDesignation() != null) {
				String designation = getDesignation(editReq.getDesignation());
				employee.setDesignation(designation);
			}

			// email
			if (editReq.getEmail() != null) {
				employee.setEmail((editReq.getEmail()));
			}

			// ctc
			if (editReq.getCtc() != null) {
				employee.setCtc(editReq.getCtc());
			}

			// experience
			if (editReq.getExperience() != null) {
				employee.setExperience(editReq.getExperience());
			}

			// blood group
			if (editReq.getBloodGroup() != null) {
				String bloodGroup = getBloodGroup(editReq.getBloodGroup());
				employee.setBloodGroup(bloodGroup);
			}

			employeeRepository.save(employee);
			return getEmployeeRes(employee);
		}
	}

	public PaymentStatus getCountOfEmployee() {
		long overPaid = 0;
		long underPaid = 0;

		List<Employee> findAllEmployees = employeeRepository.findAllEmployees();
		Iterator<Employee> iterator = findAllEmployees.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			Double status = employee.getCtc() / employee.getExperience();

			if (status > 1) {
				overPaid += 1;
			}

			if (status < 1) {
				underPaid += 1;
			}
		}

		return new PaymentStatus(overPaid, underPaid);
	}

	public List<EmployeeRes> getEmployeesByBloodGroup(Integer bloodGroup) throws ExceptionHandler {
		List<EmployeeRes> res = new ArrayList<EmployeeRes>();

		// get corresponding string value of integer blood group
		String bloodgp = getBloodGroup(bloodGroup);

		if (bloodgp.equals(" ")) {
			throw new ExceptionHandler(ExceptionMessages.BAD_REQUEST);
		}

		List<Employee> findByBloodGroup = employeeRepository.findByBloodGroup(bloodgp);
		if (findByBloodGroup != null) {
			Iterator<Employee> iterator = findByBloodGroup.iterator();
			while (iterator.hasNext()) {
				Employee employee = (Employee) iterator.next();
				res.add(getEmployeeRes(employee));
				logger.info(res.toString());
			}
		}
		return res;
	}

}
