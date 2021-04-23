package com.example.JavaTemplate.Test;


import LoggerLib.LoggerWrapper;


/*@ComponentScan(basePackages = "LoggerLib")
@PropertySource("classpath:application.properties")*/
public class ConsoleBusMonitor {

	/*
	 * static { System.setProperty("logback.configurationFile",
	 * "/path/to/config.xml");}
	 */
	
	static LoggerWrapper mLogger = new LoggerWrapper("ConsoleBusMonitor.class");
	        
	     public static void main(String[] args) {   	
	    	
	    System.out.println("World");
	    	mLogger.error("Error");
	    	mLogger.info("Detailed Information");
	            mLogger.debug("Before Assign Contest");           
	            mLogger.debug("After Assign Contest");
	            mLogger.fatal("fatalHandling");
	            mLogger.verbose("VerbHandling");
	            mLogger.error("ErrorHandling");
	            
	          
	         System.out.println("Hello");
//	            TestProperties testProperties = new TestProperties() { RawData = "Raw1", Serivece = "service Started", State = Status.Running };
//	            mlogger.Fatal("Error With Properties -{0} - Test", testProperties);
//	         SpringApplication.run(ConsoleBusMonitor.class, args);
	        }
}
