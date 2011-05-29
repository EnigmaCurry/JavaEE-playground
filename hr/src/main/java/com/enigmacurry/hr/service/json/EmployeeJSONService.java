package com.enigmacurry.hr.service.json;

import java.util.*;

import javax.ejb.*;
import javax.enterprise.context.Dependent;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.enigmacurry.hr.model.Employee;
import com.enigmacurry.hr.service.EmployeeServiceBean;
import com.enigmacurry.hr.service.exception.ServiceEntityNotFoundException;
import com.enigmacurry.hr.service.json.exception.JSONServiceEntityNotFoundException;

@Stateless
@Path("/employee")
@Produces("application/json")
public class EmployeeJSONService {
	@EJB
	EmployeeService service;
	
	@GET
	@Path("/{id: [0-9]+}")
	public Employee getEmployeeById(@PathParam("id") long id) {
		Employee emp = service.getEmployeeById(id);
		if (emp == null) {
			throw new WebApplicationException(404);
		}
		return emp;
	}
	
	@GET
	@Path("/all")
	public List<Employee> getAllEmployees(){
		List<Employee> empList = service.getAllEmployees();
		return empList;
	}

	@DELETE
	@Path("/{id: [0-9]+}")
	public void deleteEmployee(@PathParam("id") long id) {
		try {
			Employee emp = new Employee();
			emp.setId(id);
			service.deleteEmployee(emp);
		} catch (ServiceEntityNotFoundException e) {
			throw new JSONServiceEntityNotFoundException(
					"Employee not found for id: " + id);
		}
	}

	@POST
	@Consumes("application/json")
	public Employee createEmployee(Employee emp) {
		service.createEmployee(emp);
		return emp;
	}

	@PUT
	@Consumes("application/json")
	public Employee updateEmployee(Employee emp) {
		try {
			service.updateEmployee(emp);
		} catch (ServiceEntityNotFoundException e) {
			throw new JSONServiceEntityNotFoundException(
					"Employee not found for id: " + emp.getId());
		}
		return emp;
	}
	
}
