<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>

<style type="text/css">
	.error{
		color:red;
		font-size: 15px;
	}
</style>
</head>
<body>
	<form:form modelAttribute="aNewAccount">
		
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" type="text" name="firstname" />
					<form:errors path="firstName" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" type="text" name="lastName" />
					<form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" type="text" name="age" />
					<form:errors path="age" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" type="text" name="address" />
					<form:errors path="address" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" type="text" name="email" />
					<form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="Submit" name="" /></td>
			</tr>		
		</table>
	</form:form>
	
</body>
</html>