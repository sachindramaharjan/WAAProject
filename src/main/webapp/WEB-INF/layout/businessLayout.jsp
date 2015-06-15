<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<tiles:insertAttribute name="category"/>
					</div>	
				</div> <!-- row -->
				<div class="col-sm-9 padding-right">
					<tiles:insertAttribute name="product"/>
				</div>
			</div> <!-- container -->
		</div>
	</section>
	    
    