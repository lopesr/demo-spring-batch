package org.rodrigolopes.demo.batch.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.rodrigolopes.demo.batch.*"})
public class DemoBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBatchApplication.class, args);
	}
}
