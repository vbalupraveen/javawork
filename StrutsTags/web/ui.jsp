<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UI Tag test</title>
</head>
<body>
	<h1>Please select options</h1>
	<s:form action="results" method="post">
		<s:radio label="Gender" name="gender" list="genderList" />
		<br />
		<s:checkbox label="Eligible to work in USA" name="work" />
		<br />
		<s:select list="{'Veteran','Disabled','Not applicable'}"
			label="Veteran Status" name="veteran" />
		<br />
		<s:select label="Field of Interest" labelposition="top" headerKey="-1"
			headerValue="-Select field-" list="fieldsList" name="field"
			multiple="true" size="8" />
		<br />
		<s:combobox label="Highest level of Education" name="education"
			list="#{'D':'Doctor','M':'Master','B':'Bachelor','C':'Certified','O':'Other'}"
			headerKey="-1" headerValue="-Select Education-" emptyOption="false"
			value="Ex: Master" />
		<s:submit />
		<s:reset />
	</s:form>
</body>
</html>