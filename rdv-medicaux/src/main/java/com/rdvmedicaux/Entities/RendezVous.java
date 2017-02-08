package com.rdvmedicaux.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RendezVous {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idRendezVous;
	@OneToOne
	private Disponibilitees heure;
	@OneToOne
	private Medecin medecin;
	@ManyToOne
	private Patient patient;

	@DateTimeFormat @NotEmpty
	private Date date;
	
	
	public Disponibilitees getHeure() {
		return heure;
	}
	public void setHeure(Disponibilitees heure) {
		this.heure = heure;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public double getIdRendezVous() {
		return idRendezVous;
	}
	public void setIdRendezVous(double idRendezVous) {
		this.idRendezVous = idRendezVous;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
