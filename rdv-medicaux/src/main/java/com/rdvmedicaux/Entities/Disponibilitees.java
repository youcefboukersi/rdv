package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Disponibilitees implements Serializable{
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDispoinibilie;
	private String heureDebut,heureFin; 
	private Long dureeConsultation;
	@DateTimeFormat
	private Date date;
	private boolean estReservee;
	private boolean estConfirmee;
	
	
	public double getIdDispoinibilie() {
		return idDispoinibilie;
	}
	public void setIdDispoinibilie(Long idDispoinibilie) {
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
	
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public double getDureeConsultation() {
		return dureeConsultation;
	}
	public void setDureeConsultation(Long dureeConsultation) {
		this.dureeConsultation = dureeConsultation;
	}
	
	
	public Disponibilitees(String string, String string2, Long dureeConsultation, Date date, boolean estReservee,
			boolean estConfirmee) {
		super();
		this.heureDebut = string;
		this.heureFin = string2;
		this.dureeConsultation = dureeConsultation;
		this.date = date;
		this.estReservee = estReservee;
		this.estConfirmee = estConfirmee;
	}
	public Disponibilitees() {
		super();
	}
	
		
}
