package com.rdvmedicaux.DAO;

import java.util.Collection;

import com.rdvmedicaux.Entities.Disponibilitees;
import com.rdvmedicaux.Entities.Patient;
import com.rdvmedicaux.Entities.Personne;
import com.rdvmedicaux.Entities.RendezVous;
import com.rdvmedicaux.Entities.Statut;

public interface interfaceDAO {
	
	
	// Patient
	public boolean prendreRDV(double idDispoMedecin);
	public boolean annulerRDV(double idRDV);
	public boolean modifierRDV(RendezVous nouveauRDV);	
	
	
	
	
	// Docuteur
		// // base 
	public boolean modifierProfile(Personne medecin);
	public Collection<RendezVous> voirLesRDV();
	public boolean modifierStatut(Statut statut);
	public boolean estReserve(Disponibilitees dispo);
	public boolean estConfirme(Disponibilitees dispo);
	
	public Collection<RendezVous> listRDVConfirmes(double idDocteur);
	public Collection<RendezVous> listRDVReserve(double idDocteur);
	public Collection<RendezVous> listRDVParPatient(double idPatient, double idDocteur);
			
		// // Avancer
	public Collection<RendezVous> ListRDV(double idDocteur);
	
	
}
