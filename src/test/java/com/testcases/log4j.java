package com.testcases;
import org.apache.logging.log4j.*;

public class log4j {
	static Logger demologger = LogManager.getLogger(log4j.class.getName());

	public static void main(String[] args) {
		
		System.out.println("logging info");
		demologger.info("testing");
		demologger.error("error ocurred");
		demologger.debug("start debugging");
	}

}
