<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>GTO APAC</title>
<meta name="description" content="Redmine" />
<meta name="keywords" content="issue,bug,tracker" />
<meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="K150cAxw23V80nBSJ5Qn6OKzgISwyALpyYr1VYzjSp3enoCdsq/nZqDYhIfYZWn+rUzBSvJZ7iNBWQcyswEN6Q==" />
<link rel='shortcut icon' href='http://www.lexisnexis.com/images/LN_favicon.ico' />
<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/stylesheets/jquery/jquery-ui-1.11.0.css" />
<link rel="stylesheet" media="all" href="http://wiki.lexiscn.com/themes/gitmike/stylesheets/application.css" />

<script src="http://wiki.lexiscn.com/javascripts/jquery-1.11.1-ui-1.11.0-ujs-3.1.3.js"></script>
<script src="http://wiki.lexiscn.com/javascripts/application.js"></script>
<script>
//<![CDATA[
$(window).load(function(){ warnLeavingUnsaved('The current page contains unsaved text that will be lost if you leave this page.'); });
//]]>
</script>


<!-- page specific tags -->
</head>
<body class="theme-Gitmike controller-account action-login">
<div id="wrapper">
<div id="wrapper2">
<div id="wrapper3">
<div id="top-menu">
    <div id="account">
        <!-- <ul><li><a class="login" href="/login">Sign in</a></li>
<li><a class="register" href="/account/register">Register</a></li></ul>   -->  
</div>
    
    </div>

<div id="header">

    <h1>GTO APAC</h1>

    <div id="main-menu">
        
    </div>
</div>

<div id="main" class="nosidebar">
    <div id="sidebar">
        
        
    </div>

    <div id="content">
        
        
<div id="login-form">

<form action="<c:url value="/login"/>" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="authenticity_token" value="7G3dxGOgVjfG/HrMLecRPu+yic1PGOM3LBAg+O4p8GUZrSkp3X9qJBr2jhnSFl8ooE3IAw2JD/2kw9Kf0cu3EQ==" />
<input type="hidden" name="back_url" value="http://wiki.lexiscn.com/" />
<table>
<tr>
    <td style="text-align:right;"><label for="username">Login:</label></td>
    <td style="text-align:left;"><input type="text" name="username" id="username" tabindex="1" /></td>
</tr>
<tr>
    <td style="text-align:right;"><label for="password">Password:</label></td>
    <td style="text-align:left;"><input type="password" name="password" id="password" tabindex="2" /></td>
</tr>
<tr>
    <td></td>
    <td style="text-align:left;">
        <!-- <label for="autologin"><input type="checkbox" name="autologin" id="autologin" value="1" tabindex="4" /> Stay logged in</label> -->
    </td>
</tr>
<tr>
    <td style="text-align:left;">
           <!--  <a href="/account/lost_password">Lost password</a> -->
    </td>
    <td style="text-align:right;">
        <input type="submit" name="login" value="Login &#187;" tabindex="5"/>
    </td>
</tr>
</table>
</form></div>


<script>
//<![CDATA[
$('#username').focus();
//]]>
</script>

        
        <div style="clear:both;"></div>
    </div>
</div>
</div>

<div id="ajax-indicator" style="display:none;"><span>Loading...</span></div>
<div id="ajax-modal" style="display:none;"></div>

<div id="footer">
  <div class="bgl"><div class="bgr">
    Powered by <a href="http://www.redmine.org/">Redmine</a> &copy; 2006-2015 Jean-Philippe Lang
  </div></div>
</div>
</div>
</div>

</body>
</html>
