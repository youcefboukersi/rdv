package com.youcefboukersi.entites;

import java.util.Collection;
import java.util.Timer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Docteurs")
public class Docteur {
	
	private Categorie categorie;
	private Collection<ModePaiement> modePaiement;
	private String commentaire; // parler de lui
	private HorairesTravail horairesTravail; // en fonction de ses horaires on elabore le calendrier des rendez-vous
	private Statut statut; // => si abscens implique une notification pour les patients qui
	// ont révervé 	
	
	
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection<ModePaiement> getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(Collection<ModePaiement> modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public HorairesTravail getHorairesTravail() {
		return horairesTravail;
	}

	public void setHorairesTravail(HorairesTravail horairesTravail) {
		this.horairesTravail = horairesTravail;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	
}
