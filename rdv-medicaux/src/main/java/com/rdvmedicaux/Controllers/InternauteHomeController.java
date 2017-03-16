package com.rdvmedicaux.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternauteHomeController {
	
	
	@RequestMapping("/")
	public String welcomeInternaute()  
	{
		return "internaute/welcomePage";
	}

}
