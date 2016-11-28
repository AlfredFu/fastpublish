<%@ include file="../include/header.jsp" %>

<body class="theme-Gitmike project-lnred controller-activities action-index">
<div id="wrapper">
<div id="wrapper2">
<div id="wrapper3">
<div id="top-menu">
    <div id="account">
        <ul><li><a class="my-account" href="/my/account">My account</a></li>
<li><a class="logout" rel="nofollow" data-method="post" href="/logout">Sign out</a></li></ul>    </div>
    <div id="loggedas">Logged in as <a class="user active" href="/users/37">fredfu</a></div>
    <ul><li><a class="home" href="/">Home</a></li>
    </ul></div>

<div id="header">
<%--     <div id="quick-search">  
    	<select name="project_quick_jump_box" id="project_quick_jump_box">
    		<option>${product.name }</option>
    	</select>
    </div> --%>

    <h1 style="background:url(${pageContext.request.contextPath }/product/${product.id}.jpg) no-repeat 0px 3px;background-size:40px 40px;">${product.name }</h1>

    <div id="main-menu">
        <ul><li><a class="overview" href="/projects/lnred">Overview</a></li>
<li><a class="activity selected" href="/projects/lnred/activity">Activity</a></li>
<li><a class="documents" href="/projects/lnred/documents">Documents</a></li>
</ul>
    </div>
</div>

<div id="main" class="">
    <div id="sidebar">
        <form action="/projects/lnred/activity" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
<h3>Activity </h3>
<ul>
  <li>
    <input type="checkbox" name="show_issues" id="show_issues" value="1" checked="checked" />
    <label for="show_issues">
      <a href="/projects/lnred/activity?show_issues=1">Development</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="show_changesets" id="show_changesets" value="1" checked="checked" />
    <label for="show_changesets">
      <a href="/projects/lnred/activity?show_changesets=1">Preview</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="show_news" id="show_news" value="1" checked="checked" />
    <label for="show_news">
      <a href="/projects/lnred/activity?show_news=1">UAT</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="show_documents" id="show_documents" value="1" checked="checked" />
    <label for="show_documents">
      <a href="/projects/lnred/activity?show_documents=1">RC</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="show_files" id="show_files" value="1" checked="checked" />
    <label for="show_files">
      <a href="/projects/lnred/activity?show_files=1">Official</a>
    </label>
  </li>

</ul>

<p><input type="submit" value="Apply" class="button-small" /></p>
</form>
       
    </div>

    <div id="content">
        
        <h2>
        	Activity
        	<span style="float:right;">
        		<input type="submit" value="New Version" class="button-small"   onclick="location.href='${pageContext.request.contextPath }/version/new?productId=${product.id }';"/>
        		&nbsp;
        		<input type="submit" value="New Package" class="button-small" onclick="location.href='${pageContext.request.contextPath }/package/new?productId=${product.id }';"/>
        	</span>
        </h2>
<p class="subtitle">From 2016-10-30 to 2016-11-28</p>

<div id="activity">

<c:forEach var="version" items="${product.versionList }">

<h3>
	<span>${version.name } ${version.versionType } version is available</span>
	<span style="float:right;"><fmt:formatDate value="${version.createDate }" type="date"/> </span></h3>
<dl>
	<c:forEach  var="pke" items="${version.packages }">
	
  <dt class="issue  ">
  	<a href="/issues/25382">${product.name} ${pke.osType} ${version.name }</a>
  </dt>
  <dd class="">
  	<span class="description">1. In annotation organizer, search a key word with no search resluts<br />2. Leave organizer screen (back to publication ...</span>
<!--   	<span class="author"><a class="user active" href="/users/338">Nikitta Shen</a></span>
 -->  
  </dd>
  </c:forEach>
<!--   <dt class="issue  ">
  
  <span class="time">14:16</span>
  <span class="project">Bug Warehouse</span>
  <a href="/issues/25379">Bug #25379 (New): Annotation is not orphaned when the highlighted content is removed.</a>
  </dt>
  <dd class=""><span class="description"></span>
  <span class="author"><a class="user active" href="/users/431">Richard Zhang</a></span></dd>
  <dt class="issue  ">
  
  <span class="time">11:36</span>
  <span class="project">Bug Warehouse</span>
  <a href="/issues/25371">Bug #25371 (New): Content in info modal will not be updated when the content has less or more but...</a>
  </dt>
  <dd class=""><span class="description"></span>
  <span class="author"><a class="user active" href="/users/431">Richard Zhang</a></span></dd> -->
</dl>

</c:forEach>





</div>



<div style="float:left;">
<a title="From 2016-09-30 to 2016-10-29" accesskey="p" href="http://staging2.lexisnexis.com.cn/lexisred/preview/index.html">« Previous</a>
</div>
<div style="float:right;">

</div>
<!-- &nbsp;
<p class="other-formats">Also available in:  <span><a class="atom" rel="nofollow" href="/projects/lnred/activity.atom?key=86845d2c8f39d4a6f2f7c971488007cbead82482">Atom</a></span>
</p>
 -->


        
        <div style="clear:both;"></div>
    </div>
</div>
</div>

<div id="ajax-indicator" style="display:none;"><span>Loading...</span></div>
<div id="ajax-modal" style="display:none;"></div>
<jsp:include page="../include/footer.jsp"></jsp:include>

