package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="Patients")
public class Patient extends users implements Serializable{

	@OneToMany
	private Collection<RendezVous> rdvs;
		
	public Collection<RendezVous> getRdvs() {
		return rdvs;
	}
	
	public void setRdvs(Collection<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}

	public Patient(String nom, String prenom, Date dateNaissance, Adresse adresse, double telephone, String email,
			Date dateCreation,
			Collection<RendezVous> rdvs) {
		super(nom, prenom, dateNaissance, adresse, telephone, email, dateCreation);
		this.rdvs = rdvs;
	}
	
	public Patient() {
		super();
	}
	
}
