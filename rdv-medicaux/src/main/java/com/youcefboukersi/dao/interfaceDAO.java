package com.youcefboukersi.dao;

import java.util.Collection;

import com.youcefboukersi.entites.RendezVous;

public interface interfaceDAO {
	
	
	// internaute 
	public boolean prendreRDV(double idRDV);
	public boolean annulerRDV(double idRDV);
	public boolean modifierRDV(RendezVous nouveauRDV);
	
	
	//docuteur
		// // base 
	
	
		// // Avancer
	public Collection<RendezVous> ListRDV(double idDocteur);
	
	
}
