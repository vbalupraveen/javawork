<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulab TM</title>
</head>
<body>
<h1>The Result of your Input is...</h1>
<p><c:out value="${output}"></c:out></p>
<p>Plese Click <a href=http://192.168.0.13:8080/BasicMavenApp/index.htm>here</a> to compare again.</p>
</body>
</html>