package com.rdvmedicaux.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientsController {
	
	@RequestMapping("/Patient")
	public String accueilPatient()
	{
		return "patients/accueilPatient";
	}
	
}
