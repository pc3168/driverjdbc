package com.digitalinnovationone.driverjdbc;

import com.digitalinnovationone.driverjdbc.db.connection.ConnectionFactory;
import com.digitalinnovationone.driverjdbc.db.connection.ConnectionParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverjdbcApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(DriverjdbcApplication.class, args);


		ConnectionParameter parameter = new ConnectionParameter();
		parameter.setDriver("mysql");
		parameter.setHost("localhost");
		parameter.setDatabase("gerente");
		parameter.setUsername("root");
		parameter.setPassword("admin");
		parameter.setPort("3307");

		ConnectionFactory connection = new ConnectionFactory(parameter);
		connection.connection();

	}

}
