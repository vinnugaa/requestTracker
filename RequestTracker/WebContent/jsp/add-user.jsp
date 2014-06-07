<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>ADD USER - Request Tracker</title>
</head>
 
<body>
<h2>ADD USER</h2>
<s:actionerror />
<s:form action="add-user" method="post">
    <s:textfield name="name" key="label.name" size="20" />
    <s:textfield name="password" key="label.password" size="20" />
    <s:textfield name="role" key="label.role" size="20" />
    <s:textfield name="userid" key="label.userid" size="20" />
    <s:submit method="add" key="label.login" align="center" />
</s:form>
</body>
</html>