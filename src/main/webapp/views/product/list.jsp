<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
product list
<table>
<thead>
<tr><td>ID</td><td>Name</td></tr>
</thead>
<tbody>
<c:forEach var="product" items="${products }">
	<tr>
		<td>${product.id }</td>
		<td><a href="/product/${product.id}">${product.name }</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>