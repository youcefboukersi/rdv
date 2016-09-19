package com.youcefboukersi.entites;

import javax.persistence.Entity;

@Entity
public class Adresse {

	private String rue;
	private double numeroRue;
	private String ville;
	private Willya willaya;
	private String commentaire; // comme chez nous y a pas d'adresse exacte alors le p s peut mentionner sa propre adresse, 
	
	
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
