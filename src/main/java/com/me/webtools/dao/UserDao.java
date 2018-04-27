package com.me.webtools.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.me.webtools.pojo.Job;
import com.me.webtools.pojo.Login;
import com.me.webtools.pojo.User;

public interface UserDao {

	void register(User user) throws SQLException;

	User validateUser(Login login);

	User retrieveSearchUser(String email);

	void updateDesc(User user);

	void updateImage(User user);

	boolean updateUser(User user);

	boolean createJob(Job job);

	List<Job> findjobsInCity(String cityName);

	Job getJobByID(int jobID);

	boolean updateJob(Job assignedJob);

	boolean updateJob(String jobStatus, String userEmail, Date date, String jobID);

	List<Job> myJobList(String email);

	List<Job> myTaskCreatedList(String email);

	void updateJob2(Job job);

}
