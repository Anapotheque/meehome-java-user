<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<aside>
	ASIDE
</aside>

<section>			
	<form:form modelAttribute="user" method="POST" action="">
	
		<form:errors path="*"  />
	
		<label>Login</label>
		<form:input path="login" />
		
		<label>Password</label>
		<form:password path="password" />

		<input type="submit" value="connexion">

	</form:form>
</section>