package fr.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.aspect.MesurerPerfoIngredient;

@Import({ MesurerPerfoIngredient.class })
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories("fr.pizzeria.repo")
@ComponentScan("fr.pizzeria.controller")
public class SpringConfig {

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

	@Bean
	public InternalResourceViewResolver internalRVS() {
		InternalResourceViewResolver internalRVS = new InternalResourceViewResolver();
		internalRVS.setPrefix("/WEB-INF/views/");
		internalRVS.setSuffix(".jsp");
		return internalRVS;
	}

}
