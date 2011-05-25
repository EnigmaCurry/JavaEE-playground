package com.enigmacurry.hr.service.json;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.enigmacurry.hr.model.Employee;
import com.enigmacurry.hr.service.exception.ServiceEntityNotFoundException;
import com.enigmacurry.hr.service.exception.ServiceException;

public interface EmployeeService {

	public abstract Employee getEmployeeById(long id);

	public abstract Employee createEmployee(Employee emp);

	public abstract Employee updateEmployee(Employee emp) throws ServiceEntityNotFoundException;

	public abstract void deleteEmployee(Employee emp) throws ServiceEntityNotFoundException;

}