<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tilesx"
	uri="http://tiles.apache.org/tags-tiles-extras"%>

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<spring:url value="/css/style.css" />" />
<script src="<spring:url value="/javascript/main.js" />"></script>

<script type="text/javascript">
	function transparent(im) {
		if (!im.transparented && (/\.png/.test(im.src))) {
			im.transparented = 1;
			var picture = im.src;
			var w = im.width;
			var h = im.height;
			im.src = "<spring:url value='/images/spacer.gif' />";
			im.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, sizingMethod='scale', src='"
					+ picture + "');";
			im.width = w;
			im.height = h;
		}
		return "transparent";
	}
</script>

</head>
<body>

	<%--get the current attribute  general.xml--%>
	<tilesx:useAttribute name="current" />

	<div id="content">
		<div id="header">
			<ul class="top_menu">
				<li><a href="index.html" class="active">Home</a></li>
				<li><a href="#">Women</a></li>
				<li><a href="#">Men</a></li>
				<li><a href="#">Kids &amp; Nursery</a></li>
				<li><a href="#">Sale</a></li>
				<li><a href="#">Designers</a></li>
				<li><a href="#">Offers</a></li>
				<li><a href="#">Sports</a></li>
				<li><a href="#">Contacts</a></li>
			</ul>
			<ul class="top_menu">
				<li><a href="#">My Account</a></li>
				<li><a href="#">Track Order</a></li>
				<li><a href="#">Quick Order</a></li>
			</ul>
			<div id="search">
				Fashion Search<br />
				<form action="#">
					<select>
						<option>Category</option>
						<option>Accessories</option>
						<option>Bottoms</option>
						<option>Denim</option>
					</select> <select>
						<option>Boutique</option>
						<option>Aeffe S.P.A</option>
						<option>Agatha</option>
						<option>Anna Sui</option>
					</select> <a href="#"><img src="images/ok.jpg" alt="setalpm" width="44"
						height="23" /></a>
				</form>
			</div>
		</div>
		<!-- end of header -->



		<div id="wrapper">
			<div id="background">
				<div id="left">
					<h4 class="title1">Shop by category</h4>
					<ul id="list">
						<li><a href="#" class="type1">Accessories</a></li>
						<li><a href="#" class="type2">Bottoms</a></li>
						<li><a href="#" class="type2">Denim</a></li>
						<li><a href="#" class="type2">Dresses</a></li>
						<li><a href="#" class="type1">Eyewear</a></li>
						<li><a href="#" class="type2">Footwear</a></li>
						<li><a href="#" class="type1">Handwear</a></li>
						<li><a href="#" class="type2">Knitwear</a></li>
						<li><a href="#" class="type3">Jewellery</a>
							<ul id="inside">
								<li><a href="#">Bracelets</a></li>
								<li><a href="#">Earrings</a></li>
								<li><a href="#">Necklaces</a></li>
								<li><a href="#">Rings</a></li>
							</ul></li>
						<li><a href="#" class="type2">Outerwear</a></li>
						<li><a href="#" class="type2">Playsuits</a></li>
						<li><a href="#" class="type1">Swimwear</a></li>
						<li><a href="#" class="type2">Tops</a></li>
					</ul>
					<h4 class="title2">News &amp; Events</h4>
					<div class="news">
						<span>29 november</span>
						<p>Lorem ipsum dolor sit amet, sectetu adip scing varius
							interdum incid unt quis, libero. Aenean mturpis. Maecenas
							hendrerit masa laoreet iaculipede mnisl ulamcorper.</p>
						<a href="#" class="more">read more</a>
					</div>
					<div class="news">
						<span>17 november</span>
						<p>Maecenas hendrerit masa laoreet iaculipede mnisl
							ulamcorper.</p>
						<a href="#" class="more">read more</a>
					</div>
					<div class="news">
						<span>05 november</span>
						<p>Lorem ipsum dolor sit amet, sectetu adip scing varius
							interdum incid unt quis, libero. Aenean mturpis. Maecenas
							hendrerit masa laoreet iaculipede mnisl ulamcorper.</p>
						<a href="#" class="more">read more</a>
					</div>
					<h4 class="title3">Currencies</h4>
					<div class="currencies">
						<select>
							<option>US Dollar</option>
							<option>Euro</option>
						</select>
					</div>
				</div>
				
				<div id="center">
					
				</div>
				
				<div id="right">
					<h4 class="title2">
						<img src="images/cart.gif" alt="" width="18" height="19"
							class="cart" />Shopping Cart
					</h4>
					<div class="bag">
						There are no items in <br /> your shopping bag<br /> <a href="#">Shopping
							Bag</a>
					</div>
					<h4 class="title3">Entry</h4>
					<div class="entry">
						<form action="#">
							Login<br /> <input type="text" /><br /> Password<br /> <input
								type="text" /><br /> <a href="#" class="forgot">Forgot
								password</a>
						</form>
					</div>
					<p class="below">
						<a href="#">Registr</a> <a href="#"><img
							src="images/enter.jpg" alt="" width="52" height="23" /></a>
					</p>
					<div class="users">
						<p>Currently Active Users:</p>
						<p>
							<font>257</font>
						</p>
					</div>
					<h4 class="title3">Shop by brand</h4>
					<ul class="brands">
						<li class="color"><a href="#">Aeffe S.P.A</a></li>
						<li><a href="#">Agatha</a></li>
						<li class="color"><a href="#">Anna Sui</a></li>
						<li><a href="#">Adeana Couture</a></li>
						<li class="color"><a href="#">Armani Exchange</a></li>
						<li><a href="#">Austin Reed</a></li>
						<li class="color"><a href="#">Babette Waserman</a></li>
						<li><a href="#">BCBG</a></li>
						<li class="color"><a href="#">Bisou-Bisou</a></li>
						<li><a href="#">Body Glove</a></li>
						<li class="color"><a href="#">Calvin Klein</a></li>
						<li><a href="#">Chanel</a></li>
						<li class="color"><a href="#">Christian Dior</a></li>
						<li><a href="#">Christian Lacoix</a></li>
						<li class="color"><a href="#">Club Monaco</a></li>
						<li><a href="#">Diesel</a></li>
						<li class="color"><a href="#">Eliott &amp; Lucca</a></li>
						<li><a href="#">Et Vous</a></li>
						<li class="color"><a href="#">Fratelli Corneliani</a></li>
						<li><a href="#">Gianni Versace</a></li>
						<li class="color"><a href="#">Giorgio Armani</a></li>
						<li><a href="#">Hesco Fashion</a></li>
						<li class="color"><a href="#">Hugo Boss</a></li>
						<li><a href="#">Izod</a></li>
						<li class="color"><a href="#">Laura Ashley</a></li>
						<li><a href="#">Mango</a></li>
						<li class="color"><a href="#">Nicole Miller</a></li>
						<li><a href="#">Olivier Strelli</a></li>
						<li class="color"><a href="#">Oxygen</a></li>
						<li><a href="#">Timberland</a></li>
					</ul>
				</div>


			</div>
			<!-- end of background -->
		</div>
		<!--  end of wrapper -->




	</div>
	<!-- end of content -->


	<div style="text-align: center">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>