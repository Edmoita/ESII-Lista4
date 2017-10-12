<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.appservlet.entidades.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appservlet - Principal</title>
</head>
<body>
<%
Usuario usuario = (Usuario) request.getAttribute("usuario");
out.println("Username: " + usuario.getUsername() + "<br>");
out.println("Nome: " + usuario.getNome() + "<br>");
out.println("E-mail: " + usuario.getEmail() + "<br>");
out.println("Você acessou o sistema com sucesso!");
%>
<br>
<a href="inserirUsuario">Inserir Usuário</a><br>
<a href="buscarUsuario">Buscar Usuário</a><br>
<a href="listarUsuarios">Listar Usuários</a><br>
<a href="logout">Logout</a>
</body>
</html>