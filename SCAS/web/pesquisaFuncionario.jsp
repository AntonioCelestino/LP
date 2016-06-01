<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Funcionários</title>
    </head>
    <body>
        <h1>Pesquisa de Funcionários</h1>
        <table border="1">
            <tr>
                <th>Código Funcionário</th>
                <th>Nome Funcionário</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.registro}"/></td>
                    <td><c:out value="${funcionario.usuario.nome}"/></td>
                    <td>
                        <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&codFuncionario=<c:out value="${funcionario.registro}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&codFuncionario=<c:out value="${funcionario.registro}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
