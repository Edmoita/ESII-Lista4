<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appservlet - Inserir Usuário</title>
</head>
<body>
<form method="post" action="inserirUsuario">
	<label>Nome:</label>
	<input type="text" name="nome"><br>
	<label>Email:</label>
	<input type="text" name="email"><br>
	<label>Username:</label>
	<input type="text" name="username"><br>
	<label>Senha:</label>
	<input type="password" name="senha"><br>
	<button type="submit">Inserir</button>
</form>
<a href="principal"><button>Cancelar</button></a>

</body>
</html>