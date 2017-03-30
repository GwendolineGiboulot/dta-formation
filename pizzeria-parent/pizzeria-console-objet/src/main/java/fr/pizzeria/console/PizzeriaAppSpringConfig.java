package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.aspect.MesurerPerformance;
import fr.pizzeria.dao.PizzaDaoImplSpringData;

@Import({ PizzaDaoImplSpringData.class, MesurerPerformance.class })
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("fr.pizzeria.ihm")
@EnableJpaRepositories("fr.pizzeria.repo")
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		return txManager;
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-pu");
		return emf;
	}

}
