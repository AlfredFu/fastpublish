<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0019)http://www.php.net/ -->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 

  <title>Lexis Red 3 Beta release</title>

 <link rel="shortcut icon" href="http://www.lexisnexis.com/images/LN_favicon.ico">


 <link rel="canonical" href="http://www.lexisnexis.com.au/lexisnexisred/">
 <link rel="shorturl" href="http://www.lexisnexis.com.au/lexisnexisred/">
 <link rel="alternate" href="http://www.lexisnexis.com.au/lexisnexisred/" hreflang="x-default">
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/detail.css" />

</head>
<body>


<body class="home ">

<nav id="head-nav" class="navbar navbar-fixed-top">
  <div class="navbar-inner clearfix">
    <a href="http://www.lexisnexis.com.au/lexisnexisred/" class="brand"><img src="http://www.lexisnexis.com/images/gateway/ln-logo.png" /></a>
  </div>
  <div id="flash-message"></div>
</nav>
<nav id="trick"><div><dl>
<dl>
<dt>Keyboard Shortcuts</dt><dt>?</dt>
<dd>This help</dd>
<dt>j</dt>
<dd>Next menu item</dd>
<dt>k</dt>
<dd>Previous menu item</dd>
<dt>g p</dt>
<dd>Previous man page</dd>
<dt>g n</dt>
<dd>Next man page</dd>
<dt>G</dt>
<dd>Scroll to bottom</dd>
<dt>g g</dt>
<dd>Scroll to top</dd>
<dt>g h</dt>
<dd>Goto homepage</dd>
<dt>g s</dt>
<dd>Goto search<br>(current page)</dd>
<dt>/</dt>
<dd>Focus search box</dd>
</dl></div></nav>
<div id="goto">
    <div class="search">
         <div class="text"></div>
         <div class="results"><ul></ul></div>
   </div>
</div>



<div id="intro" class="clearfix">
  <div class="container">
      <div class="row clearfix">
    <div class="blurb">
      <p>
      	<a target="blank" href="http://www.lexisnexis.com.au/lexisnexisred/">${product.name }</a> 
      	is a reliable, intelligent and convenient referencing tool providing you with access to your digital library via iPad, laptop or PC.
      	<a href="${pageContext.request.contextPath }/version/new/?productId=${product.id}" style="color:red">Create a verson</a>
      </p>
      
    </div>
    <div class="download">
      </div>
  </div>  
  </div>
</div>


<div id="layout" class="clearfix">
  <section id="layout-content">
<div class="home-content">


<c:if test="${!empty product.versionList }">
<c:forEach  var="version" items="${product.versionList }">
<article class="newsentry">
  <header class="title">
    <time datetime=""><fmt:formatDate value="${version.createDate }" type="date"/></time>
    <h2 class="newstitle">
      Lexis Red ${version.name } ${version.versionType } version is available
    </h2>
  </header>
  <div class="newscontent">
    <div>
     <p>The Lexis Red development team (GTO APAC team, located in Shanghai, China) announces the RC version of Lexis Red ${version.name }.
     </p>

     <p>Please access the link below to download the installation package for Lexis Red:
      <br/>
      <c:choose>
      	<c:when test="${empty version.packages }">
<%--       		<a href="${pageContext.request.contextPath }/package/new?vid=${version.id}">Upload package</a> | <a href="${pageContext.request.contextPath }/version/delete?id=${version.id}&pid=${version.productId}" style="color:red;">Delete this version</a>
 --%>      	</c:when>
      	<c:otherwise>
	      <c:forEach var="pke" items="${version.packages}">
	      	<a href="${pageContext.request.contextPath }/package/download/${pke.id}">Lexis Red ${pke.osType} ${version.name }</a>
	      	<a href="${pageContext.request.contextPath }/package/delete?id=${pke.id}&productId=${pke.productId}" style="color:red;">DEL</a>
	      	<br/>
	      </c:forEach>
	      <br>
      	</c:otherwise>
      
      </c:choose>
      
     iOS version can be installed via Testflight.
     <br>
     <a href="${pageContext.request.contextPath }/package/new?vid=${version.id}" >Upload package</a> | <a href="${pageContext.request.contextPath }/version/delete?id=${version.id}&pid=${version.productId}" style="color:red;">Delete this version</a>
	 
     </p>     
    </div>
  
  </div>
</article>
</c:forEach>
</c:if>

</div>    
</section><!-- layout-content -->
    
<aside class="tips">
    <div class="inner">
<div class="panel">  
</div>
</aside>

  </div><!-- layout -->
         
  <footer>
    <div class="container footer-content">
      <div class="row-fluid">
      <ul class="footmenu">
        <li><a href="http://www.lexisnexis.com.au/lexisnexisred/">© Copyright LexisNexis - 2014</a></li>
        <li><a href="http://www.lexisnexis.com.au/media/press-releases-au.aspx">Media</a></li>
        <li><a href="http://www.lexisnexis.com.au/en-au/about-us/contact-us/contact-us.page">Contact us</a></li>
        <li><a href="http://www.lexisnexis.com/opinionlab/Sitefeedback.aspx?url=http://www.lexisnexis.com.au/lexisnexisred/">Feedback</a></li>
        <li><a href="http://www.lexisnexis.com.au/en-au/terms.page">Privacy</a></li>
        <li><a href="http://www.lexisnexis.com.au/en-au/terms.page">Terms & Conditions</a></li>
      </ul>
      </div>
    </div>
  </footer>

    <div class="elephpants"><div class="images"></div></div>
 <!-- External and third party libraries. -->
 </body></html>