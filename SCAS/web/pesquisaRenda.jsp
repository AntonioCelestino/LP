<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Rendas</title>
    </head>
    <body>
        <h1>Pesquisa de Rendas</h1>
        <table border="1">
            <tr>
                <th>Código Renda</th>
                <th>Código Formulário</th>
                <th>Nome Familiar</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${rendas}" var="renda">
                <tr>
                    <td><c:out value="${renda.codRenda}"/></td>
                    <td><c:out value="${renda.formulario.codFormulario}"/></td>
                    <td><c:out value="${renda.qt18_Nome}"/></td>
                    <td>
                        <a href="ManterRendaController?acao=prepararEditar&codRenda=<c:out value="${renda.codRenda}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterRendaController?acao=prepararExcluir&codRenda=<c:out value="${renda.codRenda}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterRendaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
