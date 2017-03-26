package com.rdvmedicaux.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String Etablissement;
	private String intituleDiplome;
	
	public String getEtablissement() {
		return Etablissement;
	}
	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}
	public String getIntituleDiplome() {
		return intituleDiplome;
	}
	public void setIntituleDiplome(String intituleDiplome) {
		this.intituleDiplome = intituleDiplome;
	}
	public Long getId() {
		return id;
	}
	public Formation(String etablissement, String intituleDiplome) {
		super();
		Etablissement = etablissement;
		this.intituleDiplome = intituleDiplome;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
		
}
