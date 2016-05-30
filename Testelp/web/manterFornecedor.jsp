<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Fornecedor</title>
    </head>
    <body>
        <h1>Manter Fornecedor - ${operacao}</h1>
        <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFornecedor" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código: <input type="text" name="txtCodFornecedor" value="${fornecedor.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome: <input size="40" type="text" name="txtNome" placeholder="(Não abrevie nomes)" value="${fornecedor.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>CNPJ: <input type="text" name="txtCNPJ" maxlength="14" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Telefone: <input type="text" name="txtTelefone" maxlength="12" placeholder="Ex: 32-1111-1111" value="${fornecedor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                <tr>
                    <td>
                    Cidade: <input type="text" name="txtCidade" value="${fornecedor.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
