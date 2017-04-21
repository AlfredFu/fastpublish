<%@ include file="../include/header.jsp" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div id="main" class="">

    <div id="sidebar">
        <form action="${pageContext.request.contextPath }/product/activity/${product.id}" accept-charset="UTF-8" method="get">
<h3>Activity Type</h3>
<ul>
  <li>
  <input type="checkbox" name="sel_activity_type" id="activity_type_development" value="DEV"  
	  <c:forEach items="${selActivityType }" var="activityType">
	  	<c:if test="${activityType ==  'DEV' }">checked</c:if>
	  </c:forEach>
    />
    <label for="show_issues">
      <a href="/projects/lnred/activity?show_issues=1">Development</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="sel_activity_type" id="activity_type_preview" value="PREVIEW" <c:forEach items="${selActivityType }" var="activityType">
	  	<c:if test="${activityType ==  'PREVIEW' }">checked</c:if>
	  </c:forEach> />
    <label for="show_changesets">
      <a href="/projects/lnred/activity?show_changesets=1">Preview</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="sel_activity_type" id="activity_type_uat" value="UAT" <c:forEach items="${selActivityType }" var="activityType">
	  	<c:if test="${activityType ==  'UAT' }">checked</c:if>
	  </c:forEach> />
    <label for="show_news">
      <a href="/projects/lnred/activity?show_news=1">UAT</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="sel_activity_type" id="activity_type_rc" value="RC" <c:forEach items="${selActivityType }" var="activityType">
	  	<c:if test="${activityType ==  'RC' }">checked</c:if>
	  </c:forEach> />
    <label for="show_documents">
      <a href="/projects/lnred/activity?show_documents=1">RC</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="sel_activity_type" id="activity_type_official" value="OFFICIAL" <c:forEach items="${selActivityType }" var="activityType">
	  	<c:if test="${activityType ==  'OFFICIAL' }">checked</c:if>
	  </c:forEach> />
    <label for="show_files">
      <a href="/projects/lnred/activity?show_files=1">Official</a>
    </label>
  </li>
  <li>
    <input type="checkbox" name="sel_activity_type" id="activity_type_all" checked="checked" />
    <label for="show_files">
      <a href="/projects/lnred/activity?show_files=1">All</a>
    </label>
  </li>

</ul>

<p><input type="submit" value="Apply" class="button-small" /></p>
</form>
       
    </div>

    

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


<%@ include file="../package/version_package_list.jsp" %>



<script>
	$(document).ready(function(){
		
		var checkAll = true;
		$("input[type='checkbox']").each(function(){
			if(!this.checked && $(this).attr("id") != "activity_type_all"){
				checkAll = false;
				return;
			}
		});
		$("#activity_type_all").prop("checked", checkAll );
		
		
		$(".delversion_link").click(function(){
			if(confirm("All packages belongs to this version will be delete, \nare you want to del this version")){
				var vid = $(this).data("vid");
				var pid = $(this).data("pid");
				$.ajax({
					url:"${pageContext.request.contextPath}/version/delete",
					data:{id:vid, pid: pid},
					success:function(result){
						var id = "#v" + vid;
						$(id).remove();
					}
				});
			}	
 			return false;
		});
		
		$(".delpackage_link").click(function(){
			if(confirm("Are you sure you want to delete this package")){
				var pkeid= $(this).data("pkeid");
				var pid= $(this).data("pid");
				$.ajax({
					url:"${pageContext.request.contextPath}/package/delete", 
					data:{id:pkeid, pid: pid},
					success:function(result){
						$("#pkedt_"+pkeid).remove();
						$("#pkedes_" + pkeid).remove();
					}
				});
			}
			return false;
		});
		
		$("#activity_type_all").click(function(){
			var isCheckAll = this.checked;
			$("input[type='checkbox']").each(function(){
				this.checked = isCheckAll;
			});
		});
		
		$("input[type='checkbox']").click(function(){
			var checkAll = true;
			$("input[type='checkbox']").each(function(){
				if(!this.checked && $(this).attr("id") != "activity_type_all"){
					checkAll = false;
					return;
				}
			});
			$("#activity_type_all").prop("checked", checkAll );
			
		});
		
		
	});

</script>


</div>



<div style="float:left;">
<a title="From 2016-09-30 to 2016-10-29" accesskey="p" href="http://staging2.lexisnexis.com.cn/lexisred/preview/index.html">« Previous</a>
</div>
<div style="float:right;">

</div>


        
        <div style="clear:both;"></div>
    </div>
    
<jsp:include page="../include/footer.jsp"></jsp:include>

