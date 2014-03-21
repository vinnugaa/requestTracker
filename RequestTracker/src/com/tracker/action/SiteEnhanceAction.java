package com.tracker.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.SiteEnhance;
import com.tracker.utils.Utility;

public class SiteEnhanceAction {
	private String id;
	private Date submittedDate;
	private String requestor;
	private Date expectedDate;
	private Date actualDate;
	private float hours;
	private int month;
	private int projectId;
	private List<Integer> actualResource;
	private int meToolResource;
	private int actualStatus;
	private int meToolStatus;
	private int impactApplication;
	private List<Integer> changeType;
	private int bu;
	private List<Integer> country;
	private int worklog;
	private boolean urgent;

	DataResult<String> dataResult = null;

	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(SiteEnhance siteEnhance){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_SITE_ENHANCER, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(siteEnhance));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(SiteEnhance siteEnhance){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_SITE_ENHANCER, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(siteEnhance));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean update(SiteEnhance siteEnhance){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_SITE_ENHANCER, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(siteEnhance));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getEach(SiteEnhance siteEnhance){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_SITE_ENHANCER, AllConstants.SERVICE_METHOD_EACH, Utility.getInstance().toJson(siteEnhance));
		dataResult = bd.doTask();
		return dataResult.data;
	}
	public String getAll(){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_SITE_ENHANCER, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Date getActualDate() {
		return actualDate;
	}
	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public int getMonth() {
		return month;
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
	public List<Integer> getActualResource() {
		return actualResource;
	}
	public void setActualResource(List<Integer> actualResource) {
		this.actualResource = actualResource;
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
	public List<Integer> getChangeType() {
		return changeType;
	}
	public void setChangeType(List<Integer> changeType) {
		this.changeType = changeType;
	}
	public int getBu() {
		return bu;
	}
	public void setBu(int bu) {
		this.bu = bu;
	}
	public List<Integer> getCountry() {
		return country;
	}
	public void setCountry(List<Integer> country) {
		this.country = country;
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
}
