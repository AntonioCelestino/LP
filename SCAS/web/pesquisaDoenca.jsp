<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Doenças</title>
    </head>
    <body>
        <h1>Pesquisa de Doenças</h1>
        <table border="1">
            <tr>
                <th>Código Doença</th>
                <th>Código Formulário</th>
                <th>Nome Doente</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${doencas}" var="doenca">
                <tr>
                    <td><c:out value="${doenca.codDoenca}"/></td>
                    <td><c:out value="${doenca.formulario.codFormulario}"/></td>
                    <td><c:out value="${doenca.qt17_Nome}"/></td>
                    <td>
                        <a href="ManterDoencaController?acao=prepararEditar&codDoenca=<c:out value="${doenca.codDoenca}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterDoencaController?acao=prepararExcluir&codDoenca=<c:out value="${doenca.codDoenca}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDoencaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
