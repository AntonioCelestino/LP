<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Produtos</title>
    </head>
    <body>
        <h1>Pesquisa de Produtos</h1>
        <table border="1">
            <tr>
                <th>Código Produto</th>
                <th>Nome Produto</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.id}"/></td>
                    <td><c:out value="${produto.nome}"/></td>
                    <td>
                        <a href="ManterProdutoController?acao=prepararOperacao&operacao=Editar&codProduto=<c:out value="${produto.id}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterProdutoController?acao=prepararOperacao&operacao=Excluir&codProduto=<c:out value="${produto.id}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
