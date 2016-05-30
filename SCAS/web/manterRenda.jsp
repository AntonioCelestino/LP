<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Renda</title>
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
        <h1>Manter Renda - ${operacao}</h1>
        <form action="ManterRendaController?acao=confirmar${operacao}" method="post" name="frmManterRenda" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Digite sequência numérica para cada membro familiar (1, 2, ...):<input type="text" size="10" name="txtCodRenda" value="${renda.codRenda}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Formulário: (Nome do Aluno | Seleção Modalidade): 
                        <select name="optFormulario" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${renda.codFormulario == null}"> selected</c:if>> </option>  
                            <c:forEach items="${formularios}" var="formulario">
                                <option value="${formulario.codFormulario}" <c:if test="${renda.codFormulario == formulario.codFormulario}"> selected</c:if>>${formulario.aluno.usuario.nome} | ${formulario.selecao.numeroEdital} | ${formulario.selecao.modalidade.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Primeiro nome do familiar (pode ser o estudante):
                        <input type="text" name="txt_qt18_Nome" value="${renda.qt18_Nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Data de nascimento do familiar:
                        <input type="text" name="txt_qt18_DataNasc" maxlength="10" placeholder="dd/mm/aaaa" OnKeyPress="formatar('##/##/####', this)" value="${renda.qt18_DataNasc}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Parentesco do familiar:
                        <input type="text" name="txt_qt18_Parentesco" value="${renda.qt18_Parentesco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Estado civil do familiar:
                        <select name="opt_qt18_EstadoCivil" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${renda.qt18_EstadoCivil == null}"> selected</c:if>> </option>
                            <option value="solteiro" <c:if test="${renda.qt18_EstadoCivil == 'solteiro'}"> selected</c:if>>solteiro</option>
                            <option value="casado ou união estável" <c:if test="${renda.qt18_EstadoCivil == 'casado ou união estável'}"> selected</c:if>>casado ou união estável</option>
                            <option value="viúvo" <c:if test="${renda.qt18_EstadoCivil == 'viúvo'}"> selected</c:if>>viúvo</option>
                            <option value="separado legalmente" <c:if test="${renda.qt18_EstadoCivil == 'separado legalmente'}"> selected</c:if>>separado legalmente</option>
                            <option value="separado sem legalização" <c:if test="${renda.qt18_EstadoCivil == 'separado sem legalização'}"> selected</c:if>>separado sem legalização</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Escolaridade do familiar:
                        <select name="opt_qt18_Escolaridade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${renda.qt18_Escolaridade == null}"> selected</c:if>> </option>
                            <option value="analfabeto" <c:if test="${renda.qt18_Escolaridade == 'analfabeto'}"> selected</c:if>>analfabeto</option>
                            <option value="ensino fundamental incompleto" <c:if test="${renda.qt18_Escolaridade == 'ensino fundamental incompleto'}"> selected</c:if>>ensino fundamental incompleto</option>
                            <option value="ensino fundamental completo" <c:if test="${renda.qt18_Escolaridade == 'ensino fundamental completo'}"> selected</c:if>>ensino fundamental completo</option>
                            <option value="ensino médio incompleto" <c:if test="${renda.qt18_Escolaridade == 'ensino médio incompleto'}"> selected</c:if>>ensino médio incompleto</option>
                            <option value="ensino médio completo" <c:if test="${renda.qt18_Escolaridade == 'ensino médio completo'}"> selected</c:if>>ensino médio completo</option>
                            <option value="ensino superior incompleto" <c:if test="${renda.qt18_Escolaridade == 'ensino superior incompleto'}"> selected</c:if>>ensino superior incompleto</option>
                            <option value="ensino superior completo" <c:if test="${renda.qt18_Escolaridade == 'ensino superior completo'}"> selected</c:if>>ensino superior completo</option>
                            <option value="mestrado incompleto" <c:if test="${renda.qt18_Escolaridade == 'mestrado incompleto'}"> selected</c:if>>mestrado incompleto</option>
                            <option value="mestrado completo" <c:if test="${renda.qt18_Escolaridade == 'mestrado completo'}"> selected</c:if>>mestrado completo</option>
                            <option value="doutorado incompleto" <c:if test="${renda.qt18_Escolaridade == 'doutorado incompleto'}"> selected</c:if>>doutorado incompleto</option>
                            <option value="doutorado completo" <c:if test="${renda.qt18_Escolaridade == 'doutorado completo'}"> selected</c:if>>doutorado completo</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Situação trabalhista do familiar:
                        <select name="opt_qt18_Trabalho" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${renda.qt18_Trabalho == null}"> selected</c:if>> </option>
                            <option value="não trabalha" <c:if test="${renda.qt18_Trabalho == 'não trabalha'}"> selected</c:if>>não trabalha</option>
                            <option value="desempregado" <c:if test="${renda.qt18_Trabalho == 'desempregado'}"> selected</c:if>>desempregado</option>
                            <option value="trabalha com carteira assinada" <c:if test="${renda.qt18_Trabalho == 'trabalha com carteira assinada'}"> selected</c:if>>trabalha com carteira assinada</option>
                            <option value="servidor público" <c:if test="${renda.qt18_Trabalho == 'servidor público'}"> selected</c:if>>servidor público</option>
                            <option value="trabalha com atividade rural" <c:if test="${renda.qt18_Trabalho == 'trabalha com atividade rural'}"> selected</c:if>>trabalha com atividade rural</option>
                            <option value="aposentado" <c:if test="${renda.qt18_Trabalho == 'aposentado'}"> selected</c:if>>aposentado</option>
                            <option value="pensionista" <c:if test="${renda.qt18_Trabalho == 'pensionista'}"> selected</c:if>>pensionista</option>
                            <option value="aposentado e pensionista" <c:if test="${renda.qt18_Trabalho == 'aposentado e pensionista'}"> selected</c:if>>aposentado e pensionista</option>
                            <option value="recebe auxílio doença ou seguro acidente" <c:if test="${renda.qt18_Trabalho == 'recebe auxílio doença ou seguro acidente'}"> selected</c:if>>recebe auxílio doença ou seguro acidente</option>
                            <option value="trabalha como autônomo ou profissional liberal" <c:if test="${renda.qt18_Trabalho == 'trabalha como autônomo ou profissional liberal'}"> selected</c:if>>trabalha como autônomo ou profissional liberal</option>
                            <option value="microempreendedor individual" <c:if test="${renda.qt18_Trabalho == 'microempreendedor individual'}"> selected</c:if>>microempreendedor individual</option>
                            <option value="trabalha na economia informal" <c:if test="${renda.qt18_Trabalho == 'trabalha na economia informal'}"> selected</c:if>>trabalha na economia informal</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ocupação do familiar:
                        <input type="text" name="txt_qt18_Ocupacao" value="${renda.qt18_Ocupacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>Renda bruta mensal do familiar (não colocar centavos):
                        <input type="text" size=8 name="txt_qt18_RendaBruta" value="${renda.qt18_RendaBruta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txt_qt18_Nome.value == ""){
                    mensagem = mensagem + "Informe o nome do familiar\n";
                }
                if (form.txtCodRenda.value == ""){
                    mensagem = mensagem + "Informe o número de sequência\n";
                }
                if (form.txt_qt18_DataNasc.value == ""){
                    mensagem = mensagem + "Informe a Data de Nascimento do familiar\n";
                }
                if (form.txt_qt18_Parentesco.value == ""){
                    mensagem = mensagem + "Informe o parentesco do familiar\n";
                }
                if (form.opt_qt18_EstadoCivil.value == ""){
                    mensagem = mensagem + "Selecione o estado civil do familiar\n";
                }
                if (form.opt_qt18_Escolaridade.value == ""){
                    mensagem = mensagem + "Selecione a escolaridade do familiar\n";
                }
                if (form.opt_qt18_Trabalho.value == ""){
                    mensagem = mensagem + "Selecione a situação de trabalho do familiar\n";
                }
                if (form.txt_qt18_Ocupacao.value == ""){
                    mensagem = mensagem + "Informe a ocupação do familiar\n";
                }
                if (form.txt_qt18_RendaBruta.value == ""){
                    form.txt_qt18_RendaBruta.value = 0.0;
                }
                if (form.txt_qt18_RendaBruta.value < 0.0){
                    mensagem = mensagem + "O valor da renda bruta não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt18_RendaBruta.value)){
                    mensagem = mensagem + "O valor da renda bruta deve ser numérico\n";
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
