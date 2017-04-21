<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div id="activity">

<c:forEach var="version" items="${product.versionList }">
<c:if test="${subtab != 'overview' or (subtab == 'overview' && version.versionType eq 'OFFICIAL') }">

<div id="v${version.id }">
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
		
	  <dt class="issue  " id="pkedt_${pke.id }">
	  	<a href="${pageContext.request.contextPath }/package/download/${pke.id}">${product.name} ${pke.osType} ${version.name }</a> 
	  	<c:if test="${sessionScope.username eq 'fredfu' && subtab != 'overview'}">
	  	<a class="delpackage_link" style="color:red;" data-pid="${product.id}"  data-pkeid="${pke.id }" >Delete this package</a>
	  	</c:if>
	  </dt>
	  <dd id="pkedes_${pke.id }">
	  	<span class="description">${pke.description }</span>
	  </dd>
	 
	  </c:forEach>
	</dl>
	<c:if test="${sessionScope.username eq 'fredfu'  && subtab != 'overview'}">
		<a class="delversion_link" style="color:red;" href="" data-vid="${version.id }" data-pid="${product.id}">Delete this version</a>
	</c:if>
<br>
<br>
</div>
</c:if>
</c:forEach>

</div>
