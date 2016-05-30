<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Seleção</title>
    </head>
    <body>
        <h1>Pesquisa de Seleção</h1>
        <table border=1>
            <tr>
                <th>Código da Seleção</th>
                <th>Modalidade Seleção</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${selecoes}" var="selecao">
                <tr>
                    <td><c:out value="${selecao.codSelecao}" /></td>
                    <td><c:out value="${selecao.modalidade.nome}" /></td>
                    <td>
                        <a href="ManterSelecaoController?acao=prepararEditar&codSelecao=<c:out value="${selecao.codSelecao}" />">Editar</a>
                    </td>
                    <td>
                        <a href="ManterSelecaoController?acao=prepararExcluir&codSelecao=<c:out value="${selecao.codSelecao}" />">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterSelecaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
