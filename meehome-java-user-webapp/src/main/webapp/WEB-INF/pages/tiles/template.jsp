<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
    <head>
        <tiles:insertAttribute name="meta" />
    </head>
    <body>
    	<div class="wrapper">
	        <header>
	            <tiles:insertAttribute name="header" />
	        </header>
	        <nav>
	            <tiles:insertAttribute name="navigation" />
	        </nav>
	        <div class="body">
	            <tiles:insertAttribute name="body" />
	        </div>
	        <div class="clear"></div>
	        <footer>
	            <tiles:insertAttribute name="footer" />
	        </footer>
        </div>
    </body>
</html>