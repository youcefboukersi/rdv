package com.rdvmedicaux.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

	
	@RequestMapping("/docteur")
	public String welcomeInternaute()  
	{
		return "docteurs/welcomePage";
	}
	
}
