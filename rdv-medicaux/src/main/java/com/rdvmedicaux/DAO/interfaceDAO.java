package com.rdvmedicaux.DAO;

import java.util.Collection;

import com.rdvmedicaux.Entities.RendezVous;

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
