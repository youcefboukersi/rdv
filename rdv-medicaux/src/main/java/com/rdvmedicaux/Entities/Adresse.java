package com.rdvmedicaux.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Adresse implements Serializable{

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAdresse;
	@NotEmpty
	private String rue,ville;
	private Integer numeroRue;
	@Enumerated
	private Willya willaya;
	private String commentaire; // lui laisser indiqué son adresse vu que nous on a pas de réelles adresses
	
	
	public double getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Long idAdresse) {
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
	public void setNumeroRue(Integer numeroRue) {
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
	

	public Adresse(String rue, String ville, Integer numeroRue, Willya willaya) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.numeroRue = numeroRue;
		this.willaya = willaya;
	}
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
