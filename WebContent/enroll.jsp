<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Insurance Policy Enrollment</h1></center>
	<center>
		<form action="enrollMemberPlan" method="post">
			Name: <input name="name" placeholder="Enter Your Name"/><br/>
			Date Of Birth: <input type="date" name="dob" placeholder="Enter Date-Of-Birth"/><br/>
			Gender: <input type="radio" name="gender"/> Male &nbsp;&nbsp;<input type="radio" name="gender"/> Female<br/>
			<hr/>
			Plan: <select name="plan">
						<option value="Jeewan Sulabh">Jeewan Sulabh</option>
						<option value="Jeewan Sugam">Jeewan Sugam</option>
						<option value="Arogya bhava">Arogya bhava</option>
				  </select>
			Tenure: <input type="number" name="tenure"/> 
			<input type="submit" value="Enroll"/>
		</form>
	</center>
</body>
</html>