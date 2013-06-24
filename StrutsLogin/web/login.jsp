<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form in Multiple Languages</title>
</head>
<body>
	<h1>
		<!-- tag to get values from properties file. -->
		<s:text name="global.heading" />
	</h1>
	<s:form action="/login" method="post">
		<%-- <s:textfield key="user.userName" label="User Name" /> 
		can be written as below statement
		--%>
		<s:textfield key="global.userName" name="user.userName" />
		<s:password key="global.passWord" name="user.passWord" />
		<s:submit name="submit" key="global.submit" />
		<s:reset />
	</s:form>
</body>
</html>