<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
textarea{
	margin-top:10px;
}
#sub_btn{
	margin-top:10px;
	margin-left:100px;
	padding:5 10 5 10;
}
.error{
	margin-left:10px;
	color:red;
	font-size:10px;
}
</style>
</head>
<body>
<div>
	<form action="${pageContext.request.contextPath }/product/new" method="post" enctype="multipart/form-data">
		<input type="hidden" id="id" name="id" value="${product.id }"/>
		<label for="name">产品名称：</label><input type="text" id="name" name="name" value="${product.name}"/><span class="error">${ERR_name }</span>
		<br>
		<label for="description">产品描述：</label><textarea id="description" rows="30" cols="60" name="description" >${product.description }</textarea><span class="error">${ERR_description }</span>
		<br>
		<label for="image">产品Logo:</label><input id="image" name="image" type="file" />
		
		<input id="sub_btn" type="submit" value="创建"/>
	</form>
</div>
</body>
</html>