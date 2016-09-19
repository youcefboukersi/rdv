package com.youcefboukersi.rdvmedicaux;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

	
	@RequestMapping("/doctors/home")
	public String welcomeInternaute()  
	{
		return "doctors/welcomePage";
	}
	
}
