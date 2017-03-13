package fr.pizzeria.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "numero_commande")
	private Integer numeroCommande;

	@Column(name = "statut", length = 10)
	private String statut;

	@Column(name = "date_commande", length = 50)
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Commande() {

	}

	public Commande(Integer numeroCommande, String statut, Date dateCommande, Livreur livreur, Client client) {
		super();
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.livreur = livreur;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
