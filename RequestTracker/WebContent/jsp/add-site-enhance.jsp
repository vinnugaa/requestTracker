<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Enhancement - Request Tracker</title>
</head>
<body>
<s:actionerror />
<s:form action="add-enhance" >
	<s:textfield name="id" key="label.id" size="20" />
	<s:textfield name="requester" key="label.requester" size="20" />
	<s:textfield name="submittedDate" key="label.submittedDate" size="20" /> <!-- Date picker JS -->
	<s:textfield name="expectedDate" key="label.expectedDate" size="20" /> <!-- Date picker JS -->
	<s:textfield name="actualDate" key="label.actualDate" size="20" /> <!-- Date picker JS -->
	<s:textfield name="hours" key="label.hours" size="20" />
	<s:textfield name="month" key="label.month" size="20" /> <!-- Month drop-down -->
	<s:textfield name="projectId" key="label.projectId" size="20" /> <!-- Drop-down -->
	<s:textfield name="actualResource" key="label.actualResource" size="20" /> <!-- Drop-down or Multiple option -->
	<s:textfield name="meToolResource" key="label.meToolResource" size="20" /> <!-- Drop-down -->
	<s:textfield name="actualStatus" key="label.actualStatus" size="20" />
	<s:textfield name="meToolStatus" key="label.meToolStatus" size="20" />
	<s:textfield name="impactApplication" key="label.impactApplication" size="20" />  <!-- Drop-down or Multiple option -->
	<s:textfield name="changeType" key="label.changeType" size="20" /> <!-- Drop-down or Multiple option -->
	<s:textfield name="bu" key="label.bu" size="20" />
	<s:textfield name="country" key="label.country" size="20" /> <!-- Drop-down or Multiple option -->
	<s:textfield name="worklog" key="label.worklog" size="20" />
	<s:textfield name="urgent" key="label.urgent" size="20" /> <!-- Drop-down -->
	<s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>