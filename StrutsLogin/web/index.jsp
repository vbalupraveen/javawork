<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Language</title>
</head>
<body>
<h1>Please select your Language</h1>
	<s:url id="langEnglish" namespace="/" action="locale">
	<!-- param name must be "request_locale" -->
		<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url id="langSpanish" namespace="/" action="locale">
		<s:param name="request_locale">es</s:param>
	</s:url>
	<s:url id="langGerman" namespace="/" action="locale">
		<s:param name="request_locale">gr</s:param>
	</s:url>
	<s:a href="%{langEnglish}">English</s:a><br/><br/>
	<s:a href="%{langSpanish}">Spanish</s:a><br/><br/>
	<s:a href="%{langGerman}">German</s:a>
</body>
</html>