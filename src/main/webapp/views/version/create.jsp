<%@ include file="../include/header.jsp" %>

<div id="main" class="nosidebar">
    <div id="sidebar">
        
        
    </div>

    <div id="content">
        
        <h2>New Version</h2>



<form id="issue-form" class="new_issue" action="${pageContext.request.contextPath }/version/new?pid=${pid}" method="post" >  
	<input type="hidden" id="productId" value="${pid }"/>
	<input type="hidden" id="id" name="id" value="${version.id }"/>
  <div class="box tabular">
    <div id="all_attributes">
    

<p>
<label for="name">Version Name:</label><input type="text" id="name" name="name" value="${version.name}"/><span class="error">${ERR_name }</span>
</p>


<p>
<label for="versionType">Version Type:</label>
		<select id="versionType" name="versionType">
			<optgroup>
				<option value="DEV">Development</option>
				<option value="PREVIEW">Preview</option>
				<option value="UAT">UAT</option>
				<option value="RC">RC</option>
				<option value="OFFICIAL">Official</option>
			</optgroup>
		</select>
		${ERR_versionType}
</p>


<p>
		<label for="build">Build:</label>
		<input type="text" name="build" id="build" /><span class="error">${ERR_build }</span>
</p>



    </div>

      
  </div>

	<a href="javascript:history.back();">Cancel</a> &nbsp;&nbsp;
  <input type="submit" name="commit" value="Create" />
</form>
<div id="preview" class="wiki"></div>


        
        <div style="clear:both;"></div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
