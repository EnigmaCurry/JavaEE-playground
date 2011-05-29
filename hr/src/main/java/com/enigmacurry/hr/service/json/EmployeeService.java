package com.enigmacurry.hr.service.json;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.enigmacurry.hr.model.Employee;
import com.enigmacurry.hr.service.exception.ServiceEntityNotFoundException;

public interface EmployeeService {

	public Employee getEmployeeById(long id);

	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee emp);

	public Employee updateEmployee(Employee emp) throws ServiceEntityNotFoundException;

	public void deleteEmployee(Employee emp) throws ServiceEntityNotFoundException;

}