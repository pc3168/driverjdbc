package com.digitalinnovationone.driverjdbc;

import com.digitalinnovationone.driverjdbc.db.connection.ConnectionFactory;
import com.digitalinnovationone.driverjdbc.db.connection.ConnectionParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverjdbcApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(DriverjdbcApplication.class, args);


		ConnectionParameter parameterMysql = new ConnectionParameter();
		parameterMysql.setDriver("mysql");
		parameterMysql.setHost("localhost");
		parameterMysql.setDatabase("gerente");
		parameterMysql.setUsername("root");
		parameterMysql.setPassword("admin");
		parameterMysql.setPort("3307");

		ConnectionFactory connectionMysql = new ConnectionFactory(parameterMysql);
		connectionMysql.connection();

		System.out.println("----------------------------------------------");

		ConnectionParameter parameterPostgres = new ConnectionParameter();
		parameterPostgres.setDriver("postgresql");
		parameterPostgres.setHost("localhost");
		parameterPostgres.setDatabase("curso");
		parameterPostgres.setUsername("postgres");
		parameterPostgres.setPassword("123456");
		parameterPostgres.setPort("5433");

		ConnectionFactory connectionPostgres = new ConnectionFactory(parameterPostgres);
		connectionPostgres.connection();

	}

}
