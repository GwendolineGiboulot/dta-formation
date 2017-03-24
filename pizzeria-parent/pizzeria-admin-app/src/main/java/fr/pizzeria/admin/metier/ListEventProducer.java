package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.admin.event.PizzaEvent;

public class ListEventProducer {

	@Produces
	@ApplicationScoped
	public List<PizzaEvent> buildListEvent() {
		return new ArrayList<PizzaEvent>();
	}

}
