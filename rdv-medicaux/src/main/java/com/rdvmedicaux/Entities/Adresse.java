package com.rdvmedicaux.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adresse {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private double idAdresse;
	@NotEmpty
	private String rue,ville;
	private double numeroRue;
	private Willya willaya;
	private String commentaire; // lui laisser indiqué son adresse vu que nous on a pas de réelles adresses
	
	
	public double getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(double idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public double getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(double numeroRue) {
		this.numeroRue = numeroRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Willya getWillaya() {
		return willaya;
	}
	public void setWillaya(Willya willaya) {
		this.willaya = willaya;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	
	
}
