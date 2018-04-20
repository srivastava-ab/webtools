package com.me.webtools.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.me.webtools.pojo.Job;
import com.me.webtools.pojo.JobStatus;
import com.me.webtools.pojo.User;
import com.me.webtools.service.UserService;

@Controller
public class JobController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);

	
	@RequestMapping(value = "/request.htm", method = RequestMethod.GET)
	public String showJobPage(Locale locale, Model model, @ModelAttribute("job") Job job, BindingResult result) {
	
		//model.addAttribute("profileEditable", false);
		
		return "jobpage";
		
		
	}
	
	@RequestMapping(value = "/jobSubmit.htm", method = RequestMethod.POST)
	public String submitJob(HttpSession session, HttpServletRequest req, HttpServletResponse res, @ModelAttribute("job") Job job, BindingResult result)
			throws PersistenceException {
		System.out.println("Hello Job");
		
		User user = (User) session.getAttribute("user");
		req.getParameter("user");
		
		job.setJobRaisedBy(user.getEmail());
		job.setJobRaisedDate(new Date());
		job.setJobStatus(JobStatus.NEW.name());
		
		userService.createJob(job);
		return "jobpage";

	}
	
	
	@RequestMapping(value = "/findJob.htm", method = RequestMethod.GET)
	public ModelAndView findJobInSameCity(HttpSession session)
			throws PersistenceException {
		System.out.println("Hello find job in same city");
		
		User user = (User) session.getAttribute("user");
		
		List<Job> jobListByCity = userService.findjobsInCity(user.getCity());
		
/*		System.out.println("City list size:: "+jobListByCity.size());
*/		session.setAttribute("jobList", jobListByCity);
		session.setAttribute("jobCity", user.getCity());

		return new ModelAndView("joblist");
	}
	
	
	
	@RequestMapping(value = "/assignJobToMe.htm", method = RequestMethod.GET)
	public String assignJob(HttpSession session,HttpServletRequest req, HttpServletResponse res, @ModelAttribute("job") Job job,  BindingResult result)
			throws PersistenceException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
				
		User user = (User) session.getAttribute("user");
		String jobID = req.getParameter("jobID");
		
		Job assignedJob = userService.getJobByID(Integer.valueOf(jobID));
		
		assignedJob.setJobStatus(JobStatus.ASSIGN.name());
		assignedJob.setJobProcessedBy(user.getEmail());
		assignedJob.setJobProcessingStartDate(new Date());
		
		userService.updateJob(JobStatus.ASSIGN.name(), user.getEmail(), new Date(), jobID);

		return null;
		
	}
	
	
	@RequestMapping(value = "/myJob.htm", method = RequestMethod.GET)
	public ModelAndView myJobs(HttpSession session, @ModelAttribute("job") Job job, BindingResult result)
			throws PersistenceException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
				
		User user = (User) session.getAttribute("user");
		String email = user.getEmail();
		List<Job> myJobList = userService.myJobList(email);
		session.setAttribute("myjobList", myJobList);
		session.setAttribute("jobCity", user.getFirstname());
		
		return new ModelAndView("myjoblist");
	
	}
	
	
	@RequestMapping(value = "/sendEmail.htm", method = RequestMethod.GET)
	public String sendEmail(HttpSession session,HttpServletRequest req)
			throws PersistenceException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
				
		/*User user = (User) session.getAttribute("user");
		String jobID = req.getParameter("jobID");
		
		Job assignedJob = userService.getJobByID(Integer.valueOf(jobID));
		
		assignedJob.setJobStatus(JobStatus.ASSIGN.name());
		assignedJob.setJobProcessedBy(user.getEmail());
		assignedJob.setJobProcessingStartDate(new Date());
		
		userService.updateJob(JobStatus.ASSIGN.name(), user.getEmail(), new Date(), jobID);*/
		
		EmailUtil email = new EmailUtil();
		email.email();
		

		return null;
		
	}
	
	
	
}
