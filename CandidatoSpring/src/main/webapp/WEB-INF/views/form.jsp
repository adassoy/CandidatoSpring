<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
 
<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Formulario Candidato</title>
	<base href="${pageContext.request.contextPath}/"></base>
	
	<link rel="stylesheet" href="resources/css/styles.css?v=1.0">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	
</head>
<body>
	
	<form:form action="candidato/save" method="post" commandName="candidato">

	<c:if test="${!isNew}">
		<form:label path="id">ID</form:label> 
		<form:input path="id" readonly="true"/>
		<form:errors path="id" cssClass="error"/>
		<br><br>
	</c:if>
	
	<form:label path="dni">DNI</form:label>
	<form:input path="dni" placeholder="DNI"/>
	<form:errors path="dni" cssClass="error"/>
	<br><br>
	
	<form:label path="nombre">NOMBRE</form:label>
	<form:input path="nombre" placeholder="NOMBRE"/>
	<form:errors path="nombre" cssClass="error"/>
	<br><br>
	
	<input type="submit" value="ENVIAR">
</form:form>
	
	
	<!-- ################################################################ -->
	



	<!-- JavaScript -->

</body>
</html>