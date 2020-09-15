<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="jee7afondo.dto.FormaPagoDTO"%>
<%@page import="jee7afondo.dto.CursoDTO"%>
<%@page import="java.util.List"%>
<%
	// variables
	List<CursoDTO>cursos;
	List<FormaPagoDTO>formasPago;
	
	// obtengo las listas del modelo
	cursos = (List<CursoDTO>) request.getAttribute("cursos");
	formasPago= (List<FormaPagoDTO>) request.getAttribute("formasPago");

%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Inscripción</title>
</head>

<body>
	
	<header>
		<h2>Ingrese sus datos y seleccione uno de nuestros cursos disponibles</h2>
		<hr>
		<br>
	</header>
	
	<form action="posInscripcion"  method="get">
		<br>
		<label>Nombre:</label> 
		<input type="text" name="nombre" >
		
		<br>
		<label>Tel:</label> 
		<input type="tel" name="telefono" >
		
		<br>
		<label>Cursos: </label>
		<select name="idCurso">
		<%
			for(CursoDTO curso : cursos){							
		%>
			<option value="<%= curso.getIdCurso() %>">
			<%= curso.getDescripcion() %>
			</option>
		<%
			}
		
		%>
		</select>
		
		<br>
		<label>Formas Pago: </label>
		<select name="idFormaPago">
		<%
			for(FormaPagoDTO formaPago : formasPago){							
		%>
			<option value="<%= formaPago.getIdFormaPago() %>" >
			<%= formaPago.getDescripcion() %>
			</option>
		<%
			}
		
		%>
				
		</select>
		
		<input type="submit" value = "Inscribirme">
		
	</form>
	
</body>

</html>