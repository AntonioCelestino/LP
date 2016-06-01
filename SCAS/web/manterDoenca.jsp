<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Doença</title>
    </head>
    <body>
        <h1>Manter Doença - ${operacao}</h1>
        <form action="ManterDoencaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterDoenca" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Digite sequência numérica para cada membro familiar (1, 2, ...):<input type="text" size="10" name="txtCodDoenca" value="${doenca.codDoenca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Formulário: (Nome do Aluno | Seleção Modalidade): 
                        <select name="optFormulario" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${doenca.codFormulario == null}"> selected</c:if>> </option>  
                            <c:forEach items="${formularios}" var="formulario">
                                <option value="${formulario.codFormulario}" <c:if test="${doenca.codFormulario == formulario.codFormulario}"> selected</c:if>>${formulario.aluno.usuario.nome} | ${formulario.selecao.numeroEdital} | ${formulario.selecao.modalidade.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Nome do familiar doente (pode ser o estudante):
                        <input type="text" name="txt_qt17_Nome" value="${doenca.qt17_Nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Doença do familiar:
                        <input type="text" size="30" name="txt_qt17_Doenca" value="${doenca.qt17_Doenca}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Incapacita para o trabalho?
                        <input type="radio" name="opt_qt17_Trabalho" value="Sim" <c:if test="${doenca.qt17_Trabalho == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt17_Trabalho" value="Não" <c:if test="${doenca.qt17_Trabalho == 'Não'}"> checked</c:if>>Não
                    </td>
                </tr>
                <tr>
                    <td>Dependente para as atividades diárias?
                        <input type="radio" name="opt_qt17_Dependencia" value="Sim" <c:if test="${doenca.qt17_Dependencia == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt17_Dependencia" value="Não" <c:if test="${doenca.qt17_Dependencia == 'Não'}"> checked</c:if>>Não
                    </td>
                </tr>
                <tr>
                    <td>Gasto mensal:
                        <input type="text" name="txt_qt17_Gasto" value="${doenca.qt17_Gasto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.optFormulario.value == "0"){
                    mensagem = mensagem + "Selecione um Formulário\n";
                }
                if (form.txtCodDoenca.value == ""){
                    mensagem = mensagem + "Informe o número de sequência\n";
                }
                if (form.txt_qt17_Nome.value == ""){
                    mensagem = mensagem + "Informe o nome do familiar\n";
                }
                if (form.txt_qt17_Doenca.value == ""){
                    mensagem = mensagem + "Informe a doença do familiar\n";
                }
                if (form.txt_qt17_Gasto.value == ""){
                    form.txt_qt17_Gasto.value = 0.0;
                }
                if (form.txt_qt17_Gasto.value < 0.0){
                    mensagem = mensagem + "O valor do gasto não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt17_Gasto.value)){
                    mensagem = mensagem + "O valor do gasto deve ser numérico\n";
                }
                if(form.opt_qt17_Trabalho.value == ""){
                    mensagem = mensagem + "Você deve selecionar 'Sim' ou 'Não' Incapacita para o trabalho\n";
                }
                if(form.opt_qt17_Dependencia.value == ""){
                    mensagem = mensagem + "Você deve selecionar 'Sim' ou 'Não' Dependente para as atividades diárias\n";
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
