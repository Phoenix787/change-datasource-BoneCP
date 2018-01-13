package com.example.changedatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class ChangeDatasourceApplication implements CommandLineRunner  {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ChangeDatasourceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
	}
}
