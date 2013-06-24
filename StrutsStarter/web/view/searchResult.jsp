<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Super Bowl - 2012 Result</title>
</head>
<body>
	<s:form action="/game/getResult">
		<s:textfield name="team" id="team" label="Enter team" value="Ex: packers"></s:textfield>
		<s:submit />
	</s:form>
</body>
</html>