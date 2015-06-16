var addToCart = function(productId, quantity, mode){
	
	$.ajax({
		url:"/store/cart/add/" + productId + "?quantity="+quantity+"&mode="+mode,
		type: "PUT",
		datatype:"json",
		contentType:"application/json",
		success:function(success){
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