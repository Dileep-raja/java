<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Journey</title>
</head>
<body>
	<form action="add-journey" method="post">
		<p>New Journey Info</p>
		<table>
			<tr>
				<td>Source :</td>
				<td><input name="source"></td>
			</tr>
			<tr>
				<td>Destination :</td>
				<td><input name="destination"></td>
			</tr>
			<tr>
				<td>Journey Date :</td>
				<td><input type="date" name="journeyDate"></td>
			</tr>
			<tr>
				<td>Amount :</td>
				<td><input type="number" name="amount"></td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="Create"></td>
			</tr>
		</table>
	
	</form>
</body>
</html>