<%@ include file="../include/header.jsp" %>

<div id="main" class="nosidebar">
    <div id="sidebar">
        
        
    </div>

    <div id="content">
        
        <h2>New Package</h2>



<form id="issue-form" class="new_issue" action="${pageContext.request.contextPath }/package/new" method="post" enctype="multipart/form-data">  
  <div class="box tabular">
    <div id="all_attributes">
    

<p>
	<label for="osType">OS:</label>
	<select name="osType">
			<option value="Android">Android</option>
			<option value="MacOS">Mac OS</option>
			<option value="WinStore">Windows 8.1/10</option>
			<option value="WPF">Windows 7</option>
	</select>
	<span class="error">${ERR_osType }</span>
</p>


<p>
	<label for="version">Version:</label>
	<select name="versionId">
		<c:forEach var="version" items="${versions }">
			<option value="${version.id }">
				${version.name} 
				<c:choose>
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
				</c:choose>
				&nbsp; build ${version.build }
			</option>
		</c:forEach>
	</select>
	<span class="error">${ERR_versionId }</span>
</p>


<%-- <p>
		<label for="build">Build:</label>
		<input type="text" name="build" id="build" /><span class="error">${ERR_build }</span>
</p> --%>


    </div>
<p>
	<label for="description">What's new:</label>
	<textarea id="description" name="description" rows="20" cols="60"></textarea>
	
</p>


<p id="attachments_form">
	<label for="ospackage">Package:</label><input id="ospackage" name="ospackage" type="file" />

</p>

      
  </div>

	<a href="javascript:history.back();">Cancel</a> &nbsp;&nbsp;
  <input type="submit" name="commit" value="Create" />
</form>
<div id="preview" class="wiki"></div>


        
        <div style="clear:both;"></div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
