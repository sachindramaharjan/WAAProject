var addToCart = function(productId, quantity, mode){
	
	$.ajax({
		url:"/store/cart/add/" + productId + "?quantity="+quantity+"&mode="+mode,
		type: "PUT",
		datatype:"json",
		contentType:"application/json",
		success:function(success){
			$("#dialog" ).dialog({
			    buttons: { "OK": function() { $(this).dialog("close"); } }
			});
		}
	});
}

var updateCart = function(elementId,productId, mode){
	var quantity = $("#"+elementId).val();
	addToCart(productId, quantity, mode);
}


var removeFromCart = function(rowid, productId){
	$.ajax({
		url:"/store/cart/remove/"+productId,
		type: "DELETE",
		dataType: "json",
		contentType: "application/json",
		success:function(success){
			//$("#"+rowid).remove();
			location.reload();
		},
		error:function(error){
		}
	});
}

function validate(evt) {
	
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[1-9]\d*/;
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}

function addProductToCart(productId, element) {
	var quantity = $("#"+element).val();
	addToCart(productId, quantity, 'add');
}

function checkOut(root_url) {
	$("#dialog").dialog({
		buttons : {
			"OK" : function() {
				$(this).dialog("close");
				window.location.href = "http://"+window.location.host+root_url;
			}
		}
	});
}