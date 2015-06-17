var removeProduct = function(productId){
	$("#confirm" ).dialog({
	    buttons: { "OK": function() { $(this).dialog("close"); } }
	});
	
	$("#confirm" ).dialog({
	    buttons: {  "Yes" : function(){
	    	$(this).dialog("close");
	    	
	    	$.ajax({
	    		url:"/store/products/remove/"+productId,
	    		type: "DELETE",
	    		dataType: "json",
	    		contentType: "application/json",
	    		success:function(success){
	    			location.reload();
	    		},
	    		error:function(error){
	    		}
	    	});	
	    } ,"Cancel": function() { $(this).dialog("close"); } }
	});	
}