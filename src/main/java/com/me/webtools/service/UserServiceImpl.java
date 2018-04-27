package com.me.webtools.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.me.webtools.dao.UserDao;
import com.me.webtools.pojo.Job;
import com.me.webtools.pojo.Login;
import com.me.webtools.pojo.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	@Override
	public void register(User user) throws SQLException {
		userDao.register(user);
	}

	@Override
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	@Override
	public void updateDesc(User user) {
		userDao.updateDesc(user);
	}

	public void updateImage(User user) {
		userDao.updateImage(user);
	}

	@Override
	public User retrieveSearchUser(String email) {
		return userDao.retrieveSearchUser(email);
	}

	@Override
	public boolean updateUser(User user) {
		userDao.updateUser(user);
		return false;
	}
	
	@Override
	public boolean createJob(Job job) {
		userDao.createJob(job);
		return false;
	}

	@Override
	public List<Job> findjobsInCity(String cityName) {
		return userDao.findjobsInCity(cityName);
		
	}

	@Override
	public Job getJobByID(int jobID) {
		// TODO Auto-generated method stub
		return userDao.getJobByID(jobID);
	}

	@Override
	public boolean updateJob(String jobStatus, String userEmail, Date date,  String jobID) {
		// TODO Auto-generated method stub
		return userDao.updateJob(jobStatus, userEmail, date, jobID);
	}

	@Override
	public List<Job> myJobList(String email) {
		// TODO Auto-generated method stub
		return userDao.myJobList(email);
	}

	@Override
	public List<Job> myTaskCreatedList(String email) {
		// TODO Auto-generated method stub
		return userDao.myTaskCreatedList(email);
	}

	@Override
	public void updateJob2(Job job) {
		 userDao.updateJob2(job);
		
	}

	

	

}
