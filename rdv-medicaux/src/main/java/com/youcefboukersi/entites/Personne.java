package com.youcefboukersi.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeUtilisateur",
discriminatorType=DiscriminatorType.STRING,
length=10)
public abstract class Personne {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private double idPersonne;
	@Size(min=2,max=30)
	private String nom, prenom;
	@DateTimeFormat (pattern="JJ/MM/AAAA")
	private Date dateNaissance;
	private Adresse adresse;	
	private double telephone;
	@NotEmpty @Email
	private String email;
	@DateTimeFormat (pattern="JJ/MM/AAAA")
	private Date dateCreation;
	
	private Collection<RendezVous> listeRendezVous;

	public double getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(double idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getTelephone() {
		return telephone;
	}

	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collection<RendezVous> getListeRendezVous() {
		return listeRendezVous;
	}

	public void setListeRendezVous(Collection<RendezVous> listeRendezVous) {
		this.listeRendezVous = listeRendezVous;
	}
	
	
	
}
