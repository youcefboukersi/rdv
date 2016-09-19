package com.youcefboukersi.rdvmedicaux;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternauteController {
	
	
	@RequestMapping("/internaute/home")
	public String welcomeInternaute()  
	{
		return "internaute/welcomePage";
	}

}
