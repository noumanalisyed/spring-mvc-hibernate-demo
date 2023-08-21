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
		<h2>Create New Registration</h2>
		<form:form method="POST" action= "saveRegistration.html">
	   		<table>
			    <tr>
			        <td><form:label path="registrationId">Registration ID:</form:label></td>
			        <td><form:input path="registrationId" value="${registration.registrationId}" readonly="true"/></td>
			    </tr>
				<tr>
					<td>
						<form:label path="course.courseId">Course :</form:label>
					</td>
					<td>
						<form:select path="course.courseId" cssStyle="width: 150px;">
							<option value="-1">Select a Course</option>
							<c:forEach items="${courses}" var="course">
								<option value="${course.courseId}">${course.name}</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="student.studentId">Student :</form:label>
					</td>
					<td>
						<form:select path="student.studentId" cssStyle="width: 150px;">
							<option value="-1">Select a Student</option>
							<c:forEach items="${students}" var="student">
								<option value="${student.studentId}">${student.name}</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
			    <tr>
			      <td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      </tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty registrations}">
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Course</th>
			<th>Student</th>

			<th>Options</th>
		</tr>

		<c:forEach items="${registrations}" var="registration">
			<tr>
				<td><c:out value="${registration.registrationId}"/></td>
				<td><c:out value="${registration.course.name}"/></td>
				<td><c:out value="${registration.student.name}"/></td>
				<td align="center"><a href="/editRegistration.html?registration=${registration.registrationId}">Edit</a> | <a href="/deleteRegistration.html?registrationId=${registration.registrationId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<h2><a href="addCourse.html">Add Course</a></h2>
<h2><a href="addStudent.html">Add Student</a></h2>
</center>
	</body>
</html>
