<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Formulario Candidato</title>
</head>
<body>


	<a href="inventario"> &lt;&lt; Volver Inventario</a>
	<br>
	<h1>Formulario para Candidato</h1>


	<form:form action="#" method="post" commandName="#">

		
			<form:label path="id">id:</form:label>
			<form:input path="id" readonly="true" />
			<form:errors path="id" cssClass="error" />
			<br>
			<br>
		

			<form:label path="dni">Descripción:</form:label>
			<form:input path="dni" placeholder="Introduce el dni" />
			<form:errors path="dni" cssClass="error" />
			<br>
			<br>

			<form:label path="nombre">Precio:</form:label>
			<form:input path="nombre" placeholder="Introduce el nombre"/>
			<form:errors path="nombre" cssClass="error" />
			<br>
			<br>

		<input type="submit" value="Enviar">
	</form:form>

</body>
</html>