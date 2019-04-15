package com.dawnpro.bigdata.hbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SpringBootApplication
public class HbaseApplication {
	private static final Log log = LogFactory.getLog(HbaseApplication.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/application-context.xml", HbaseApplication.class);
		log.info("HBase Application Running");
		context.registerShutdownHook();
		SpringApplication.run(HbaseApplication.class, args);
	}

}
