package com.rdvmedicaux.DAO;

import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rdvmedicaux.Entities.Adresse;
import com.rdvmedicaux.Entities.Disponibilitees;
import com.rdvmedicaux.Entities.Formation;
import com.rdvmedicaux.Entities.Medecin;
import com.rdvmedicaux.Entities.Patient;
import com.rdvmedicaux.Entities.RendezVous;
import com.rdvmedicaux.Entities.Statut;
import com.rdvmedicaux.Entities.authorities;
import com.rdvmedicaux.Entities.users;

@Component
@Transactional
public class DaoImplements implements interfaceDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	PasswordEncoder passwordEncoder;
		
	public EntityManager getEm() {
		return em;
	}

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
	public boolean modifierProfile(users medecin) {
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
	public boolean addMedecin(Medecin medecin) {
		if(usernameExist(medecin.getUsername()))
			return false;
		else
		{
			medecin.setPassword(passwordEncoder.encode(medecin.getPassword()));
			authorities roleMedecin = new authorities();
			roleMedecin.setRole("ROLE_Medecin");
			roleMedecin.setUser(medecin);
			em.persist(roleMedecin);
			em.persist(medecin);
		}
		
		return false;
	}
	
	@Override
	public boolean addPatient(Patient patient) {
		
		if(usernameExist(patient.getUsername()))
			return false;
		else
		{
			
			patient.setPassword(passwordEncoder.encode(patient.getPassword()));
			authorities rolepPatient = new authorities();
			rolepPatient.setRole("ROLE_Patient");
			rolepPatient.setUser(patient);
			em.persist(rolepPatient);
			System.err.println("EmailExiste5555555555");
			em.persist(patient);
			System.err.println("PErsistence complete");
		}
		
		return false;
	}

	@Override
	public Adresse addAdress(Adresse adresse) {
		em.persist(adresse);
		return adresse;
	}
	
	
	@Override
	public boolean addDispoinibilite(Disponibilitees dispo) {
		em.persist(dispo);
		return true;
	}

	@Override
	public boolean addFormation(Formation form) {
		em.persist(form);
		return true;
	}
	
	public boolean usernameExist(String username)
	{
		Query q = em.createQuery("select u from users u");
		
		Collection<users> users = q.getResultList();
		for(users u : users)
		{
			if (u.getUsername().equals(username))
				return true;
		}
		
		return false;
	}	

}
