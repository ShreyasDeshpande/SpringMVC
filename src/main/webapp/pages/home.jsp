<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  I love Java!
	</br> Welcome ${ name }
	<br /> Welcome Alien- ${ alienObj.aid },${ alienObj.aname },${ alienObj.tech }  -->

	<form action="addAlien">
		<input type="text" name="aid"> <br>
		<input type="text" name="aname"> <br>
		<input type="text" name="tech"> <br>
		<input type="submit"> <br>
	</form>
	<br>
	<form action="getAlien">
		<input type="text" name="aid"> <br>		
		<input type="submit"> <br>
	</form>
	
</body>
</html>