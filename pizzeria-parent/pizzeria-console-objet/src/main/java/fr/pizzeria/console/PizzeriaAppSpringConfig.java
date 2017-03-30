package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpljdbcTemplate;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}

	@Bean
	public IDao<Pizza, String> pizzaDao() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:conf/schema.sql")
				.addScripts("classpath:conf/test-data.sql").build();

		return new PizzaDaoImpljdbcTemplate(db);

	}

}
