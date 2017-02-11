package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue(value="Docteurs")
public class Medecin extends Personne implements Serializable{
	
	@NotEmpty
	private Specialite specialite;
	@ElementCollection(targetClass=ModePaiement.class)
	@Enumerated
	private Collection<ModePaiement> modePaiement;
	private String commentaire; // parler de lui (description)
	@OneToMany
	private Collection<Disponibilitees> disponibilitees; // en fonction de ses horaires on élabore le calendrier des rendez-vous
	@Enumerated
	private Statut statut; // => si absence => notification des patients qui ont révervé 	 à ne pas oublier les listners
	private double anneeExperience;
	@OneToMany
	private Collection<Formation> formations;
	
	
	public Specialite getCategorie() {
		return specialite;
	}

	public void setCategorie(Specialite specialite) {
		this.specialite = specialite;
	}

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
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

	public Collection<Disponibilitees> getDisponibilitees() {
		return disponibilitees;
	}

	public void setDisponibilitees(Collection<Disponibilitees> disponibilitees) {
		this.disponibilitees = disponibilitees;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	
}
