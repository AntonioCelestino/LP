<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Recurso</title>
    </head>
    <body>
        <h1>Manter Recurso - ${operacao}</h1>
        <form action="ManterRecursoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterRecurso" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodRecurso" value="${recurso.codRecurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Ano de liberação do Recurso:</td> 
                    <td><input type="text" name="txtAno" maxlength="4" value="${recurso.ano}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Créditos Fornecidos (R$):</td> 
                    <td><input type="text" name="txtCreditos" value="${recurso.creditos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Débitos Efetuados (R$):</td> 
                    <td><input type="text" name="txtDebitos" value="${recurso.debitos}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Saldo (R$):</td> 
                    <td><input type="text" name="txtSaldo" value="${recurso.saldo}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Nome da Modalidade:</td> 
                    <td>
                        <select name="optModalidade" <c:if test="${operacao != 'Editar'}"> readonly</c:if>>
                            <option value="0" <c:if test="${recurso.codModalidade == null}"> selected</c:if>> </option>  
                            <c:forEach items="${modalidades}" var="modalidade">
                                <option value="${modalidade.codModalidade}" <c:if test="${recurso.codModalidade == modalidade.codModalidade}"> selected</c:if>>${modalidade.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
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
                if (form.txtCodRecurso.value == ""){
                    mensagem = mensagem + "Informe o Código do Recurso\n";
                }                             
                if (form.txtAno.value == ""){
                    mensagem = mensagem + "Informe o Ano de liberação do Recurso\n";
                }
                if (form.optModalidade.value == "0"){
                    mensagem = mensagem + "Selecione a Modalidade\n";
                }
                if (form.txtCreditos.value == ""){
                    form.txtCreditos.value = 0.0;
                }
                if (form.txtDebitos.value == ""){
                    form.txtDebitos.value = 0.0;
                }
                if (form.txtCreditos.value < 0.0){
                    mensagem = mensagem + "Crédito não pode ser negativo\n";
                    form.txtSaldo.value = "";
                }
                if (form.txtDebitos.value < 0.0){
                    mensagem = mensagem + "Débito não pode ser negativo\n";
                    form.txtSaldo.value = "";
                }
                if (form.txtCreditos.value >= 0.0 && form.txtDebitos.value >= 0.0){
                    form.txtSaldo.value = form.txtCreditos.value - form.txtDebitos.value;
                }
                if (!campoNumerico(form.txtCodRecurso.value)){
                    mensagem = mensagem + "Código do Recurso deve ser numérico\n";
                } 
                if (!campoNumerico(form.txtAno.value)){
                    mensagem = mensagem + "Ano deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCreditos.value)){
                    mensagem = mensagem + "Crédito deve ser numérico\n";
                }
                if (!campoNumerico(form.txtDebitos.value)){
                    mensagem = mensagem + "Débito deve ser numérico\n";
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