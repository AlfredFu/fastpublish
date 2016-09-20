<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width:600px;
	border:solid 1px;
}
.remove_link{
	color:red;
}
</style>

</head>
<body>
product list, <a href="${pageContext.request.contextPath }/product/new">添加新产品</a>
<table>
<thead>
<tr><td>ID</td><td>Name</td><td>Action</td></tr>
</thead>
<tbody>
<c:forEach var="product" items="${products }">
	<tr>
		<td>${product.id }</td>
		<td><a href="${pageContext.request.contextPath }/product/${product.id}">${product.name }</a></td>
		<td><a href="${pageContext.request.contextPath }/product/${product.id}/edit">编辑</a>|<a href="${pageContext.request.contextPath }/product/${product.id}/delete" class="remove_link">删除</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>