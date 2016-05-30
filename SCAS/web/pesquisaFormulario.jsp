<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Formulários</title>
    </head>
    <body>
        <h1>Pesquisa de Formulários</h1>
        <table border="1">
            <tr>
                <th>Código Formulário</th>
                <th>Nome Aluno</th>
                <th>Número Edital</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${formularios}" var="formulario">
                <tr>
                    <td><c:out value="${formulario.codFormulario}"/></td>
                    <td><c:out value="${formulario.aluno.usuario.nome}"/></td>
                    <td><c:out value="${formulario.selecao.numeroEdital}"/></td>
                    <td>
                        <a href="ManterFormularioController?acao=prepararEditar&codFormulario=<c:out value="${formulario.codFormulario}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterFormularioController?acao=prepararExcluir&codFormulario=<c:out value="${formulario.codFormulario}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFormularioController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>