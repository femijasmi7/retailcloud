package com.retail.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.retail.demo.model.Employee;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	@Query(value = "{delete:false}")
	public List<Employee> findAllEmployees();

	@Query(value = "{delete:false,id:?0}")
	public Optional<Employee> findByEmployeeID(Long empID);

	@Query(value = "{delete:false,bloodGroup:?0}")
	public List<Employee> findByBloodGroup(String bloodgp);

}
