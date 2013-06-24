<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>USU</title>
<link href="ulabwebproject.css" rel="Stylesheet" media="screen"
	type="text/css" />
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<form method="post" id="eleform2" action="confirm.jsp">
		<h1>Student Registration</h1>
		<p>
			Hello
			<%=request.getParameter("uname")%>.Please complete the following
			fields.
		</p>
		<table class="computer">
			<tr>
				<td><label id="email">University Email: </label><span>*</span>
					<input name="email" id="email" /><br /></td>
			</tr>
			<tr>
				<td><label id="pwd">Password: </label><span>*</span> <input
					type="password" name="pwd" id="pwd" /><br /></td>
			</tr>
			<tr>
				<td><label id="repwd">Confirm Password: </label><span>*</span>
					<input type="password" name="repwd" id="repwd" /><br /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm" /> <input
					type="reset" value="Reset" /></td>
				<td><input type="button" value="Back" onclick="goBack()"></td>
			</tr>
		</table>
	</form>
	<%
		session.setAttribute("userName", request.getParameter("uname"));
	%>
	<%
		String sid = request.getParameter("sid");
		String lname = request.getParameter("lname");
		Cookie idCookie = new Cookie("sid", sid);
		Cookie lnameCookie = new Cookie("lname", lname);
		response.addCookie(idCookie);
		response.addCookie(lnameCookie);
	%>


</body>
</html>

