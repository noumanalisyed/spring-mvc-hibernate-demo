<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
	<center>
		<h2>Create New Publication</h2>
		<form:form method="POST" action= "saveStudent.html">
	   		<table>
			    <tr>
			        <td><form:label path="studentId">Student ID:</form:label></td>
			        <td><form:input path="studentId" value="${student.studentId}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Name :</form:label></td>
			        <td><form:input path="name" value="${student.name}"/></td>
			    </tr>
				<tr>
					<td><form:label path="description">Name :</form:label></td>
					<td><form:input path="description" value="${student.description}"/></td>
				</tr>
			    <tr>
			      <td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      </tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty students}">
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.studentId}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.description}"/></td>
				<td align="center"><a href="/editStudent.html?studentId=${student.studentId}">Edit</a> | <a href="/deleteStudent.html?studentId=${student.studentId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<h2><a href="addCourse.html">Add Course</a></h2>
<h2><a href="addRegistration.html">Add Registration</a></h2>
	</center>
	</body>
</html>
