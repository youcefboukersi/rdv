package com.rdvmedicaux.Entities;

import java.util.Collection;
import java.util.Timer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue(value="Docteurs")
public class Medecin {
	
	@NotEmpty
	private Specialite specialite;
	@NotEmpty
	private Collection<ModePaiement> modePaiement;
	private String commentaire; // parler de lui (description)
	@OneToMany
	private Collection<Disponibilitees> disponibilitees; // en fonction de ses horaires on élabore le calendrier des rendez-vous
	private Statut statut; // => si absence => notification des patients qui ont révervé 	 à ne pas oublier les listners
	
	
	
	public Specialite getCategorie() {
		return specialite;
	}

	public void setCategorie(Specialite specialite) {
		this.specialite = specialite;
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

	public Collection<Disponibilitees> getHorairesTravail() {
		return disponibilitees;
	}

	public void setHorairesTravail(Collection<Disponibilitees> disponibilitees) {
		this.disponibilitees = disponibilitees;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	
}
