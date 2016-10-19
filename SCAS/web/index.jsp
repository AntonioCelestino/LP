<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IF Sudeste MG</title>
        <meta name="author" content="Antonio & Nathan" />
        <meta name="keywords" content="bolsa, IF Sudeste" />
        <meta charset="UTF-8" />
    </head>
    <body>
        <h1>Login</h1>
        <form name="input" action="LoginController" method="post" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Login: <input type="text" name="txtLogin" size="35" /></td>
                </tr>
                <tr>
                    <td>Senha: <input type="password" name="txtSenha" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">            
            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtLogin.value == ""){
                    mensagem = mensagem + "Informe o Login\n";
                }                             
                if (form.txtSenha.value == ""){
                    mensagem = mensagem + "Informe a Senha\n";
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