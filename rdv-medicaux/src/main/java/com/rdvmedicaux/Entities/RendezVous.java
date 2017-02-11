package com.rdvmedicaux.Entities;

import java.io.Serializable;
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
public class RendezVous implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idRendezVous;
	@OneToOne
	private Disponibilitees heureRDV;
	@OneToOne
	private Medecin medecin;
	@ManyToOne
	private Patient patient;

	
	public Disponibilitees getHeureRDV() {
		return heureRDV;
	}
	public void setHeureRDV(Disponibilitees heure) {
		this.heureRDV = heure;
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
	public RendezVous(Disponibilitees heureRDV, Medecin medecin, Patient patient) {
		super();
		this.heureRDV = heureRDV;
		this.medecin = medecin;
		this.patient = patient;
	}
	
	
}
