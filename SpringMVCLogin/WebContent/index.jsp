<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ULAB Project</title>
</head>
<h1>Welcome to My Assignment</h1>
<body>
	<form method="post" id="loginform" action="loginConfirm.jsp">
	<h3>Have account..! Please login</h3>
	<table class="computer">
			<tr>
				<td><label id="email">Email: </label><span>*</span>
					<input name="email" id="email" /><br /></td>
					<td><label id="passWord">Password: </label><span>*</span> <input
					type="password" name="passWord" id="passWord" /><br /></td>
					<td><input type="submit" value="Login" /> </td>
			</tr>
		</table>
		</form> 
		<h3>Sign up here to create login</h3>
		<form method="post" id="signupform" action="regConfirm.jsp">
		<table class="computer">
			<tr>
				<td><label id="fname">First Name: </label><span>*</span></td><td>
					<input name="fname" id="fname" /><br /></td>
			</tr>
			<tr>
				<td><label id="lname">Last Name: </label><span>*</span></td><td>
					<input name="lname" id="lname" /><br /></td>
			</tr>
			<tr><td><label id="email">Email: </label><span>*</span></td><td>
					<input name="email" id="email" /><br /></td></tr>
			<tr>
				<td><label id="passWord">Password: </label><span>*</span></td><td> <input
					type="password" name="passWord" id="passWord" /><br /></td>
			</tr>
			<tr>
				<td><label id="rePassWord">Confirm Password: </label><span>*</span></td><td>
					<input type="password" name="rePassWord" id="rePassWord" /><br /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm" /> 
				<td><input
					type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>	
	
	
	
	<pre>click <a href="/SpringMVCLogin/message">here</a> to print message.</pre>
</body>
</html>