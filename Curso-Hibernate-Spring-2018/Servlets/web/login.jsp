<%--
  Created by IntelliJ IDEA.
  User: eliothmonroy
  Date: 8/27/19
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<%--	Comentario JSP, lo de abajo es un directiva de declaración	--%>
		<%! int i=0;  %>
		<form method="get" action="abc123">
			<table>
				<tr>
					<td><label for="usuario">Usuario:</label></td>
					<td><input type="text" name="usuario" id="usuario"></td>
					<td><label for="password">Clave</label></td>
					<td><input type="password" name="password" id="password"></td>
					<td><label for="empresa">Empresa</label></td>
					<td><input type="text" name="empresa" id="empresa"></td>
				</tr>
				<tr>
					<button type="submit">Enviar</button>
				</tr>
			</table>
			<%--		Directiva de Script--%>
			<%for (i = 0; i < 10; i++) {%>
			<%--	El igual tiene que ir junto al simbolo de porcentaje, se llama directiva de expresión  --%>
			<label>Hola <%=i %></label>
			<%}%>

		</form>
	</body>
</html>
