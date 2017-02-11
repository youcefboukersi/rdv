package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Disponibilitees implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idDispoinibilie;
	@NotEmpty @DateTimeFormat
	private Date heureDebut,heureFin;
	@NotEmpty
	private double dureeConsultation;
	@NotEmpty @DateTimeFormat
	private Date date;
	@NotEmpty
	private boolean estReservee;
	private boolean estConfirmee;
	
	
	public double getIdDispoinibilie() {
		return idDispoinibilie;
	}
	public void setIdDispoinibilie(double idDispoinibilie) {
		this.idDispoinibilie = idDispoinibilie;
	}
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
	
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public double getDureeConsultation() {
		return dureeConsultation;
	}
	public void setDureeConsultation(double dureeConsultation) {
		this.dureeConsultation = dureeConsultation;
	}
	
	
	
	
	
}
