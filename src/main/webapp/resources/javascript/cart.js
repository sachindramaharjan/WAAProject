var addToCart = function(productId){
	
	$.ajax({
		url:"/store/cart/add/" + productId,
		type: "PUT",
		contentType: "application/json",
		success:function(success){
			//alert("successfully added to cart");
		}
	});
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