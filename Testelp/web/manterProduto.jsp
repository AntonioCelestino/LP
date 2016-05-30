<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Produto</title>
    </head>
    <body>
        <h1>Manter Produto - ${operacao}</h1>
        <form action="ManterProdutoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterProduto" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código: <input type="text" name="txtCodProduto" value="${produto.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome: <input size="40" type="text" name="txtNome" placeholder="(Não abrevie nomes)" value="${produto.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Preco: <input type="text" name="txtPreco" maxlength="14" value="${produto.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Quantidade: <input type="text" name="txtQuantidade" maxlength="12" placeholder="Ex: 32-1111-1111" value="${produto.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                <tr>
                    <td>Fornecedor: 
                        <select name="optFornecedor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${produto.id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${fornecedores}" var="fornecedor">
                                <option value="${fornecedor.id}" <c:if test="${produto.fornecedorId == fornecedor.id}"> selected</c:if>>${fornecedor.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
