<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<s:form action="/register" method="post">
		<s:label name="error" />
		<s:textfield name="userName" label="User Name" requiredLabel="true" />
		<s:password name="passWord" label="Password" requiredLabel="true" />
		<s:password name="rePassWord" label="Re-enter Password"
			requiredLabel="true" />
		<s:submit />
		<s:reset />
	</s:form>
</body>
</html>