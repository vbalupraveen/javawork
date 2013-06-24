<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My App</title>
</head>
<body>
	<form method="post" id="eleform1" action="success.jsp">
		<h1>Enter Item</h1>
		<table class="computer">

			<tr>
				<td><label id="sname">Name: </label><span>*</span> <input
					name="sname" id="sname" /><br /></td>
			</tr>
			<tr>
				<td><label id="sid">ID: </label><span>*</span> <input
					name="sid" id="sid" /><br /></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="Submit" /> <input
					type="reset" id="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="/copyright.jsp" />
</body>
</html>