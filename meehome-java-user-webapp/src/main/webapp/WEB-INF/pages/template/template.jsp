<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	            <aside>
	            	<tiles:insertAttribute name="aside" />
	            </aside>
	            <section>
	            	<tiles:insertAttribute name="section" />
	            </section>
	        </div>
	        <div class="clear"></div>
	        <footer>
	            <tiles:insertAttribute name="footer" />
	        </footer>
        </div>
    </body>
</html>