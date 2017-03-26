package com.rdvmedicaux.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeUtilisateur",
discriminatorType=DiscriminatorType.STRING,
length=10)
public abstract class users implements Serializable {
	
	@Id
	private String username;
	private String password;
	private Long enabled=1L;
	
	@Size(min=2,max=100)
	private String nom, prenom;
	@DateTimeFormat (pattern="JJ/MM/AAAA")
	private Date dateNaissance;
	private Adresse adresse;	
	//@NotEmpty @Size(min=10,max=10) @Pattern(regexp="(^$|[0-9]{10})")
	private double telephone;
	@Email
	private String email;
	@DateTimeFormat (pattern="JJ/MM/AAAA")
	private Date dateCreation;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getEnabled() {
		return enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getTelephone() {
		return telephone;
	}

	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	public users(String nom, String prenom, Date dateNaissance, Adresse adresse, double telephone, String email,
			Date dateCreation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.dateCreation = dateCreation;
	}
	
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
