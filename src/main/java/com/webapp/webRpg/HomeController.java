package com.webapp.webRpg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		
		return "home.tiles";
	}
	
	@RequestMapping(value = "signInPage", method = RequestMethod.GET)
	public String signInPage() {
		logger.info("Sign In Page!");
		
		return "signIn";
	}
	
	@RequestMapping(value = "signIn", method = RequestMethod.GET)
	public String signIn() {
		logger.info("Sign In!");
		
		return "home.tiles";
	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String signUp() {
		logger.info("Sign Up!");
		
		return "signUp";
	}
	
}
