package com.test.maven.jersey.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.stream.*;

import org.glassfish.jersey.jsonp.*;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.*;

import com.test.maven.jersey.filter.AuthenticationFilter;


/**
 * Manual Register JSONP
 *
 */
public class CustomApplication extends ResourceConfig 
{
    public CustomApplication() 
    {   	
    	register(JsonProcessingFeature.class);
        packages("com.test.maven.jersey");
        packages("org.glassfish.jersey.examples.jsonp");        
        property(JsonGenerator.PRETTY_PRINTING, true);
        
        //Todo Register Logger
//        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
//				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		
		//Register Auth Filter here
        register(AuthenticationFilter.class);
 
    }
}
