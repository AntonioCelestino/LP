<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Usuário</title>
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
        <h1>Manter Usuário - ${operacao}</h1>
        <form action="ManterUsuarioController?acao=confirmarOperacao&operacao=${operacao}&codUsuarioLogado=${codUsuarioLogado}" method="post" name="frmManterUsuario" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código: <input type="text" name="txtCodUsuario" value="${usuario.codUsuario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Data de Nascimento: <input type="text" name="txtDataNasc" maxlength="10" placeholder="dd/mm/aaaa" OnKeyPress="formatar('##/##/####', this)" value="${usuario.dataNasc}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome Completo: <input size="40" type="text" name="txtNome" placeholder="(Não abrevie nomes)" value="${usuario.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Sexo:
                        <input type="radio" name="txtSexo" value="Masculino" <c:if test="${usuario.sexo == 'Masculino'}"> checked</c:if>>Masculino
                        <input type="radio" name="txtSexo" value="Feminino" <c:if test="${usuario.sexo == 'Feminino'}"> checked</c:if>>Feminino
                    </td>
                </tr>
                <tr>
                    <td>CPF: <input type="text" name="txtCPF" maxlength="14" placeholder="000.000.000-00" OnKeyPress="formatar('###.###.###-##', this)" value="${usuario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Carteira de Identidade (RG): <input type="text" name="txtIdentidade" maxlength="14" value="${usuario.identidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Telefone Fixo: <input type="text" name="txtTelefoneFixo" maxlength="12" placeholder="Ex: 32-1111-1111" OnKeyPress="formatar('##-####-####', this)" value="${usuario.telefoneFixo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Telefone Celular: <input type="text" name="txtTelefoneCelular" maxlength="13" placeholder="Ex: 32-99999-9999" OnKeyPress="formatar('##-#####-####', this)" value="${usuario.telefoneCelular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Email: <input type="text" name="txtEmail" value="${usuario.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>
                    Endereço: <input size="30" type="text" name="txtEndereco" placeholder="(Rua, Avenida, Praça, Travessa, etc)" value="${usuario.endereco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    Número: <input size="3" type="text" name="txtNumero" value="${usuario.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    Complemento: <input size="3" type="text" name="txtComplemento" value="${usuario.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                    Bairro: <input type="text" name="txtBairro" value="${usuario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>  
                    CEP: <input type="text" name="txtCep" maxlength="10" placeholder="00.000-000" OnKeyPress="formatar('##.###-###', this)" value="${usuario.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                    Cidade: <input type="text" name="txtCidade" value="${usuario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                    UF: <input size="5" type="text" name="txtUF" maxlength="2" placeholder="Ex: MG" value="${usuario.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr>
                    <td><h3>Criar nova Senha</h3></td>
                </tr>
                <tr>
                    <td>Login: <input type="text" name="txtLogin" value="${usuario.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Senha Anterior: <input type="password" name="txtSenhaAnterior" <c:if test="${operacao != 'Editar'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nova Senha: <input type="password" name="txtSenha" value="${usuario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodUsuario.value == ""){
                    mensagem = mensagem + "Informe o Código do Usuário\n";
                }                             
                if (form.txtDataNasc.value == ""){
                    mensagem = mensagem + "Informe a Data de Nascimento do Usuário\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe o Nome do Usuário\n";
                }
                if (form.txtSexo.value == ""){
                    mensagem = mensagem + "Informe o Sexo do Usuário\n";
                }
                if (form.txtCPF.value == ""){
                    mensagem = mensagem + "Informe o CPF do Usuário\n";
                }
                if (form.txtIdentidade.value == ""){
                    mensagem = mensagem + "Informe o RG do Usuário\n";
                }
                if (form.txtTelefoneFixo.value == ""){
                    mensagem = mensagem + "Informe o Telefone Fixo do Usuário\n";
                }
                if (form.txtTelefoneCelular.value == ""){
                    mensagem = mensagem + "Informe o Telefone Celular do Usuário\n";
                }
                if (form.txtEmail.value == ""){
                    mensagem = mensagem + "Informe o E-mail do Usuário\n";
                }
                if (form.txtEndereco.value == ""){
                    mensagem = mensagem + "Informe o nome da Rua do Usuário\n";
                }
                if (form.txtNumero.value == ""){
                    mensagem = mensagem + "Informe o número do Endereço do Usuário\n";
                }
                if (form.txtBairro.value == ""){
                    mensagem = mensagem + "Informe o Bairro do Usuário\n";
                }
                if (form.txtCep.value == ""){
                    mensagem = mensagem + "Informe o CEP do Usuário\n";
                }
                if (form.txtCidade.value == ""){
                    mensagem = mensagem + "Informe a Cidade do Usuário\n";
                }
                if (form.txtUF.value == ""){
                    mensagem = mensagem + "Informe o UF do Usuário\n";
                }
                if (form.txtLogin.value == ""){
                    mensagem = mensagem + "Informe um Login para o Usuário\n";
                }
                if (form.txtSenha.value == ""){
                    mensagem = mensagem + "Informe uma nova Senha para o Usuário\n";
                }
                if (!campoNumerico(form.txtCodUsuario.value)){
                    mensagem = mensagem + "Código do Usuário deve ser somente numérico\n";
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
