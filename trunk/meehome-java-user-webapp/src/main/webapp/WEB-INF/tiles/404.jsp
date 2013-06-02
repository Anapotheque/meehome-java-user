<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Page non trouvée</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<c:url value='/resources/css/normalize.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/structure.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/formulaire.css' />" type="text/css" />
		
		<!-- TEST -->
		<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.10.3.custom.css'/>" rel="stylesheet">
		<script src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
		<script src="<c:url value='/resources/js/jquery-ui-1.10.3.custom.js'/>"></script>
    </head>
    <body>
    	<div class="wrapper">
   	    	<div class="ui-state-error ui-corner-all" style="padding: 10px;">
            	VOTRE PAGE N'EXISTE PAS
            </div>
        </div>
    </body>
</html>