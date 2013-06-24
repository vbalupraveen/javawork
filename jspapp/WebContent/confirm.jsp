<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>USU</title>
<link href="ulabwebproject.css" rel="Stylesheet" media="screen"
	type="text/css" />
<script type="text/javascript">
	function close() {
		window.close();
	}
</script>
</head>
<body>
	<%
		Cookie cookie[] = request.getCookies();
		String sid = null;
		String lname = null;
		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				Cookie c = cookie[i];
				if (c.getName().equals("sid"))
					sid = c.getValue();
				if (c.getName().equals("lname"))
					lname = c.getValue();
			}
		} else
			out.print("Some error occured. Enable Cookies and try again.");
	%>
	<h1>Student Registration</h1>
	<p><%=session.getAttribute("userName").toString()%>... You have Registered successfully.</p> 
	<table class="computer">
		<tr>
			<td><label>Student ID: </label> <%=sid%><br /></td>
		</tr>
		<tr>
			<td><label>Last Name: </label> <%=lname%><br /></td>
		</tr>
		<tr>
			<td><label>Email: </label> <%=request.getParameter("email")%><br /></td>
		</tr>
		<tr>
			<td><input type="button" value="Close" onclick="close()"></td>
		</tr>
	</table>
</body>
</html>

