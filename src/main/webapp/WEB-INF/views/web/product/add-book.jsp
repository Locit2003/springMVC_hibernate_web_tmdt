<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.center {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Spring MVC internationalization</h1>
	Language :
	<a href="?language=en">English</a>|
	<a href="?language=vi_VN">Viet Nam</a>|
	<a href="?language=fr_FR">France</a>
	<a href="?language=ja_JA">japan</a>
	<div class="center">
		<h2>
			goodbye :
			<spring:message code="Goodbye" />
		</h2>

		Current Locale : ${pageContext.response.locale}
		<form:form action="insert-book" modelAttribute="book" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td>bookId:</td>
					<td><form:input path="bookId" /> <form:errors path="bookId"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>bookName:</td>
					<td><form:input path="bookName" /> <form:errors
							path="bookName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>author:</td>
					<td><form:input path="author" /> <form:errors path="author"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>producer:</td>
					<td><form:input path="producer" /> <form:errors
							path="producer" cssClass="error" /></td>
				</tr>
				<tr>
					<td>createdAt:</td>
					<td><form:input path="createdAt" type="date" /> <form:errors
							path="createdAt" cssClass="error" /></td>
				</tr>
				<tr>
					<td>quantity Pages:</td>
					<td><form:input path="quantityPage" /> <form:errors
							path="quantityPage" cssClass="error" /></td>
				</tr>
				<tr>
					<td>price:</td>
					<td><form:input path="price" /> <form:errors path="price"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>image:</td>
					<td><form:input path="fileUpload" type="file" /> <form:errors
							path="fileUpload" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>