package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpljdbcTemplate;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class DaoConfig {

	@Bean
	public IDao<Pizza, String> pizzaDao() {

		DriverManagerDataSource dataSourceTest = new DriverManagerDataSource();
		dataSourceTest.setDriverClassName("com.mysql.jdbc.Driver");
		dataSourceTest.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
		dataSourceTest.setUsername("root");
		dataSourceTest.setPassword("");

		return new PizzaDaoImpljdbcTemplate(dataSourceTest);
	}

}