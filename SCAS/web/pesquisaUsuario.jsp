<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Usuários</title>
    </head>
    <body>
        <h1>Pesquisa de Usuários</h1>
        <table border="1">
            <tr>
                <th>Código Usuário</th>
                <th>Nome Usuário</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.codUsuario}"/></td>
                    <td><c:out value="${usuario.nome}"/></td>
                    <td>
                        <a href="ManterUsuarioController?acao=prepararOperacao&operacao=Editar&codUsuario=<c:out value="${usuario.codUsuario}"/>&codUsuarioLogado=${codUsuarioLogado}">Editar</a>
                    </td>
                    <td>
                        <a href="ManterUsuarioController?acao=prepararOperacao&operacao=Excluir&codUsuario=<c:out value="${usuario.codUsuario}"/>&codUsuarioLogado=${codUsuarioLogado}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterUsuarioController?acao=prepararOperacao&operacao=Incluir&codUsuarioLogado=${codUsuarioLogado}" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
