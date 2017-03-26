package com.rdvmedicaux.DAO;

import java.util.Collection;

import com.rdvmedicaux.Entities.Adresse;
import com.rdvmedicaux.Entities.Disponibilitees;
import com.rdvmedicaux.Entities.Formation;
import com.rdvmedicaux.Entities.Medecin;
import com.rdvmedicaux.Entities.Patient;
import com.rdvmedicaux.Entities.RendezVous;
import com.rdvmedicaux.Entities.Statut;
import com.rdvmedicaux.Entities.users;

public interface interfaceDAO {
	
	
	// Patient
	public boolean prendreRDV(double idDisponibilite, double idMedecin, double idPatient);
	public boolean annulerRDV(double idRDV);
	public boolean modifierRDV(RendezVous nouveauRDV);	
	
	// Docuteur
		// // base 
	public boolean modifierProfile(users medecin);
	public Collection<RendezVous> voirLesRDV();
	public boolean modifierStatut(Statut statut);
	public boolean estReserve(Disponibilitees dispo);
	public boolean estConfirme(Disponibilitees dispo);
	
	public Collection<RendezVous> listRDVConfirmes(double idDocteur);
	public Collection<RendezVous> listRDVReserve(double idDocteur);
	public Collection<RendezVous> listRDVParPatient(double idPatient, double idDocteur);
			
		// // Avancer
	public Collection<RendezVous> ListRDVMedecin(double idMedecin);
	public Collection<RendezVous> ListRDV();
	
	// Ajouter un Medecin
	public boolean addMedecin(Medecin medecin);
	public boolean addPatient(Patient patient);
	
	public Adresse addAdress(Adresse adresse);
	public boolean addDispoinibilite(Disponibilitees dispo);
	public boolean addFormation(Formation form);
	
	
}
