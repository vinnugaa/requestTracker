package com.tracker.model;


public class SiteEnhance {

	private String id;
	private String requestor;
	private String submittedDate;
	private String expectedDate;
	private String actualDate;
	private double hours;
	private int month;
	private int projectId;
	private String actualResource; // Actually its a List<Integer>
	private int meToolResource;
	private int actualStatus;
	private int meToolStatus;
	private int impactApplication;
	private String changeType;  // Actually its a List<Integer>
	private int bu;
	private String country;  // Actually its a List<Integer>
	private int worklog;
	private boolean urgent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
		public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public int getMonth() {
		return month;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}
	public String getActualDate() {
		return actualDate;
	}
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getMeToolResource() {
		return meToolResource;
	}
	public void setMeToolResource(int meToolResource) {
		this.meToolResource = meToolResource;
	}
	public int getActualStatus() {
		return actualStatus;
	}
	public void setActualStatus(int actualStatus) {
		this.actualStatus = actualStatus;
	}
	public int getMeToolStatus() {
		return meToolStatus;
	}
	public void setMeToolStatus(int meToolStatus) {
		this.meToolStatus = meToolStatus;
	}
	public int getImpactApplication() {
		return impactApplication;
	}
	public void setImpactApplication(int impactApplication) {
		this.impactApplication = impactApplication;
	}
	public int getBu() {
		return bu;
	}
	public void setBu(int bu) {
		this.bu = bu;
	}
	public int getWorklog() {
		return worklog;
	}
	public void setWorklog(int worklog) {
		this.worklog = worklog;
	}
	public boolean isUrgent() {
		return urgent;
	}
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	public String getActualResource() {
		return actualResource;
	}
	public void setActualResource(String actualResource) {
		this.actualResource = actualResource;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
