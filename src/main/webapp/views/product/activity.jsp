<%@ include file="../include/header.jsp" %>



<div id="main" class="">

<!-- 
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
  -->  
    

    <div id="content">
        
        <h2>
        	Activity
        	<c:if test="${sessionScope.username eq 'fredfu' }">
        	
        	<span style="float:right;">
        		<input type="submit" value="New Version" class="button-small"   onclick="location.href='${pageContext.request.contextPath }/version/new?pid=${product.id }';"/>
        		&nbsp;
        		<input type="submit" value="New Package" class="button-small" onclick="location.href='${pageContext.request.contextPath }/package/new?pid=${product.id }';"/>
        	</span>
        	</c:if>
        </h2>
<p class="subtitle">Here is the main activity for ${product.name}</p>

<div id="activity">

<c:forEach var="version" items="${product.versionList }">

<h3>
	<span>${version.name } <c:choose>
					<c:when test="${version.versionType eq 'DEV'}">
						Development
					</c:when> 
					<c:when test="${version.versionType eq 'PREVIEW'}">
						Preview
					</c:when> 
					<c:when test="${version.versionType eq 'OFFICIAL'}">
						Official
					</c:when> 
					<c:otherwise>
						${version.versionType}
					</c:otherwise>
				</c:choose> release version build ${version.build} is available</span>
	<span style="float:right;"><fmt:formatDate value="${version.createDate }" type="date"/> </span></h3>
<dl>
	
	
<c:forEach  var="pke" items="${version.packages }">
	
  <dt class="issue  ">
  	<a href="${pageContext.request.contextPath }/package/download/${pke.id}">${product.name} ${pke.osType} ${version.name }</a> 
  	<c:if test="${sessionScope.username eq 'fredfu' }">
  	<a style="color:red;" href="${pageContext.request.contextPath}/package/delete?id=${pke.id }&pid=${product.id}">Delete this package</a>
  	</c:if>
  </dt>
  <dd class="">
  	<span class="description">${pke.description }</span>
  </dd>
  <c:if test="${sessionScope.username eq 'fredfu' }">
  <dt>
  </dt>
  </c:if>
  </c:forEach>
</dl>
  	<a style="color:red;" href="${pageContext.request.contextPath}/version/delete?id=${version.id }&pid=${product.id}">Delete this version</a>
<br>
<br>
</c:forEach>





</div>



<div style="float:left;">
<a title="From 2016-09-30 to 2016-10-29" accesskey="p" href="http://staging2.lexisnexis.com.cn/lexisred/preview/index.html">« Previous</a>
</div>
<div style="float:right;">

</div>


        
        <div style="clear:both;"></div>
    </div>
</div>
<jsp:include page="../include/footer.jsp"></jsp:include>

