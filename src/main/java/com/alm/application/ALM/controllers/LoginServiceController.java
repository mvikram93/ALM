package com.alm.application.ALM.controllers;

import java.io.IOException;

import javax.swing.text.View;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alm.application.ALM.services.LoginService;

@Controller
public class LoginServiceController {
	LoginService service;
	//ModelAndView mav = new ModelAndView("userCenter/loginPage");
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String showLoginPage(ModelMap model) throws IOException{
		System.out.println("ghello");
		//service.UrlOpenConnect();
		service.showPostmethod();
		return "login";
		
	}
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password) {
		boolean isValidUser = service.validateUser(name,password);
		if(!isValidUser) {
			model.put("Error Message","Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
		
	}*/

	
}
