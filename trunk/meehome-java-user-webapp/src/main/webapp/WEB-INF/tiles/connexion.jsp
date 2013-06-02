<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
HEADER

<div style="float:right;">
	<form:form modelAttribute="user" method="POST">
		<form:errors path="*"  />
		<form:input path="login" placeholder="login" />
		<form:password path="password" placeholder="password"  />
		<button id="buttonConnexion">connexion</button>
	</form:form>
</div>