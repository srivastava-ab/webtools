package com.me.webtools.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="job") 
public class Job {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobID",   nullable = false)
	private int jobID;
	
	@Column(name = "jobRaisedBy",   nullable = false)
	private String jobRaisedBy;
	
	@Column(name = "jobProcessedBy",   nullable = true)
	private String jobProcessedBy;
	
	@Column(name = "jobStatus",   nullable = false)
	private String jobStatus;
	
	@Column(name = "jobCity",   nullable = false)
	private String jobCity;
	
	@Column(name = "jobDetails",   nullable = false)
	private String jobDetails;
	
	@Column(name = "jobRaisedDate",   nullable = false)
	private Date jobRaisedDate;
	
	@Column(name = "jobProcessingStartDate",   nullable = true)
	private Date jobProcessingStartDate;
	
	@Column(name = "jobProcessingEndDate",   nullable = true)
	private Date jobProcessingEndDate;
	
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;  	
	}
	public String getJobRaisedBy() {
		return jobRaisedBy;
	}
	public void setJobRaisedBy(String jobRaisedBy) {
		this.jobRaisedBy = jobRaisedBy;
	}
	public String getJobProcessedBy() {
		return jobProcessedBy;
	}
	public void setJobProcessedBy(String jobProcessedBy) {
		this.jobProcessedBy = jobProcessedBy;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getJobCity() {
		return jobCity;
	}
	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	public Date getJobRaisedDate() {
		return jobRaisedDate;
	}
	public void setJobRaisedDate(Date jobRaisedDate) {
		this.jobRaisedDate = jobRaisedDate;
	}
	public Date getJobProcessingStartDate() {
		return jobProcessingStartDate;
	}
	public void setJobProcessingStartDate(Date jobProcessingStartDate) {
		this.jobProcessingStartDate = jobProcessingStartDate;
	}
	public Date getJobProcessingEndDate() {
		return jobProcessingEndDate;
	}
	public void setJobProcessingEndDate(Date jobProcessingEndDate) {
		this.jobProcessingEndDate = jobProcessingEndDate;
	}

}
