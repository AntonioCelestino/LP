<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Recurso</title>
    </head>
    <body>
        <h1>Pesquisa de Recurso</h1>
        <table border=1>
            <tr>
                <th>Código do Recurso</th>
                <th>Modalidade</th>
                <th>Saldo Recurso</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${recursos}" var="recurso">
                <tr>
                    <td><c:out value="${recurso.codRecurso}" /></td>
                    <td><c:out value="${recurso.modalidade.nome}" /></td>
                    <td><c:out value="${recurso.saldo}" /></td>
                    <td>
                        <a href="ManterRecursoController?acao=prepararEditar&codRecurso=<c:out value="${recurso.codRecurso}" />">Editar</a>
                    </td>
                    <td>
                        <a href="ManterRecursoController?acao=prepararExcluir&codRecurso=<c:out value="${recurso.codRecurso}" />">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterRecursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>