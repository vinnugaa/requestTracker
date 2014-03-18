<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YOUR HOME</title>
</head>
<body>
<h1>YOUR HOMEPAGE HERE</h1>
<s:label value="%{userList}" />
<a href="/RequestTracker/jsp/home.jsp" >HOME</a><br/>
<a href="/RequestTracker/jsp/login.jsp" >LOGIN</a><br/>
<a href="/RequestTracker/jsp/add-user.jsp" >ADD-USER</a><br/>
<a href="/RequestTracker/jsp/update-user.jsp" >UPDATE-USER</a><br/>
<br/><br/><br/>
<s:form action="createusertable.action" method="post">
	<s:submit method="createUserTable" key="label.createusertable" align="center" />
</s:form>
<s:form action="removeusertable.action" method="post">
	<s:submit method="removeUserTable" key="label.removeusertable" align="center" />
</s:form>
<a href="allusers.action">All Users</a>
</body>
</html>