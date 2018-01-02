package com.webapp.webRpg;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.webRpg.memberService.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav = new ModelAndView();
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
	
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public String signIn(HttpServletRequest request) {
		String result = "";
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		logger.info("Sign In!");
		
		hashMap.put("userId", request.getParameter("userId"));
		hashMap.put("userPWD", request.getParameter("userPWD"));

		result = (String) ms.entrance(1, hashMap);
		
		return result;
	}
	
	@RequestMapping(value = "signUpPage", method = RequestMethod.GET)
	public String signUpPage() {
		logger.info("Sign Up Page!");
		
		return "signUp";
	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest request) {
		logger.info("Sign Up!");
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("userId", request.getParameter("userId"));
		hashMap.put("userPWD", request.getParameter("userPWD"));
		hashMap.put("userName", request.getParameter("userName"));
		
		mav = (ModelAndView) ms.entrance(0, hashMap);
		
		return mav;
	}
	
}
