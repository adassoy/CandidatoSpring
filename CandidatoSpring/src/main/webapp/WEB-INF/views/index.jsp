<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html lang="es">
<head>

<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<meta charset="utf-8">
<title>Pagina de inicio</title>
<base href="${pageContext.request.contextPath}/"></base>

<link rel="stylesheet" href="resources/css/styles.css?v=1.0">

</head>
<body>

	<ol>
		<li><a href="candidato/nuevo">Nuevo Candidato</a></li>
	</ol>

	<form action="buscar" method="get">
		<fieldset>
			<legend>BUSQUEDA POR ID | DNI | NOMBRE</legend>
			<label for="tipoCampo">Indica el criterio de busqueda (si no seleccionas nada hará busqueda por DNI)</label>
						<br><br>
				<select id="tipoCampo" name="tipoCampo">
					<option value="id">id</option>
					<option value="dni" selected="selected">dni</option>
					<option value="nombre">nombre</option>			
				</select> 
						<br><br>
				<input name="valor_buscado" type="text" placeholder="Inserta un valor a buscar" /> 
						<br><br>
					
				<input type="submit" value="Buscar" /> <br> <br>
		</fieldset>
	</form>
	
	<br><br>

		<fieldset>
		<legend>LISTADO POR DNI | NOMBRE | [X] PARA ELIMINAR UN REGISTRO</legend>
			<c:forEach items="${candidatos}" var="can">
				<a href="candidato/detalle/${can.id}"> <c:out value="${can.dni}" />
					<i><c:out value="${can.nombre}" /></i>
				</a>
				<a href="candidato/eliminar/${can.id}"> [X] </a>
		
				<br>
				<br>
			</c:forEach>
		</fieldset>


	<!-- JavaScript -->

</body>
</html>
