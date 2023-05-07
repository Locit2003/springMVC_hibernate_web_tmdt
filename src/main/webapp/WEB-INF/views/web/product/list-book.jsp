<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>BookId</td>
			<td>bookName</td>
			<td>author</td>
			<td>producer</td>
			<td>createdAt</td>
			<td>quantity Pages</td>
			<td>price</td>
			<td>image</td>
		</tr>
		<tr>
			<td>${book.bookId}</td>
			<td>${book.bookName}</td>
			<td>${book.author}</td>
			<td>${book.producer}</td>
			<td>${book.createdAt}</td>
			<td>${book.quantityPage}</td>
			<td>${book.price}</td>
			<td><img src="<c:url value="resources"/>/images/${book.image}"></td>
		</tr>
	</table>
</body>
</html>