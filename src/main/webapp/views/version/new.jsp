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
<div>
	<form action="${pageContext.request.contextPath }/version/new?productId=${productId}" method="post">
		<input type="hidden" id="productId" value="${productId }"/>
		<input type="hidden" id="id" name="id" value="${version.id }"/>
		<label for="name">版本编号：</label><input type="text" id="name" name="name" value="${version.name}"/><span class="error">${ERR_name }</span>
		<br>
		<label for="versionType">版本类型</label>
		<select id="versionType" name="versionType">
			<optgroup>
				<option value="DEV">DEV</option>
				<option value="PREVIEW">PREVIEW</option>
			</optgroup>
		</select>
		${ERR_versionType}
		<br>
		<input id="sub_btn" type="submit" value="创建"/>
	</form>
</div>
</body>
</html>