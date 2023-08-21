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
		<form:form method="POST" action= "saveCourse.html">
	   		<table>
			    <tr>
			        <td><form:label path="courseId">Course ID:</form:label></td>
			        <td><form:input path="courseId" value="${course.courseId}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Course Name:</form:label></td>
			        <td><form:input path="name" value="${course.name}"/></td>
			    </tr>
				<tr>
					<td><form:label path="remarks">Remarks:</form:label></td>
					<td><form:input path="remarks" value="${course.remarks}"/></td>
				</tr>
			    <tr>
			      <td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      </tr>
			</table>
		</form:form>
		<br/>
  <c:if test="${!empty courses}">
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Remarks</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${courses}" var="course">
			<tr>
				<td><c:out value="${course.courseId}"/></td>
				<td><c:out value="${course.name}"/></td>
				<td><c:out value="${course.name}"/></td>
				<td align="center"><a href="/editCourse.html?courseId=${course.courseId}">Edit</a> | <a href="/deleteCourse.html?courseId=${course.courseId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<h2><a href="addStudent.html">Add Student</a></h2>
<h2><a href="addRegistration.html">Add Registration</a></h2>
</center>
	</body>
</html>
