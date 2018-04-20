package com.me.webtools.controllers;

import java.util.Locale;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.webtools.pojo.User;
import com.me.webtools.service.UserService;




@Controller
public class ProfileController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
	public String showProfile(Locale locale, Model model) {
	
		model.addAttribute("profileEditable", false);
		
		return "welcome";
		
		
	}	
		
	
	@RequestMapping(value = "/editProfile.htm", method = RequestMethod.GET)
	public String editProfile(Model model, @ModelAttribute("editUser") User user, BindingResult result) {
	
		model.addAttribute("profileEditable", true);
		
		return "welcome";
		
		
	}	
	
	
	@RequestMapping(value = "/editUser.htm", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, HttpServletRequest req, HttpServletResponse res, @ModelAttribute("user") User user, BindingResult result)
			throws PersistenceException {
		System.out.println("Hello");
		
		userService.updateUser(user);
		
		model.addAttribute("profileEditable", false);

		
		return new ModelAndView("welcome");
	}
}
