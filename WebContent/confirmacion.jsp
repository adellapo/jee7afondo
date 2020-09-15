<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	int idInscripcion = (Integer) request.getAttribute("idInscripcion");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscripción realizada</title>
</head>
<body>

	<h2>¡Felicitaciones!</h2>
	<hr>
	<br>
	<p>Su código de inscripción es: <%=idInscripcion%></p>
	<br>

</body>
</html>