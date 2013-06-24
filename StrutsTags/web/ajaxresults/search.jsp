<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulab Search</title>
</head>
<body>
	<s:form action="ajaxResult" method="post">
		<h1 align="center">Ulab</h1>
		<sx:autocompleter list="webframeworks" name="yourFavWebFramework"
			autoComplete="false" />
		<br />
		<sx:datetimepicker name="deliverydate" label="Delivery Date"
			displayFormat="dd/MM/yyyy" />
		<br />
		<sx:tabbedpanel id="tabContainer">
			<sx:div label="Tab 1">Tab 1</sx:div>
			<sx:div label="Tab 2">Tab 2</sx:div>
		</sx:tabbedpanel>
	</s:form>
</body>
</html>