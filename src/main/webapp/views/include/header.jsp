<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Activity - Lexis Red - GTO APAC</title>
		<meta name="description" content="Redmine" />
		<meta name="keywords" content="issue,bug,tracker" />
		<meta name="csrf-param" content="authenticity_token" />
		<meta name="csrf-token" content="5htoIAZLk9PEy2AW7kNIwpcxI+ODiKeE4rtSbvwZe8rZswCpQ1GEl5NjtaNs9iqBc7qGlnl0Y2Y1XZk2cYBakA==" />
		<link rel='shortcut icon' href='/favicon.ico' />
		<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/stylesheets/jquery/jquery-ui-1.11.0.css" />
		<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/themes/gitmike/stylesheets/application.css" />
		
		<script src="http://wiki.lexiscn.com/javascripts/jquery-1.11.1-ui-1.11.0-ujs-3.1.3.js"></script>
		<script src="http://wiki.lexiscn.com/javascripts/application.js"></script>
	
	
	</head>

	<body class="theme-Gitmike project-lnred controller-activities action-index">
		<div id="wrapper">
			<div id="wrapper2">
				<div id="wrapper3">
					<div id="top-menu">
					    <div id="account">
					        <ul>
					        	<!-- <li><a class="my-account" href="/my/account">My account</a></li> -->
					        	<c:if test="${empty sessionScope.username }">
									<li><a class="logout"  href="${pageContext.request.contextPath }/login">Sign in</a></li>
								</c:if>
								<c:if test="${!empty sessionScope.username }">
									<li><a class="logout"  href="${pageContext.request.contextPath }/logout">Sign out</a></li>
								</c:if>
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
					        	<li><a class="overview <c:if test='${ subtab eq "overview"}'>selected</c:if>" href="${pageContext.request.contextPath }/product/${product.id }/overview">Overview</a></li>
								<li><a class="activity <c:if test='${ subtab != "overview"}'>selected</c:if>" href="${pageContext.request.contextPath }/product/${product.id }/activity">Activity</a></li>
								
							</ul>
					    </div>
					</div>