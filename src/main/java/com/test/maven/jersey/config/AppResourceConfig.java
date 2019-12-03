package com.test.maven.jersey.config;

import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.test.maven.jersey.filter.AuthenticationFilter;

/**
 * Register Logging Feature
 *
 */
//@ApplicationPath("resources")
public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		packages("com.test.maven.jersey");
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		
		//Register Auth Filter here
        register(AuthenticationFilter.class);
		      
        //register(GsonMessageBodyHandler.class);
 
        
		
	}
}