package com.test.maven.jersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.core.*;

import com.test.maven.jersey.support.Employee;
import com.test.maven.jersey.support.Employees;

import java.util.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;

  
@Path("/employees")
public class EmployeeListService {
	
	//@RolesAllowed("ADMIN")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllEployees() 
	{
	    Employees list = new Employees();
	    list.setEmployeeList(new ArrayList<Employee>());
	     
	    list.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
	    list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
	    list.getEmployeeList().add(new Employee(3, "David Kameron"));
	     
	    return Response.ok().entity(list).cookie(new NewCookie("cookieResponse", "cookieValueInReturn")).build();
	}

}
