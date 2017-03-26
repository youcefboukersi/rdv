package testUnitaire;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rdvmedicaux.DAO.interfaceDAO;
import com.rdvmedicaux.Entities.Adresse;
import com.rdvmedicaux.Entities.Disponibilitees;
import com.rdvmedicaux.Entities.Formation;
import com.rdvmedicaux.Entities.Medecin;
import com.rdvmedicaux.Entities.ModePaiement;
import com.rdvmedicaux.Entities.Patient;
import com.rdvmedicaux.Entities.RendezVous;
import com.rdvmedicaux.Entities.Specialite;
import com.rdvmedicaux.Entities.Statut;
import com.rdvmedicaux.Entities.Willya;

import ApplicationConfig.JPaTransactionConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JPaTransactionConfig.class)
public class TestPersistence {

	@Inject
	interfaceDAO dao;

	@Test
	public void test() {
		boolean ok = false;
		Adresse add = new Adresse("Rue du midi", "Vincennes", 19, Willya.Alger);
		String email = "youcef.boukersi@yahoo.fr";
		Collection<Disponibilitees> dispos = new LinkedList<Disponibilitees>();
		dispos.add(new Disponibilitees());
		Collection<Formation> formations = new LinkedList<Formation>();
		formations.add(new Formation("Mouloud Mammerie", "medecin généraliste"));
		Medecin medecin = new Medecin("boukersi", "youcef", new Date(), add, 07, email, new Date(),
				Specialite.Generaliste, ModePaiement.carteBancaire, dispos, Statut.EnService, 4, formations);
		medecin.setUsername("youcef.boukersi@yahoo.fr");
		medecin.setPassword("youcef");

		if (ok) {

			dao.addAdress(add);
			for (Disponibilitees d : dispos)
				dao.addDispoinibilite(d);
			for (Formation f : formations)
				dao.addFormation(f);

			dao.addMedecin(medecin);
		}
		System.err.println("11111111111111");
		Collection<RendezVous> rdvs = new LinkedList<RendezVous>();
		rdvs.add(new RendezVous());
		Patient patient = new Patient();
		patient.setNom("patientNom");
		patient.setPrenom("prenomPatint");
		patient.setUsername("patient@gmail.com");
		patient.setPassword("patient");
		System.err.println("22222222222222222");
		dao.addPatient(patient);
	}

}
