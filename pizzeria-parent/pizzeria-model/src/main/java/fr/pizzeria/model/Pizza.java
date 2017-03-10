package fr.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import fr.pizzeria.exception.ModelRuntimeException;

/**
 * @author Quelqun
 *
 */
@Entity
public class Pizza {

	/**
	 * l'id de la pizza
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * le code de la pizza
	 */
	@Column(name = "code", length = 5, nullable = false, unique = true)
	@ToString
	private String code;
	/**
	 * le nom de la pizza
	 */
	@Column(name = "nom", length = 25)
	@ToString
	private String nom;
	/**
	 * le prix de la pizza
	 */
	@Column(name = "prix")
	@ToString
	private Double prix;
	/**
	 * la categorie de la pizza (viande, poisson ou sans viande)
	 */
	@Enumerated(EnumType.STRING)
	@ToString
	private CategoriePizza categorie;

	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;

	}

	public Pizza() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {

		StringBuilder temp = new StringBuilder("");
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {

				ToString annotationTrouve = champ.getAnnotation(ToString.class);

				if (annotationTrouve != null && !champ.getAnnotation(ToString.class).uppercase()) {

					temp.append(champ.get(this).toString() + " ");
				} else {
					temp.append(champ.get(this).toString().toUpperCase() + " ");
				}
			}

		}

		catch (IllegalArgumentException |

				IllegalAccessException e) {
			throw new ModelRuntimeException(e);

		}
		return temp.toString();
	}

	/**
	 * @return
	 * 
	 * 		Comme toString mais avec des ; entre les champs pour pouvoir
	 *         exporter en csv
	 */
	public String toCSV() {

		String temp = "";

		temp += id + ";" + code + ";" + nom + ";" + prix + ";" + categorie.getLibelle();

		return temp;
	}

	@Override
	public boolean equals(Object p) {
		if (p == null) {
			return false;
		}
		if (p == this) {
			return true;
		}
		if (p.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) p;
		return new EqualsBuilder().append(code, rhs.code).append(nom, rhs.nom).isEquals();
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37).append(code).append(nom).toHashCode();
	}

}
