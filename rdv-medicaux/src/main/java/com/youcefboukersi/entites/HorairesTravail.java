package com.youcefboukersi.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class HorairesTravail {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idHorairesTravail;
	private DateTimeFormat heureDebut;
	private DateTimeFormat heureFin;
	private double dureeConsultation;
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
