<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Modalidade</title>
    </head>
    <body>
        <h1>Manter Modalidade - ${operacao}</h1>
        <form action="ManterModalidadeController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterModalidade" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodModalidade" value="${modalidade.codModalidade}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome:</td> 
                    <td><input type="text" name="txtNomeModalidade" value="${modalidade.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Valor Mensal (R$):</td> 
                    <td><input type="text" name="txtValorMensal" value="${modalidade.valorMensal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Descrição da Modalidade:</td> 
                    <td><input type="text" name="txtDescricaoModalidade" value="${modalidade.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
            <!--
            
            function campoNumerico(valor)
            {
                var caracteresValidos = ".0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtCodModalidade.value == ""){
                    mensagem = mensagem + "Informe o Código da Modalidade\n";
                }                             
                if (form.txtNomeModalidade.value == ""){
                    mensagem = mensagem + "Informe o Nome da Modalidade\n";
                }
                if (form.txtValorMensal.value == ""){
                    mensagem = mensagem + "Informe o Valor Mensal\n";
                }
                if (form.txtDescricaoModalidade.value == ""){
                    mensagem = mensagem + "Informe uma Descrição para a Modalidade\n";
                }
                if (!campoNumerico(form.txtCodModalidade.value)){
                    mensagem = mensagem + "Código da Modalidade deve ser somente numérico\n";
                }
                if (!campoNumerico(form.txtValorMensal.value)){
                    mensagem = mensagem + "Valor Mensal deve ser somente numérico\n";
                }
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>
    </body>
</html>