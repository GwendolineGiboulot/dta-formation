package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * le nom de l'ingrédient
	 */
	@Column(name = "nom", length = 50)
	@ToString
	private String nom;
	/**
	 * la prix de l'ingrédient
	 */
	@Column(name = "prix")
	private Double prix;
	/**
	 * la quantité de l'ingrédient
	 */
	@Column(name = "quantite")
	private Integer quantite;

	public Ingredient() {
		// JPA est content
	}

	public Ingredient(String nom, Double prix, Integer quantite) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + "]";
	}

}
