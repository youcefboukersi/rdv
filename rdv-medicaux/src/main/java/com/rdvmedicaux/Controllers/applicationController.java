package com.rdvmedicaux.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class applicationController {

	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/connection")
	public String connection()
	{
		return "connection";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "logout";
	}
	
	
	
}
