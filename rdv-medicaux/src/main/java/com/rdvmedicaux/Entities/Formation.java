package com.rdvmedicaux.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private double id;
	
	private String Etablissement;
	private String intituleDiplome;
		
}
