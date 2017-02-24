package fr.pizzeria.model;

public class Pizza {

	public int id;
	public String code;
	public String nom;
	public double prix;
	public static int nbPizzas;
	public CategoriePizza categorie;

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;

		nbPizzas++;

	}

	public String toString() {
		return this.code + " -> " + this.nom + " (" + this.prix + " €) " + categorie.getLibelle();

	}
}
