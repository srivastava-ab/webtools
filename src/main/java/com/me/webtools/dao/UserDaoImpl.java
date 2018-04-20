package com.me.webtools.dao;

//import org.mindrot.jbcrypt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.me.webtools.pojo.Job;
import com.me.webtools.pojo.Login;
import com.me.webtools.pojo.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	Session currentSession = HibernateUtil.getSessionFactory().openSession();

	public void register(User user) throws SQLException, PersistenceException {

		System.out.println("User: " + user.getEmail());
		System.out.println("pswd: " + user.getPassword());
		System.out.println("Inside insert");
		currentSession.beginTransaction();
		currentSession.save(user);
		currentSession.getTransaction().commit();

	}

	public void updateDesc(User user) {

		String sql = "UPDATE users set description = '" + user.getDescription() + "' where email='" + user.getEmail()
				+ "'";

		System.out.println("sql: " + sql);
		System.out.println("User: " + user.getEmail());
		System.out.println("desc: " + user.getDescription());

		// jdbcTemplate.update(sql);
	}

	public void updateImage(User user) {

		String sql = "UPDATE users set image = '" + user.getImageName() + "' where email='" + user.getEmail() + "'";

		System.out.println("sql: " + sql);
		System.out.println("User: " + user.getEmail());
		System.out.println("image: " + user.getImageName());

		// jdbcTemplate.update(sql);
	}

	/*
	 * public User validateUser(Login login) {
	 * 
	 * String sql = "Select * from users where email='"+
	 * login.getEmail()+"' and password ='"+login.getPassword()+"'"; List<User>
	 * userList = jdbcTemplate.query(sql, new UserMapper());
	 * 
	 * return userList.size()>0? (BCrypt.checkpw(login.getPassword(),
	 * userList.get(0).getPassword()))?userList.get(0):null:null;
	 * 
	 * }
	 */

	public User validateUser(Login login) {
		Query query = currentSession.createQuery("from User where email = :email  and password = :password");
		query.setParameter("email", login.getEmail());
		query.setParameter("password", login.getPassword());
		List<User> list = query.list();
		System.out.println("List-->" + list.size());
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public boolean Sanitize(String stringValue) {
		System.out.println(stringValue);
		if (null == stringValue) {
			return false;
		}

		String str = "^([a-zA-Z0-9 ]+)$";
		return stringValue.matches(str);

	}

	public boolean updateUser(User user) {

		Criteria cr = currentSession.createCriteria(User.class);
		cr.add(Restrictions.eq("email", user.getEmail()));
		List results = cr.list();

		User temp = (User) results.get(0);

		user.setPassword(temp.getPassword());
		if (null != user.getPhone()) {
			temp.setPhone(user.getPhone());
		}
		if (null != user.getCity()) {
			temp.setCity(user.getCity());
		}
		if (null != user.getDescription()) {
			temp.setDescription(user.getDescription());

		}
		if (null != user.getFirstname()) {
			temp.setFirstname(user.getFirstname());
		}
		
		if (null != user.getLastname()) {
			temp.setLastname(user.getLastname());
		}
		
		if (null != user.getUsername()) {
			temp.setUsername(user.getUsername());
		}

		System.out.println("Inside update");
		currentSession.beginTransaction();
		currentSession.update(temp);
		currentSession.getTransaction().commit();
		// HibernateUtil.shutdown();
		return true;

	}

	public boolean createJob(Job job) {

		// currentSession.merge(user);
		System.out.println("Job: " + job.getJobDetails());
		System.out.println("Inside job create");
		currentSession.beginTransaction();
		currentSession.save(job);
		currentSession.getTransaction().commit();
		return true;

	}

	public List<Job> findjobsInCity(String cityName) {

		System.out.println("Inside job create");

		System.out.println("City name: " + cityName);

		String hql = "FROM Job WHERE jobCity = :city";
		System.out.println("hql-->" + hql);
		Query query = currentSession.createQuery(hql);
		query.setParameter("city", cityName);
		List<Job> results = query.list();

		return results;

	}

	public Job getJobByID(int jobID) {
		System.out.println("Inside find job by id");

		System.out.println("Job ID: " + jobID);

		String hql = "FROM Job WHERE jobID = :jobid";
		System.out.println("hql-->" + hql);
		Query query = currentSession.createQuery(hql);
		query.setParameter("jobid", jobID);
		List<Job> results = query.list();

		return results.get(0);

	}

	/*
	 * @javax.transaction.Transactional
	 */
	@Override
	public boolean updateJob(String jobStatus, String userEmail, Date date, String jobID) {

		System.out.println("Inside update job ");

		System.out.println("Job ID: " + jobID);

		/*
		 * String hql1 = "FROM Job WHERE jobID = :jobid";
		 * System.out.println("hql-->" + hql1); Query query =
		 * currentSession.createQuery(hql1); query.setParameter("jobid",
		 * Integer.valueOf(jobID)); List<Job> results = query.list();
		 */

		Criteria cr = currentSession.createCriteria(Job.class);
		cr.add(Restrictions.eq("jobID", Integer.valueOf(jobID)));
		List results = cr.list();

		Job job = (Job) results.get(0);

		job.setJobStatus(jobStatus);
		job.setJobProcessedBy(userEmail);
		job.setJobProcessingStartDate(date);

		/*
		 * job1.setJobCity("asd"); job1.set
		 */

		currentSession.beginTransaction();
		currentSession.update(job);
		currentSession.getTransaction().commit();

		return true;
	}

	@Override
	public User retrieveSearchUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateJob(Job assignedJob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Job> myJobList(String email) {

		System.out.println("Inside find job list");

		System.out.println("Email is: " + email);

		String hql = "FROM Job WHERE jobProcessedBy = :email";
		System.out.println("hql-->" + hql);
		Query query = currentSession.createQuery(hql);
		query.setParameter("email", email);
		List<Job> results = query.list();

		return results;

	}

}
