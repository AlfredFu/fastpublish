<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product details</title>
<link rel="stylesheet" href="../css/common.css" />
<script src="../js/jquery-3.1.1.js"></script>
</head>
<body>
	<p>ID:${product.id }</p>
	<p><img class="product_list_icon" src="${pageContext.request.contextPath }/product/${product.id }.jpg"/>产品名称：${product.name }</p>

	<a href="${pageContext.request.contextPath }/version/new/?productId=${product.id}" class="new-button"></a>
	<div>
		<c:forEach  var="version" items="${product.versionList }">
			<div><h2>Version ${version.name }, ${version.versionType }</h2></div>
			<div>
				<table>
					<thead>
						<tr>
							<td>Build</td>
							<td>Upload Date</td>
							<td>External Testing Status</td>
						</tr>
					</thead>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>