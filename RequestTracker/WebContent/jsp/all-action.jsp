<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>All Actions in single zone - Request Tracker</title>
</head>
 
<body>
<h1>All the Actions mapping are located in struts.xml. Every time make sure you update the links here as well</h1> 
<h2>USER ACTION</h2>
<a href="${pageContext.request.contextPath}/Login">Login</a> <br/>
<a href="${pageContext.request.contextPath}/add-user">add user</a> <br/>
<a href="${pageContext.request.contextPath}/update-user">update user</a> <br/>
<a href="${pageContext.request.contextPath}/all-users">all users</a> <br/>
<a href="${pageContext.request.contextPath}/delete-users">delete users</a> <br/>

<h2>TABLE CREATION</h2>
<a href="${pageContext.request.contextPath}/all-tables">all-tables</a> <br/>
<a href="${pageContext.request.contextPath}/purge-table">purge-table</a> <br/>
<a href="${pageContext.request.contextPath}/purge-all-tables">purge-all-tables</a> <br/>
<a href="${pageContext.request.contextPath}/delete-table">delete-table</a> <br/>
<a href="${pageContext.request.contextPath}/delete-all-tables">delete-all-tables</a> <br/>
<a href="${pageContext.request.contextPath}/create-table">create-table</a> <br/>
<a href="${pageContext.request.contextPath}/create-all-tables">create-all-tables</a> <br/>



<a href="${pageContext.request.contextPath}/adduser">Login</a> <br/>

<s:actionerror />
<s:form action="login.action" method="post">
    <s:textfield name="userid" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>