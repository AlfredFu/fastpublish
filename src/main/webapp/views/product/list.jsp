<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/common.css" />

</head>
<body>
product list, <a href="${pageContext.request.contextPath }/product/new">添加新产品</a>
<table>
	<thead class="table_header">
		<tr>
			<td>ID</td>
			<td>Logo</td>
			<td>Name</td>
			<td>Description</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products }" varStatus="status">
			<tr <c:if test="${status.index %2 != 0 }">class="bg_grey"</c:if>>
				<td style="width:40px;text-align:center;">${product.id }</td>
				<td style="width:80px;text-align:center;">
					<a href="${pageContext.request.contextPath }/product/${product.id}">
						<img class="product_list_icon" src="${pageContext.request.contextPath }/product/${product.id }.jpg"/>
					</a>
				</td>
				<td style="width:200px;"><a href="${pageContext.request.contextPath }/product/${product.id}">${product.name }</a></td>
				<td><a href="${pageContext.request.contextPath }/product/${product.id}">${product.description }</a></td>
				<td style="width:100px;text-align:center;"><a href="${pageContext.request.contextPath }/product/edit/${product.id}">编辑</a>|<a href="${pageContext.request.contextPath }/product/${product.id}/delete" class="remove_link">删除</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>