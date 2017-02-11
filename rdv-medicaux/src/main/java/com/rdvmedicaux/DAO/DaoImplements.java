package com.rdvmedicaux.DAO;

import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.rdvmedicaux.Entities.Disponibilitees;
import com.rdvmedicaux.Entities.Medecin;
import com.rdvmedicaux.Entities.Patient;
import com.rdvmedicaux.Entities.Personne;
import com.rdvmedicaux.Entities.RendezVous;
import com.rdvmedicaux.Entities.Statut;

public class DaoImplements implements interfaceDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean prendreRDV(double idDisponibilite, double idMedecin, double idPatient) {
		Medecin med = em.find(Medecin.class, idMedecin);
		Disponibilitees dispo = em.find(Disponibilitees.class, idDisponibilite);
		for (Disponibilitees d : med.getDisponibilitees()){
			if(d.equals(dispo))
				if (d.isEstReservee())
					return false;
				else {
					d.setEstReservee(true);
					Patient patient = em.find(Patient.class, idPatient);
					RendezVous rdv = new RendezVous(dispo, med, patient);
					patient.getRdvs().add(rdv);
				}
			break;
		}
		return true;
	}

	@Override
	public boolean annulerRDV(double idRDV) {
		RendezVous rdv = em.find(RendezVous.class, idRDV);
		rdv.getHeureRDV().setEstReservee(false);
		return true;
	}

	@Override
	public boolean modifierRDV(RendezVous nouveauRDV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierProfile(Personne medecin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<RendezVous> ListRDVMedecin(double idMedecin) {
		Collection<RendezVous> rdvMedecin = new TreeSet<RendezVous>();
		Medecin medecin = em.find(Medecin.class, idMedecin);
		Collection<RendezVous> rdv = ListRDV();
		for (RendezVous r : rdv)
		{
			if (r.getMedecin().equals(medecin))
				rdvMedecin.add(r);
		}
		return rdvMedecin;
	}

	@Override
	public boolean modifierStatut(Statut statut) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estReserve(Disponibilitees dispo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estConfirme(Disponibilitees dispo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<RendezVous> listRDVConfirmes(double idDocteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RendezVous> listRDVReserve(double idDocteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RendezVous> listRDVParPatient(double idPatient, double idDocteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<RendezVous> ListRDV() {
		Query q = em.createQuery("select rdv from RendezVous rdv");
		return q.getResultList();
	}

	@Override
	public Collection<RendezVous> voirLesRDV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medecin ajouterMedecin(Medecin medecin) {
		em.persist(medecin);
		return medecin;
	}

	

}
