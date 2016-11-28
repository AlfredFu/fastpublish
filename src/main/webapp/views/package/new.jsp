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
	<form action="${pageContext.request.contextPath }/package/new" method="post" enctype="multipart/form-data">
		<input type="hidden" id="versionId" name="versionId" value="${versionId }"/>
		<br>
		<label for="osType">操作系统：</label>
		<select name="osType">
			<option value="Android">Android</option>
			<option value="MacOS">Mac OS</option>
			<option value="WinStore">Windows 8.1/10</option>
			<option value="WPF">Windows 7</option>
		</select>
		<span class="error">${ERR_osType }</span>
		<br>
		
		<label for="build">Build:</label>
		<input type="text" name="build" id="build" /><span class="error">${ERR_build }</span>
		<br>
		<label for="ospackage">Package:</label><input id="ospackage" name="ospackage" type="file" />
		<br>
		<a href="javascript:history.back();">Cancel</a> &nbsp;&nbsp;<input id="sub_btn" type="submit" value="创建"/>
	</form>
</div>
</body>
</html>