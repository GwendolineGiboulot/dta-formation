package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpljdbcTemplate;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfigSQL {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}

	@Bean
	public IDao<Pizza, String> pizzaDao() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return new PizzaDaoImpljdbcTemplate(dataSource);

	}

}
