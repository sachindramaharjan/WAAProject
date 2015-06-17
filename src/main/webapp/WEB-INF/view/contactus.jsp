<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../layout/taglib.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/style.css" />" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<div id="main">
	<style type="text/css">
div#map_container {
	width: 100%;
	height: 350px;
}
</style>
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

	<script type="text/javascript">
		(function($) {
			// rely on $ within safety of "bodyguard" function
			$(document).ready(
					function() {
						//alert("jquery functioning");
						var latlng = new google.maps.LatLng(41.017338,
								-91.970563);
						var myOptions = {
							zoom : 15,
							center : latlng,
							mapTypeId : google.maps.MapTypeId.ROADMAP
						};
						var map = new google.maps.Map(document
								.getElementById("map_container"), myOptions);

						var marker = new google.maps.Marker({
							position : latlng,
							map : map,
							title : "MVC Shop!"
						});

					});
		})(jQuery);
	</script>
	<div id="map_container"></div>
	<div id="contact-info">
		<br />
		<h2 class="title text-center">Contact Info</h2>
		<address>
			<p>MVC-Shopper Inc.</p>
			<p>Fairfield</p>
			<p>Iowa USA</p>
			<p>Mobile: +461 888 9999</p>
			<p>Email: info@mvc-shopper.com</p>
		</address>
	</div>
</div>