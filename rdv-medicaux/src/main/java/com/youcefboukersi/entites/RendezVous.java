package com.youcefboukersi.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RendezVous {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private double idRendezVous;
	@DateTimeFormat
	private Date date;
	
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
