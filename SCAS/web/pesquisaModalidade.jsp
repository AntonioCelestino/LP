<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Modalidade</title>
    </head>
    <body>
        <h1>Pesquisa de Modalidade</h1>
        <table border=1>
            <tr>
                <th>Código da Modalidade</th>
                <th>Nome Modalidade</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${modalidades}" var="modalidade">
                <tr>
                    <td><c:out value="${modalidade.codModalidade}" /></td>
                    <td><c:out value="${modalidade.nome}" /></td>
                    <td>
                        <a href="ManterModalidadeController?acao=prepararEditar&codModalidade=<c:out value="${modalidade.codModalidade}" />">Editar</a>
                    </td>
                    <td>
                        <a href="ManterModalidadeController?acao=prepararExcluir&codModalidade=<c:out value="${modalidade.codModalidade}" />">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterModalidadeController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
