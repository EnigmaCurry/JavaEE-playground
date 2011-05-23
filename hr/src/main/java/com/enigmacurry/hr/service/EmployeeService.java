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

@Stateless
@Path("/employee")
@Produces("application/json")
public class EmployeeService {	
	@PersistenceContext(unitName="hr")
	private EntityManager em;
	
    @POST
    @Consumes("application/json")
    @Path("/create")
	public Employee createEmployee(Employee emp){
		em.persist(emp);
		return emp;
	}

	@GET
	@Path("/{id: [0-9]+}")
	public Employee test(@PathParam("id") long id){
		Employee emp = em.find(Employee.class,id);
		if(emp == null){
			throw new WebApplicationException(404);
		}
		return emp;		
	}
}
