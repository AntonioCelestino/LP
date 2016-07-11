<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Menu Usuário Aluno</h1>
        <h3>Usuário Logado: ${loginUsuarioLogado} - <a href="index.jsp">Logout</a></h3>
        <a href="ManterUsuarioController?acao=prepararOperacao&operacao=Editar&codUsuario=${codUsuario}&codUsuarioLogado=${codUsuarioLogado}">Manter Usuário</a><br>
        <br/>
        <h3>Gerar Relatórios:</h3>
        <a href="RelatorioBolsasController">Relatório Bolsa</a><br>
    </body>
</html>
