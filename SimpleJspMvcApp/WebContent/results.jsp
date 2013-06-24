<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<sql:setDataSource var="mydb" user="ulabdb" password="root"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		driver="oracle.jdbc.driver.OracleDriver" />
	<sql:query dataSource="${mydb}" sql="select * from simple where id=?"
		var="rs">
		<sql:param value="${id}" />
		<c:forEach var="row" items="${rs.row}">
			<c:out value="${row.id}" />
			<br />
			<c:out value="${row.name}" />
			<br />
		</c:forEach>
	</sql:query>

</body>
</html>