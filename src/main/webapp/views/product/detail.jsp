<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product details</title>
</head>
<body>
	<p>ID:${product.id }</p>
	<p><img class="product_list_icon" src="${pageContext.request.contextPath }/product/${product.id }.jpg"/>产品名称：${product.name }</p>

</body>
</html>