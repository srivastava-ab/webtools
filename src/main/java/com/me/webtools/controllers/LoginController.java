package com.me.webtools.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.webtools.pojo.Login;
import com.me.webtools.pojo.Roles;
import com.me.webtools.pojo.User;
import com.me.webtools.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest req, HttpServletResponse res) {
		logger.info("in login");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());

		return mav;

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegisterpage(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mav = new ModelAndView("register");
		System.out.println(Roles.values());
		mav.addObject("enum1", Roles.values());
		mav.addObject("user", new User());
		return mav;

	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("user") User user)
			throws PersistenceException {
		
		req.getSession().setAttribute("loginUser", user);
		user.setImageName("Blank");
		
		try {
			userService.register(user);
		} catch (PersistenceException | SQLException ex) {
			System.out.println("error " + ex.getMessage());
			System.out.println("Check--->>> ex.getMessage().contains(ConstraintViolationException)"
					+ ex.getMessage().contains("ConstraintViolationException"));
			if (ex.getMessage().contains("ConstraintViolationException")) {


				return new ModelAndView("register", "exception",
						"Email id is already registered, please try different email");

			}
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("test", "bcdswe");
		req.getSession().setAttribute("Date", new Date());
		
		if(user.getUserRole().equalsIgnoreCase(Roles.Admin.name())){
			return new ModelAndView("adminhome", "firstname", user.getFirstname());
		}else if(user.getUserRole().equalsIgnoreCase(Roles.Employee.name())){
			return new ModelAndView("employeehome", "firstname", user.getFirstname());
		}
		
		
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("login") Login login) throws IOException {

		System.out.println("in logon process");
		ModelAndView mav = null;

		User user = userService.validateUser(login);

		if (user != null) {
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("firstname", user.getFirstname());
			req.getSession().setAttribute("Date", new Date());
			req.getSession().setAttribute("aboutMe", user.getDescription());
			
		
			if(user.getUserRole().equalsIgnoreCase(Roles.Admin.name())){
				mav = new ModelAndView("adminhome");
				mav.addObject("firstname", user.getFirstname());
				mav.addObject("Date", new Date());
				mav.addObject("desc", user.getDescription());
			}else if(user.getUserRole().equalsIgnoreCase(Roles.Employee.name())){
				mav = new ModelAndView("employeehome");
				mav.addObject("firstname", user.getFirstname());
				mav.addObject("Date", new Date());
				mav.addObject("desc", user.getDescription());
			}
			// upon login
			// loadBlankPic(req, user);

		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Invalid credentials!!!");
		}
		return mav;
	}

	@ExceptionHandler({ PersistenceException.class })
	public ModelAndView handleIOException(Exception ex) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		System.out.println("error: " + ex.getMessage());
		System.out.println(
				"Check--->>> ex.getMessage().contains(Duplicate entry)" + ex.getMessage().contains("Duplicate entry"));
		if (ex.getMessage().contains("Duplicate entry")) {
			model.addObject("exception", "Email id is already registered, please try different email");

		}

		return model;
	}

	
    @RequestMapping(value="/invalidate", method=RequestMethod.POST)
    public ModelAndView invalidate(HttpSession session, Model model) {
        session.invalidate();
        System.out.println("session invalidated");
        if(model.containsAttribute("user")) model.asMap().remove("user");


        return new ModelAndView("logout");
    }
}
