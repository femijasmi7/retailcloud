package com.retail.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.demo.model.EditEmployeeReq;
import com.retail.demo.model.EmployeeReq;
import com.retail.demo.model.EmployeeRes;
import com.retail.demo.model.PaymentStatus;
import com.retail.demo.service.EmployeeService;
import com.retail.demo.service.ExceptionHandler;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/emp")
	public ResponseEntity<?> addNewEmployee(@Valid @RequestBody List<EmployeeReq> req) {
		logger.info("add new employees");
		List<EmployeeRes> res = employeeService.addNewEmployee(req);
		return ResponseEntity.ok().body(res);
	}

	@GetMapping("/emp")
	public ResponseEntity<?> getEmployeeDetails(@RequestParam(required = false, name = "empID") Long empID)
			throws ExceptionHandler {
		logger.info("get details of employees");
		List<EmployeeRes> res = employeeService.getEmployeeDetails(empID);
		return ResponseEntity.ok().body(res);
	}

	@PutMapping("/emp/{empID}")
	public ResponseEntity<?> editOrDeleteEmployee(@RequestParam(required = true, name = "isDelete") boolean isDelete,
			@PathVariable(name = "empID") long empID, @Valid @RequestBody EditEmployeeReq editReq)
			throws ExceptionHandler {
		logger.info("edit or delete employee");
		EmployeeRes res = employeeService.editOrDeleteEmployee(empID, isDelete, editReq);
		return ResponseEntity.ok().body(res);
	}

	@GetMapping("/emp/payment_status")
	public ResponseEntity<?> getCountOfEmployee() {
		logger.info("get count of overpaid and underpaid employees");
		PaymentStatus res = employeeService.getCountOfEmployee();
		return ResponseEntity.ok().body(res);
	}

	@GetMapping("/emp/blood_group")
	public ResponseEntity<?> getEmployeesByBloodGroup(
			@RequestParam(required = true, name = "bloodGroup") Integer bloodGroup) throws ExceptionHandler {
		logger.info("get employees by bloodgroup");
		List<EmployeeRes> res = employeeService.getEmployeesByBloodGroup(bloodGroup);
		return ResponseEntity.ok().body(res);
	}

}
