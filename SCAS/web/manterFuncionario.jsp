<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionário</title>
    </head>
    <body>
        <h1>Manter Funcionário - ${operacao}</h1>
        <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario" onsubmit="return validarFormulario(this)">
            <table>
                <tr> 
                    <td>Nome do Usuário:</td> 
                    <td>
                        <select name="optUsuario" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${funcionario.codUsuario == null}"> selected</c:if>> </option>  
                            <c:forEach items="${usuarios}" var="usuario">
                                <option value="${usuario.codUsuario}" <c:if test="${funcionario.codUsuario == usuario.codUsuario}"> selected</c:if>>${usuario.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Registro:</td> 
                    <td><input type="text" name="txtRegistro" value="${funcionario.registro}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Cargo do Funcionário:</td> 
                    <td>
                        <select name="optCargo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="" <c:if test="${funcionario.cargo == null}"> selected</c:if>> </option>
                        <option value="Diretor" <c:if test="${funcionario.cargo == 'Diretor'}"> selected</c:if>>Diretor</option>
                        <option value="Professor" <c:if test="${funcionario.cargo == 'Professor'}"> selected</c:if>>Professor</option>
                        <option value="Técnico" <c:if test="${funcionario.cargo == 'Técnico'}"> selected</c:if>>Técnico</option> 
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
                if (form.optUsuario.value == "0"){
                    mensagem = mensagem + "Selecione um Usuário\n";
                }
                if (form.txtRegistro.value == ""){
                    mensagem = mensagem + "Informe o Registro\n";
                }                             
                if (form.optCargo.value == ""){
                    mensagem = mensagem + "Selecione o Cargo\n";
                }
                if (!campoNumerico(form.txtRegistro.value)){
                    mensagem = mensagem + "O Registro deve ser numérico";
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