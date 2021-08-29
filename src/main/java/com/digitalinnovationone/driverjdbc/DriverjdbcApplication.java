package com.digitalinnovationone.driverjdbc;

import com.digitalinnovationone.driverjdbc.db.connection.ConnectionFactory;
import com.digitalinnovationone.driverjdbc.db.connection.ConnectionParameter;
import com.digitalinnovationone.driverjdbc.model.Curso;
import com.digitalinnovationone.driverjdbc.model.dao.CursoDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverjdbcApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(DriverjdbcApplication.class, args);

		System.out.println("Conectando com Mysql");

		ConnectionParameter parameterMysql = new ConnectionParameter();
		parameterMysql.setDriver("mysql");
		parameterMysql.setHost("localhost");
		parameterMysql.setDatabase("curso");
		parameterMysql.setUsername("root");
		parameterMysql.setPassword("admin");
		parameterMysql.setPort("3307");

		ConnectionFactory connectionMysql = new ConnectionFactory(parameterMysql);
		connectionMysql.connection();

		CursoDao cursoDaoMysql = new CursoDao(connectionMysql);

		cursoDaoMysql.inserir(new Curso("PostgreSql", "11:00:00"));
		cursoDaoMysql.inserir(new Curso("Mysql", "11:00:00"));
		cursoDaoMysql.inserir(new Curso("SqlServer", "11:00:00"));

		java.util.List<Curso> listaMysql = null;
		listaMysql = cursoDaoMysql.pesquisar();
		for (Curso c : listaMysql) {
			System.out.println(c);
		}

		System.out.println("-------");
		cursoDaoMysql.deletar(3);
		cursoDaoMysql.atualizar(new Curso(1, "JAVA", "10:00:00"));

		listaMysql = cursoDaoMysql.pesquisar();
		for (Curso c : listaMysql) {
			System.out.println(c);
		}

		System.out.println("----------------------------------------------");
		System.out.println("Conectando com PostgreSql");

		ConnectionParameter parameterPostgres = new ConnectionParameter();
		parameterPostgres.setDriver("postgresql");
		parameterPostgres.setHost("localhost");
		parameterPostgres.setDatabase("curso");
		parameterPostgres.setUsername("postgres");
		parameterPostgres.setPassword("123456");
		parameterPostgres.setPort("5433");

		ConnectionFactory connectionPostgres = new ConnectionFactory(parameterPostgres);
		connectionPostgres.connection();

		CursoDao cursoDaoPostgres = new CursoDao(connectionPostgres);

		cursoDaoPostgres.inserir(new Curso("PostgreSql", "11:00:00"));
		cursoDaoPostgres.inserir(new Curso("Mysql", "11:00:00"));
		cursoDaoPostgres.inserir(new Curso("SqlServer", "11:00:00"));

		java.util.List<Curso> listaPost = null;
		listaPost = cursoDaoPostgres.pesquisar();
		for (Curso c : listaPost) {
			System.out.println(c);
		}
		System.out.println("-------");

		cursoDaoPostgres.deletar(3);
		cursoDaoPostgres.atualizar(new Curso(1, "JAVA", "10:00:00"));

		listaPost = cursoDaoPostgres.pesquisar();
		for (Curso c : listaPost) {
			System.out.println(c);
		}

	}

}
