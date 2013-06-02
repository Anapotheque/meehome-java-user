<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
HEADER

<div style="float:right;">
	<form:form method="POST" commandName="user">

		<c:set var="errors"><form:errors path="*"/></c:set>
	    <c:if test="${not empty errors}">
				<div class="ui-state-error ui-corner-all" style="padding: 10px;">
					<form:errors path="login"  />
					<br/>
					<form:errors path="password"  />
				</div>
			<br/>
	    </c:if>
		
		<c:choose>
			<c:when test="${not authorized}">
				<form:input path="login" placeholder="login" />
				<form:password path="password" placeholder="password"  />
				<button id="buttonConnexion">connexion</button>
			</c:when>
			<c:otherwise>
				<div style="text-align:right">
					Bienvenu <b>${user.nom} ${user.prenom}</b><br/>
					<a href="<c:url value='/deconnexion' />">déconnexion</a>
				<div style="float:right;text-align:right">
			</c:otherwise>
		</c:choose>
		
	</form:form>
</div>