<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Seleção</title>
        <script>
            function formatar(mascara, documento){
              var i = documento.value.length;
              var saida = mascara.substring(0,1);
              var texto = mascara.substring(i)

              if (texto.substring(0,1) != saida){
                        documento.value += texto.substring(0,1);
              }

            }
        </script>
    </head>
    <body>
        <h1>Manter Seleção - ${operacao}</h1>
        <form action="ManterSelecaoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterSelecao" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodSelecao" value="${selecao.codSelecao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Data de Início das Inscrições:</td> 
                    <td><input type="text" name="txtDataInicioSelecao" maxlength="10" placeholder="dd/mm/aaaa" OnKeyPress="formatar('##/##/####', this)" value="${selecao.dataInicioSelecao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Data de Fim das Inscrições:</td> 
                    <td><input type="text" name="txtDataFimSelecao" maxlength="10" placeholder="dd/mm/aaaa" OnKeyPress="formatar('##/##/####', this)" value="${selecao.dataFimSelecao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Número do Edital:</td> 
                    <td><input type="text" name="txtNumeroEdital" maxlength="7" placeholder="ano / semestre" OnKeyPress="formatar('####/##', this)" value="${selecao.numeroEdital}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Nome da Modalidade:</td> 
                    <td>
                        <select name="optModalidade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${selecao.codModalidade == null}"> selected</c:if>> </option>  
                            <c:forEach items="${modalidades}" var="modalidade">
                                <option value="${modalidade.codModalidade}" <c:if test="${selecao.codModalidade == modalidade.codModalidade}"> selected</c:if>>${modalidade.nome}</option>  
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
                var caracteresValidos = "0123456789";
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
                if (form.txtCodSelecao.value == ""){
                    mensagem = mensagem + "Informe o Código da Seleção\n";
                }                             
                if (form.txtDataInicioSelecao.value == ""){
                    mensagem = mensagem + "Informe a Data de Início\n";
                }
                if (form.txtDataFimSelecao.value == ""){
                    mensagem = mensagem + "Informe a Data de Fim\n";
                }
                if (form.txtNumeroEdital.value == ""){
                    mensagem = mensagem + "Informe o Número do Edital\n";
                }
                if (form.optModalidade.value == "0"){
                    mensagem = mensagem + "Selecione uma Modalidade\n";
                }
                if (!campoNumerico(form.txtCodSelecao.value)){
                    mensagem = mensagem + "Código da Seleção deve ser numérico\n";
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