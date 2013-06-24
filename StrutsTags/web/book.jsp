<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book</title>
</head>
<body>
	<s:bean name="com.ulab.st.model.Book" var="book">
		<s:param name="name"> Struts</s:param>
		<%-- 	not <s:param name="name" value= "Struts"/> --%>
		<s:param name="author">Apache</s:param>
	</s:bean>
	<s:push value="#book">
	Name:<s:property value="#book.name" />
		<br />
	Author:<s:property value="#book.author" />
	</s:push>
</html>