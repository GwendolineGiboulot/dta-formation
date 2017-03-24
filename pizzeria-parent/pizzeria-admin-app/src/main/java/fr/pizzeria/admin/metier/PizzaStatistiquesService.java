package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.PizzaEvent;

public class PizzaStatistiquesService {

	@Inject
	private List<PizzaEvent> listEvent;

	public void ecouteMonEvent(@Observes PizzaEvent event) {
		listEvent.add(event);
	}

	public List<PizzaEvent> getListEvent() {
		return listEvent;
	}

}
