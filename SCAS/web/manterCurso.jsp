<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Curso</title>
    </head>
    <body>
        <h1>Manter Curso - ${operacao}</h1>
        <form action="ManterCursoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCurso" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodCurso" value="${curso.codCurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome do Curso:</td> 
                    <td><input type="text" name="txtNomeCurso" value="${curso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Turno:</td> 
                    <td>
                        <select name="optTurno" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="" <c:if test="${curso.turno == null}"> selected</c:if>> </option>
                        <option value="Diurno" <c:if test="${curso.turno == 'Diurno'}"> selected</c:if>>Diurno</option>
                        <option value="Noturno" <c:if test="${curso.turno == 'Noturno'}"> selected</c:if>>Noturno</option>
                        <option value="Integral" <c:if test="${curso.turno == 'Integral'}"> selected</c:if>>Integral</option> 
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td>Tipo de Ensino:</td> 
                    <td>
                        <select name="optTipoEnsino" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${curso.tipoEnsino == null}"> selected</c:if>> </option>
                            <option value="Integrado" <c:if test="${curso.tipoEnsino == 'Integrado'}"> selected</c:if>>Integrado</option>
                            <option value="Superior" <c:if test="${curso.tipoEnsino == 'Superior'}"> selected</c:if>>Superior</option>
                            <option value="Pós-Graduação" <c:if test="${curso.tipoEnsino == 'Pós-Graduação'}"> selected</c:if>>Pós-Graduação</option>
                            <option value="Conc.Externa" <c:if test="${curso.tipoEnsino == 'Conc.Externa'}"> selected</c:if>>Conc.Externa (cursando ensino médio)</option>
                            <option value="Subsequente" <c:if test="${curso.tipoEnsino == 'Subsequente'}"> selected</c:if>>Subsequente (ensino médio concluído)</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
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
                if (form.txtCodCurso.value == ""){
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }                             
                if (form.txtNomeCurso.value == ""){
                    mensagem = mensagem + "Informe o Nome do Curso\n";
                }
                if (form.optTurno.value == ""){
                    mensagem = mensagem + "Selecione um Turno\n";
                }
                if (form.optTipoEnsino.value == ""){
                    mensagem = mensagem + "Selecione o Tipo de Ensino do Curso\n";
                }
                if (!campoNumerico(form.txtCodCurso.value)){
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }                                   
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
        </SCRIPT>  
    </body>
</html>