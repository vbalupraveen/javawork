<html>
<head>
<title>Fruit</title>
</head>
<body>
	<form action="/fav_fruit" method="post">
	<p>Select you favorite fruit.</p>
	<#list fruits as fruit>
	<p>
		<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
	</p>
	</#list>
	<input type="submit" value="Submit"/>
	</form> 
</body>
</html>