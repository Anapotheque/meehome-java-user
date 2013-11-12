<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <tiles:insertAttribute name="meta" />
    </head>
    <body>
		
		<section>
			<tiles:insertAttribute name="section" />
		</section>
        
        <!-- JAVASCRIPT -->
		<script src="<c:url value='/resources/bootstrap-3.0.0/js/bootstrap.js'/>"></script>
        
    </body>
</html>