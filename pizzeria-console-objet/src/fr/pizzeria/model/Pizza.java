package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {

	public int id;
	@ToString
	public String code;
	@ToString
	public String nom;
	@ToString
	public Double prix;

	public Double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int nbPizzas;
	@ToString
	public CategoriePizza categorie;

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;

		nbPizzas++;

	}

	public String toString() {

		String temp = "";
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {

				ToString annotationTrouve = champ.getAnnotation((ToString.class));

				if (annotationTrouve != null) {

					if (champ.getAnnotation((ToString.class)).uppercase() == false) {

						temp += champ.get(this).toString() + " ";
					} else {
						temp += champ.get(this).toString().toUpperCase() + " ";
					}
				}

			}
		}

		catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return temp;
	}

	public String toCSV() {

		String temp = "";

		temp += id + ";" + code + ";" + nom + ";" + prix + ";" + categorie.getLibelle();

		return temp;
	}

}
