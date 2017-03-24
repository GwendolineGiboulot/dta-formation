package fr.pizzeria.admin.event;

import java.time.LocalDateTime;

public class PizzaEvent {
	private String code;
	private LocalDateTime heureCreation;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getHeureCreation() {
		return heureCreation;
	}

	public void setHeureCreation(LocalDateTime heureCreation) {
		this.heureCreation = heureCreation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
