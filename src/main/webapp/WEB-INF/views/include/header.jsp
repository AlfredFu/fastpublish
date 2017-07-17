<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Activity - Lexis Red - GTO APAC</title>
		<link rel='shortcut icon' href='http://www.lexisnexis.com/images/LN_favicon.ico' />
		<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/stylesheets/jquery/jquery-ui-1.11.0.css" />
		<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/themes/gitmike/stylesheets/application.css" />
		
		<script src="http://wiki.lexiscn.com/javascripts/jquery-1.11.1-ui-1.11.0-ujs-3.1.3.js"></script>
		<script src="http://wiki.lexiscn.com/javascripts/application.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
	
	
	</head>

	<body class="theme-Gitmike project-lnred controller-activities action-index">
		<div id="wrapper">
			<div id="wrapper2">
				<div id="wrapper3">
					<div id="top-menu">
					    <div id="account">
					        <ul>
					        	<!-- <li><a class="my-account" href="/my/account">My account</a></li> -->
					        	<li> <a class="logout" href="javascript:return false;"><sec:authentication property="name"/></a></li>
					        	<c:choose>
								  <c:when test="${pageContext.request.userPrincipal.authenticated}">
								  	<a class="logout"  href="${pageContext.request.contextPath }/logout">Sign out</a>
								  </c:when>
								  <c:otherwise>
								  	<li><a class="logout"  href="${pageContext.request.contextPath }/logout">Sign in</a></li>
								  </c:otherwise>
								</c:choose>
					        	<sec:authorize access="isAuthenticated()">
					        		<li></li>
					        	</sec:authorize>
								
								<sec:authorize access="hasPermission(#domain,'read') or hasPermission(#domain,'write')">
									<!-- This content will only be visible to users who have read or write permission to the Object found as a request attribute named "domain". -->
								</sec:authorize>
								
								<sec:authorize url="/admin">
									<!-- This content will only be visible to users who are authorized to send requests to the "/admin" URL. -->
								</sec:authorize>
							</ul>
						</div>
					   <!--  <div id="loggedas">Logged in as <a class="user active" href="/users/37">fredfu</a></div> -->
					    <ul>
					    	<li><a class="home" href="http://www.lexisnexis.com.au/lexisred/">Home</a></li>
					    </ul>
    				</div>

					<div id="header">
					    <h1 style="background:url(http://staging2.lexisnexis.com.cn/29.jpg) no-repeat 0px 3px;background-size:40px 40px;">${product.name }</h1>
					
					    <div id="main-menu">
					        <ul>
					        	<li><a class="overview <c:if test='${ subtab eq "overview"}'>selected</c:if>" href="${pageContext.request.contextPath }/product/overview/${product.id }">Overview</a></li>
								<li><a class="activity <c:if test='${ subtab eq "activity"}'>selected</c:if>" href="${pageContext.request.contextPath }/product/activity/${product.id }">Activity</a></li>
								<!--  
								<li><a class="activity <c:if test='${ subtab eq "setting"}'>selected</c:if>" href="${pageContext.request.contextPath }/product/setting/${product.id }">Setting</a></li>
								-->
							</ul>
					    </div>
					</div>