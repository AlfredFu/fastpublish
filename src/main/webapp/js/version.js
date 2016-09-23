//$.ajax({
//	url:"http://localhost:8080/fastpublish/version/list/29",
//	
//});

$(document).ready(function(){
		$.get("http://localhost:8080/fastpublish/version/list/29", function(data){
			for(var i = 0; i< data.length; i++){
				$("#versionlist").append("<li>" + data[i].version + "</li>");
			}
		}, "json");		
});
