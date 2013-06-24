<%@page import="com.ulab.model.Simple"%>
<%@page import="com.ulab.dao.SimpleDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My App</title>
</head>
<body>
	<%
		/* 	String name = request.getParameter("name");
			Integer id = Integer.parseInt(request.getParameter("id"));
			Simple simple = new Simple();
			simple.setId(id);
			simple.setName(name); */
	%>
	<jsp:useBean id="sim" class="com.ulab.model.Simple" scope="request" />
	<jsp:setProperty property="id" name="sim" param="sid" />
	<jsp:setProperty property="name" name="sim" param="sname" />
	<jsp:useBean id="sdao" class="com.ulab.dao.SimpleDaoImpl"
		scope="request" />
	<%-- <jsp:setProperty property="simple" name="com.ulab.model.Simple" value="sim"/> --%>
	<%
		sdao.setSimple(sim);
	%>
	Data Successfully Entered.
	<br />
	<a href=http://localhost:8080/SimpleJspMvcApp/store.jsp>Click to
		enter another.</a>
		<jsp:include page="/copyright.jsp" />
</body>
</html>