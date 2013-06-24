<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balupraveen Vattem</title>
</head>
<body>

	<%@page import="java.util.Date"%>
	<%
		int major = application.getEffectiveMajorVersion();
		int minor = application.getMinorVersion();
		out.print("version:" + major + "-" + minor);
		out.print("<br/>");
		out.print("<br/>");
		out.print("Today's Date:" + new Date().getDate());
		out.print("<br/>");
	%>
	<%=major%>
	<%@page language="java"%>
	Forwarding to next.jsp...
	<%@include file="pagetwo.jsp" %>
	Back in index.jsp
	<%@page buffer="200kb"%>

</body>
</html>