<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload</title>
</head>
<body>
<h1>Upload your Resume here.</h1>
   <form action="upload/result" method="post" enctype="multipart/form-data">
      <label for="resume">Upload your file</label>
      <input type="file" name="resume" />
      <input type="submit" value="Upload"/>
   </form>
</body>
</html>