package com.rdvmedicaux.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Disponibilitees {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idHorairesTravail;
	@NotEmpty
	private DateTimeFormat heureDebut,heureFin;
	@NotEmpty
	private double dureeConsultation;
	@NotEmpty @DateTimeFormat
	private Date date;
	@NotEmpty
	private boolean estReservee,estConfirmee;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isEstReservee() {
		return estReservee;
	}
	public void setEstReservee(boolean estReservee) {
		this.estReservee = estReservee;
	}
	public boolean isEstConfirmee() {
		return estConfirmee;
	}
	public void setEstConfirmee(boolean estConfirmee) {
		this.estConfirmee = estConfirmee;
	}
	public double getIdHorairesTravail() {
		return idHorairesTravail;
	}
	public void setIdHorairesTravail(double idHorairesTravail) {
		this.idHorairesTravail = idHorairesTravail;
	}
	public DateTimeFormat getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(DateTimeFormat heureDebut) {
		this.heureDebut = heureDebut;
	}
	public DateTimeFormat getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(DateTimeFormat heureFin) {
		this.heureFin = heureFin;
	}
	public double getDureeConsultation() {
		return dureeConsultation;
	}
	public void setDureeConsultation(double dureeConsultation) {
		this.dureeConsultation = dureeConsultation;
	}
	
	
	
	
	
}
