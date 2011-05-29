package com.enigmacurry.hr.service;

import java.util.*;

import javax.ejb.*;
import javax.enterprise.context.Dependent;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.enigmacurry.hr.model.Employee;
import com.enigmacurry.hr.service.exception.ServiceEntityNotFoundException;
import com.enigmacurry.hr.service.json.EmployeeService;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
	@PersistenceContext(unitName = "hr")
	private EntityManager em;

	@Override
	public Employee getEmployeeById(long id) {
		//Get employee by id, as long as it isn't soft deleted.
		Employee emp = (Employee) em.createNamedQuery("getNonDeletedById")
				.setParameter("id", id).getSingleResult();
		return emp;
	}	
	
	@Override
	public List<Employee> getAllEmployees() {
		//Get employee by id, as long as it isn't soft deleted.
		List<Employee> empList = em.createNamedQuery("getAllNonDeleted").getResultList();
		return empList;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp)
			throws ServiceEntityNotFoundException {
		// The given employee must have an id, and it must already exist in the
		// DB
		if (emp.getId() == null) {
			throw new NullPointerException();
		} else if (getEmployeeById(emp.getId()) == null) {
			throw new ServiceEntityNotFoundException();
		}
		emp = em.merge(emp);
		return emp;
	}

	@Override
	/** Soft delete of the employee */
	public void deleteEmployee(Employee emp)
			throws ServiceEntityNotFoundException {
		if (emp.getId() == null) {
			throw new NullPointerException();
		}
		Employee existingEmp = getEmployeeById(emp.getId());
		if (existingEmp == null) {
			throw new ServiceEntityNotFoundException();
		}
		existingEmp.delete();
		em.persist(existingEmp);
	}

}
