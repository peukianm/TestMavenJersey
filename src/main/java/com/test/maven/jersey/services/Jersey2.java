package com.test.maven.jersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
  
@Path("/js2message")
public class Jersey2
{
    @GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2";
    }
}
