package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="Patients")
public class Patient extends Personne implements Serializable{

	@OneToMany
	private Collection<RendezVous> rdvs;
	
	
	
	public Collection<RendezVous> getRdvs() {
		return rdvs;
	}
	
	public void setRdvs(Collection<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}



	public Patient() {
		super();
	}	
	
}
