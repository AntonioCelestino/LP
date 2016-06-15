<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Formulario</title>
    </head>
    <body>
        <h1>Formulário Sócioeconômico - ${operacao}</h1>
        <form action="ManterFormularioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFormulario" onsubmit="return validarFormulario(this)">
            <table>
                <tr> 
                    <td><hr />Confirme o nome do aluno (nome | matrícula):
                        <select name="optAluno" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${formulario.aluno.matricula == null}"> selected</c:if>> </option>  
                            <c:forEach items="${alunos}" var="aluno">
                                <option value="${aluno.matricula}" <c:if test="${formulario.aluno.matricula == aluno.matricula}"> selected</c:if>>${aluno.usuario.nome} | ${aluno.matricula}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />Escolha em qual Seleção quer concorrer:
                        <select name="optSelecao" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${formulario.selecao.codSelecao == null}"> selected</c:if>> </option>  
                            <c:forEach items="${selecoes}" var="selecao">
                                <option value="${selecao.codSelecao}" <c:if test="${formulario.selecao.codSelecao == selecao.codSelecao}"> selected</c:if>>${selecao.numeroEdital} | ${selecao.modalidade.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 01:</td>
                </tr>
                <tr>
                    <td>Você ou alguém da sua família é ou já foi atendido em algum programa de Assistência Estudantil do IF Sudeste MG ou do antigo CTU?
                        <br /><input type="radio" name="opt_qt01_Resposta" value="Sim" onclick="if(document.getElementById('qt01_Nome').disabled==true){document.getElementById('qt01_Nome').disabled=false}; if(document.getElementById('qt01_Parentesco').disabled==true){document.getElementById('qt01_Parentesco').disabled=false}; if(document.getElementById('qt01_Programa').disabled==true){document.getElementById('qt01_Programa').disabled=false}; if(document.getElementById('qt01_Ano').disabled==true){document.getElementById('qt01_Ano').disabled=false}" <c:if test="${formulario.qt01_Resposta == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt01_Resposta" value="Não" onclick="if(document.getElementById('qt01_Nome').disabled==false){document.getElementById('qt01_Nome').disabled=true}; if(document.getElementById('qt01_Parentesco').disabled==false){document.getElementById('qt01_Parentesco').disabled=true}; if(document.getElementById('qt01_Programa').disabled==false){document.getElementById('qt01_Programa').disabled=true}; if(document.getElementById('qt01_Ano').disabled==false){document.getElementById('qt01_Ano').disabled=true}" <c:if test="${formulario.qt01_Resposta == 'Não'}"> checked</c:if>>Não
                        <br />Se Sim, informe:
                        <br />Quem&nbsp;<input type="text" id="qt01_Nome" name="txt_qt01_Nome" value="${formulario.qt01_Nome}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />Parentesco&nbsp;<input type="text" id="qt01_Parentesco" name="txt_qt01_Parentesco" value="${formulario.qt01_Parentesco}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />Programa&nbsp;<input type="text" id="qt01_Programa" name="txt_qt01_Programa" value="${formulario.qt01_Programa}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />Ano&nbsp;<input type="text" id="qt01_Ano" name="txt_qt01_Ano" value="${formulario.qt01_Ano}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 02:</td>
                </tr>
                <tr>
                    <td>
                        Programa/atendimento solicitado
                        <br />Alimentação:&nbsp;
                        <input type="radio" name="opt_qt02_Alimentacao" value="Sim" <c:if test="${formulario.qt02_Alimentacao == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt02_Alimentacao" value="Não" <c:if test="${formulario.qt02_Alimentacao == 'Não'}"> checked</c:if>>Não
                        <br />Manutenção:&nbsp;
                        <input type="radio" name="opt_qt02_Manutencao" value="Sim" <c:if test="${formulario.qt02_Manutencao == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt02_Manutencao" value="Não" <c:if test="${formulario.qt02_Manutencao == 'Não'}"> checked</c:if>>Não
                        <br />Moradia:&nbsp;
                        <input type="radio" name="opt_qt02_Moradia" value="Sim" <c:if test="${formulario.qt02_Moradia == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt02_Moradia" value="Não" <c:if test="${formulario.qt02_Moradia == 'Não'}"> checked</c:if>>Não
                        <br />Transporte:&nbsp;
                        <input type="radio" name="opt_qt02_Transporte" value="Sim" <c:if test="${formulario.qt02_Transporte == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt02_Transporte" value="Não" <c:if test="${formulario.qt02_Transporte == 'Não'}"> checked</c:if>>Não
                        <br />Outro:&nbsp;
                        <input type="text" name="txt_qt02_Outro" value="${formulario.qt02_Outro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 03:</td>
                </tr>
                <tr>
                    <td>Qual o principal meio de transporte utilizado para chegar ao IF Sudeste MG?
                        <br /><input type="radio" name="opt_qt03_Transporte" value="a pé / de bicicleta" onclick="if(document.getElementById('qt03_Tempo').disabled==true){document.getElementById('qt03_Tempo').disabled=false}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'a pé / de bicicleta'}"> checked</c:if>>A pé / de bicicleta - Tempo gasto no trajeto&nbsp;<input type="text" id="qt03_Tempo" name="txt_qt03_Tempo" value="${formulario.qt03_Tempo}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt03_Transporte" value="carona" onclick="if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'carona'}"> checked</c:if>>Carona
                        <br /><input type="radio" name="opt_qt03_Transporte" value="transporte coletivo com recursos próprios" onclick="if(document.getElementById('qt03_ValorGastoDiario').disabled==true){document.getElementById('qt03_ValorGastoDiario').disabled=false}; if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'transporte coletivo com recursos próprios'}"> checked</c:if>>Transporte coletivo com recursos próprios - Gasto diário (R$):&nbsp;<input type="text" id="qt03_ValorGastoDiario" name="txt_qt03_ValorGastoDiario" value="${formulario.qt03_ValorGastoDiario}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt03_Transporte" value="transporte locado" onclick="if(document.getElementById('qt03_ValorGastoMensal').disabled==true){document.getElementById('qt03_ValorGastoMensal').disabled=false}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'transporte locado'}"> checked</c:if>>Transporte locado - Gasto mensal (R$):&nbsp;<input type="text" id="qt03_ValorGastoMensal" name="txt_qt03_ValorGastoMensal" value="${formulario.qt03_ValorGastoMensal}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt03_Transporte" value="transporte gratuito de Prefeitura / Escola" onclick="if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'transporte gratuito de Prefeitura / Escola'}"> checked</c:if>>Transporte gratuito de Prefeitura / Escola
                        <br /><input type="radio" name="opt_qt03_Transporte" value="transporte próprio" onclick="if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Outro').disabled==false){document.getElementById('qt03_Outro').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'transporte próprio'}"> checked</c:if>>Transporte próprio
                        <br /><input type="radio" name="opt_qt03_Transporte" value="Outro" onclick="if(document.getElementById('qt03_Outro').disabled==true){document.getElementById('qt03_Outro').disabled=false}; if(document.getElementById('qt03_ValorGastoDiario').disabled==false){document.getElementById('qt03_ValorGastoDiario').disabled=true}; if(document.getElementById('qt03_ValorGastoMensal').disabled==false){document.getElementById('qt03_ValorGastoMensal').disabled=true}; if(document.getElementById('qt03_Tempo').disabled==false){document.getElementById('qt03_Tempo').disabled=true}" <c:if test="${formulario.qt03_Transporte == 'Outro'}"> checked</c:if>>Outro - Especifique&nbsp;<input type="text" id="qt03_Outro" name="txt_qt03_Outro" value="${formulario.qt03_Outro}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 04:</td>
                </tr>
                <tr>
                    <td>A instituição de ensino na qual cursou o ensino fundamental é:<br />
                        <select name="opt_qt04_InstituicaoEnsinoFundamental" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == null}"> selected</c:if>> </option>
                            <option value="pública" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == 'pública'}"> selected</c:if>>pública</option>
                            <option value="particular" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == 'particular'}"> selected</c:if>>particular</option>
                            <option value="parte em pública e depois em particular" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == 'parte em pública e depois em particular'}"> selected</c:if>>parte em pública e depois em particular</option>
                            <option value="parte em particular e depois em pública" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == 'parte em particular e depois em pública'}"> selected</c:if>>parte em particular e depois em pública</option>
                            <option value="particular com bolsa" <c:if test="${formulario.qt04_InstituicaoEnsinoFundamental == 'particular com bolsa'}"> selected</c:if>>particular com bolsa</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 05:</td>
                </tr>
                <tr>
                    <td>A instituição de ensino na qual cursou o ensino médio é:<br />
                        <select name="opt_qt05_InstituicaoEnsinoMedio" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == null}"> selected</c:if>> </option>
                            <option value="pública" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == 'pública'}"> selected</c:if>>pública</option>
                            <option value="particular" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == 'particular'}"> selected</c:if>>particular</option>
                            <option value="parte em pública e depois em particular" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == 'parte em pública e depois em particular'}"> selected</c:if>>parte em pública e depois em particular</option>
                            <option value="parte em particular e depois em pública" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == 'parte em particular e depois em pública'}"> selected</c:if>>parte em particular e depois em pública</option>
                            <option value="particular com bolsa" <c:if test="${formulario.qt05_InstituicaoEnsinoMedio == 'particular com bolsa'}"> selected</c:if>>particular com bolsa</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 06:</td>
                </tr>
                <tr>
                    <td>Você está inserido em alguma atividade acadêmica remunerada?
                        <br /><input type="radio" name="opt_qt06_AtividadeRemunerada" value="Sim, estágio" onclick="if(document.getElementById('qt06_ValorBolsaEstagio').disabled==true){document.getElementById('qt06_ValorBolsaEstagio').disabled=false}; if(document.getElementById('qt06_ProjetoIniciacao').disabled==false){document.getElementById('qt06_ProjetoIniciacao').disabled=true}; if(document.getElementById('qt06_ValorBolsaIniciacao').disabled==false){document.getElementById('qt06_ValorBolsaIniciacao').disabled=true}; if(document.getElementById('qt06_ProjetoTreinamento').disabled==false){document.getElementById('qt06_ProjetoTreinamento').disabled=true}; if(document.getElementById('qt06_ValorBolsaTreinamento').disabled==false){document.getElementById('qt06_ValorBolsaTreinamento').disabled=true}; if(document.getElementById('qt06_Outro').disabled==false){document.getElementById('qt06_Outro').disabled=true}; if(document.getElementById('qt06_ValorBolsaOutro').disabled==false){document.getElementById('qt06_ValorBolsaOutro').disabled=true}" <c:if test="${formulario.qt06_AtividadeRemunerada == 'Sim, estágio'}"> checked</c:if>>Sim, estágio - Valor mensal (R$):&nbsp;<input type="text" id="qt06_ValorBolsaEstagio" name="txt_qt06_ValorBolsaEstagio" value="${formulario.qt06_ValorBolsaEstagio}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt06_AtividadeRemunerada" value="Sim, iniciação científica" onclick="if(document.getElementById('qt06_ValorBolsaEstagio').disabled==false){document.getElementById('qt06_ValorBolsaEstagio').disabled=true}; if(document.getElementById('qt06_ProjetoIniciacao').disabled==true){document.getElementById('qt06_ProjetoIniciacao').disabled=false}; if(document.getElementById('qt06_ValorBolsaIniciacao').disabled==true){document.getElementById('qt06_ValorBolsaIniciacao').disabled=false}; if(document.getElementById('qt06_ProjetoTreinamento').disabled==false){document.getElementById('qt06_ProjetoTreinamento').disabled=true}; if(document.getElementById('qt06_ValorBolsaTreinamento').disabled==false){document.getElementById('qt06_ValorBolsaTreinamento').disabled=true}; if(document.getElementById('qt06_Outro').disabled==false){document.getElementById('qt06_Outro').disabled=true}; if(document.getElementById('qt06_ValorBolsaOutro').disabled==false){document.getElementById('qt06_ValorBolsaOutro').disabled=true}" <c:if test="${formulario.qt06_AtividadeRemunerada == 'Sim, iniciação científica'}"> checked</c:if>>Sim, iniciação científica - Qual:&nbsp;<input type="text" id="qt06_ProjetoIniciacao" name="txt_qt06_ProjetoIniciacao" value="${formulario.qt06_ProjetoIniciacao}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp;e&nbsp;Valor mensal (R$):&nbsp;<input type="text" id="qt06_ValorBolsaIniciacao" name="txt_qt06_ValorBolsaIniciacao" value="${formulario.qt06_ValorBolsaIniciacao}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt06_AtividadeRemunerada" value="Sim, treinamento profissional" onclick="if(document.getElementById('qt06_ValorBolsaEstagio').disabled==false){document.getElementById('qt06_ValorBolsaEstagio').disabled=true}; if(document.getElementById('qt06_ProjetoIniciacao').disabled==false){document.getElementById('qt06_ProjetoIniciacao').disabled=true}; if(document.getElementById('qt06_ValorBolsaIniciacao').disabled==false){document.getElementById('qt06_ValorBolsaIniciacao').disabled=true}; if(document.getElementById('qt06_ProjetoTreinamento').disabled==true){document.getElementById('qt06_ProjetoTreinamento').disabled=false}; if(document.getElementById('qt06_ValorBolsaTreinamento').disabled==true){document.getElementById('qt06_ValorBolsaTreinamento').disabled=false}; if(document.getElementById('qt06_Outro').disabled==false){document.getElementById('qt06_Outro').disabled=true}; if(document.getElementById('qt06_ValorBolsaOutro').disabled==false){document.getElementById('qt06_ValorBolsaOutro').disabled=true}" <c:if test="${formulario.qt06_AtividadeRemunerada == 'Sim, treinamento profissional'}"> checked</c:if>>Sim, treinamento profissional - Qual:&nbsp;<input type="text" id="qt06_ProjetoTreinamento" name="txt_qt06_ProjetoTreinamento" value="${formulario.qt06_ProjetoTreinamento}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp;e&nbsp;Valor mensal (R$):&nbsp;<input type="text" id="qt06_ValorBolsaTreinamento" name="txt_qt06_ValorBolsaTreinamento" value="${formulario.qt06_ValorBolsaTreinamento}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt06_AtividadeRemunerada" value="Sim, outra" onclick="if(document.getElementById('qt06_ValorBolsaEstagio').disabled==false){document.getElementById('qt06_ValorBolsaEstagio').disabled=true}; if(document.getElementById('qt06_ProjetoIniciacao').disabled==false){document.getElementById('qt06_ProjetoIniciacao').disabled=true}; if(document.getElementById('qt06_ValorBolsaIniciacao').disabled==false){document.getElementById('qt06_ValorBolsaIniciacao').disabled=true}; if(document.getElementById('qt06_ProjetoTreinamento').disabled==false){document.getElementById('qt06_ProjetoTreinamento').disabled=true}; if(document.getElementById('qt06_ValorBolsaTreinamento').disabled==false){document.getElementById('qt06_ValorBolsaTreinamento').disabled=true}; if(document.getElementById('qt06_Outro').disabled==true){document.getElementById('qt06_Outro').disabled=false}; if(document.getElementById('qt06_ValorBolsaOutro').disabled==true){document.getElementById('qt06_ValorBolsaOutro').disabled=false}" <c:if test="${formulario.qt06_AtividadeRemunerada == 'Sim, outra'}"> checked</c:if>>Sim, outra - Qual:&nbsp;<input type="text" id="qt06_Outro" name="txt_qt06_Outro" value="${formulario.qt06_Outro}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp;e&nbsp;Valor mensal (R$):&nbsp;<input type="text" id="qt06_ValorBolsaOutro" name="txt_qt06_ValorBolsaOutro" value="${formulario.qt06_ValorBolsaOutro}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt06_AtividadeRemunerada" value="Não" onclick="if(document.getElementById('qt06_ValorBolsaEstagio').disabled==false){document.getElementById('qt06_ValorBolsaEstagio').disabled=true}; if(document.getElementById('qt06_ProjetoIniciacao').disabled==false){document.getElementById('qt06_ProjetoIniciacao').disabled=true}; if(document.getElementById('qt06_ValorBolsaIniciacao').disabled==false){document.getElementById('qt06_ValorBolsaIniciacao').disabled=true}; if(document.getElementById('qt06_ProjetoTreinamento').disabled==false){document.getElementById('qt06_ProjetoTreinamento').disabled=true}; if(document.getElementById('qt06_ValorBolsaTreinamento').disabled==false){document.getElementById('qt06_ValorBolsaTreinamento').disabled=true}; if(document.getElementById('qt06_Outro').disabled==false){document.getElementById('qt06_Outro').disabled=true}; if(document.getElementById('qt06_ValorBolsaOutro').disabled==false){document.getElementById('qt06_ValorBolsaOutro').disabled=true}" <c:if test="${formulario.qt06_AtividadeRemunerada == 'Não'}"> checked</c:if>>Não
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 07:</td>
                </tr>
                <tr>
                    <td>Você trabalha atualmente em alguma outra atividade remunerada?<br />
                        <input type="radio" name="opt_qt07_TrabalhoRemunerado" value="Sim" onclick="if(document.getElementById('qt07_HorasSemanais').disabled==true){document.getElementById('qt07_HorasSemanais').disabled=false}; if(document.getElementById('qt07_Salario').disabled==true){document.getElementById('qt07_Salario').disabled=false}" <c:if test="${formulario.qt07_TrabalhoRemunerado == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt07_TrabalhoRemunerado" value="Não" onclick="if(document.getElementById('qt07_HorasSemanais').disabled==false){document.getElementById('qt07_HorasSemanais').disabled=true}; if(document.getElementById('qt07_Salario').disabled==false){document.getElementById('qt07_Salario').disabled=true}" <c:if test="${formulario.qt07_TrabalhoRemunerado == 'Não'}"> checked</c:if>>Não
                        <br />Se Sim, informe:
                        <br />Qual a carga horária mensal?&nbsp;<input type="text" id="qt07_HorasSemanais" name="txt_qt07_HorasSemanais" value="${formulario.qt07_HorasSemanais}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />Qual o salário mensal? - Valor R$:&nbsp;<input type="text" id="qt07_Salario" name="txt_qt07_Salario" value="${formulario.qt07_Salario}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 08:</td>
                </tr>
                <tr>
                    <td>Qual a sua condição de manutenção?
                        <br /><input type="radio" name="opt_qt08_Manutencao" value="Sou responsável pelo meu próprio sustento" onclick="if(document.getElementById('qt08_Outra').disabled==false){document.getElementById('qt08_Outra').disabled=true}" <c:if test="${formulario.qt08_Manutencao == 'Sou responsável pelo meu próprio sustento'}"> checked</c:if>>Sou responsável pelo meu próprio sustento
                        <br /><input type="radio" name="opt_qt08_Manutencao" value="Sou sustentado pelos meus pais" onclick="if(document.getElementById('qt08_Outra').disabled==false){document.getElementById('qt08_Outra').disabled=true}" <c:if test="${formulario.qt08_Manutencao == 'Sou sustentado pelos meus pais'}"> checked</c:if>>Sou sustentado pelos meus pais
                        <br /><input type="radio" name="opt_qt08_Manutencao" value="Recebo ajuda de parentes" onclick="if(document.getElementById('qt08_Outra').disabled==false){document.getElementById('qt08_Outra').disabled=true}" <c:if test="${formulario.qt08_Manutencao == 'Recebo ajuda de parentes'}"> checked</c:if>>Recebo ajuda de parentes
                        <br /><input type="radio" name="opt_qt08_Manutencao" value="Tenho bolsa de estudo" onclick="if(document.getElementById('qt08_Outra').disabled==false){document.getElementById('qt08_Outra').disabled=true}" <c:if test="${formulario.qt08_Manutencao == 'Tenho bolsa de estudo'}"> checked</c:if>>Tenho bolsa de estudo
                        <br /><input type="radio" name="opt_qt08_Manutencao" value="Outra" onclick="if(document.getElementById('qt08_Outra').disabled==true){document.getElementById('qt08_Outra').disabled=false}" <c:if test="${formulario.qt08_Manutencao == 'Outra'}"> checked</c:if>>Outra - informe qual:&nbsp;<input type="text" id="qt08_Outra" name="txt_qt08_Outra" value="${formulario.qt08_Outra}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 09:</td>
                </tr>
                <tr>
                    <td>Você mora:
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Sozinho" onclick="if(document.getElementById('qt09_Outra').disabled==false){document.getElementById('qt09_Outra').disabled=true}" <c:if test="${formulario.qt09_Moradia == 'Sozinho'}"> checked</c:if>>Sozinho
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Com pais" onclick="if(document.getElementById('qt09_Outra').disabled==false){document.getElementById('qt09_Outra').disabled=true}" <c:if test="${formulario.qt09_Moradia == 'Com pais'}"> checked</c:if>>Com pais
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Com cônjuge/companheiro(a)" onclick="if(document.getElementById('qt09_Outra').disabled==false){document.getElementById('qt09_Outra').disabled=true}" <c:if test="${formulario.qt09_Moradia == 'Com cônjuge/companheiro(a)'}"> checked</c:if>>Com cônjuge/companheiro(a)
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Em casa de familiares ou amigos da família" onclick="if(document.getElementById('qt09_Outra').disabled==false){document.getElementById('qt09_Outra').disabled=true}" <c:if test="${formulario.qt09_Moradia == 'Em casa de familiares ou amigos da família'}"> checked</c:if>>Em casa de familiares ou amigos da família
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Em repúnlica/quarto/pensão/pensionato" onclick="if(document.getElementById('qt09_Outra').disabled==false){document.getElementById('qt09_Outra').disabled=true}" <c:if test="${formulario.qt09_Moradia == 'Em repúnlica/quarto/pensão/pensionato'}"> checked</c:if>>Em repúnlica/quarto/pensão/pensionato
                        <br /><input type="radio" name="opt_qt09_Moradia" value="Outra situação" onclick="if(document.getElementById('qt09_Outra').disabled==true){document.getElementById('qt09_Outra').disabled=false}" <c:if test="${formulario.qt09_Moradia == 'Outra situação'}"> checked</c:if>>Outra situação - informe qual:&nbsp;<input type="text" id="qt09_Outra" name="txt_qt09_Outra" value="${formulario.qt09_Outra}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 10:</td>
                </tr>
                <tr>
                    <td>Quem é(são) o(s) responsável(is) pela manutenção financeira do grupo familiar?
                        <br /><input type="radio" name="opt_qt10_ResponsavelFinanceiro" value="Pai e mãe" onclick="if(document.getElementById('qt10_Outros').disabled==false){document.getElementById('qt10_Outros').disabled=true}" <c:if test="${formulario.qt10_ResponsavelFinanceiro == 'Pai e mãe'}"> checked</c:if>>Pai e mãe
                        <br /><input type="radio" name="opt_qt10_ResponsavelFinanceiro" value="Um dos pais" onclick="if(document.getElementById('qt10_Outros').disabled==false){document.getElementById('qt10_Outros').disabled=true}" <c:if test="${formulario.qt10_ResponsavelFinanceiro == 'Um dos pais'}"> checked</c:if>>Um dos pais
                        <br /><input type="radio" name="opt_qt10_ResponsavelFinanceiro" value="Outros membros do grupo familiar" onclick="if(document.getElementById('qt10_Outros').disabled==false){document.getElementById('qt10_Outros').disabled=true}" <c:if test="${formulario.qt10_ResponsavelFinanceiro == 'Outros membros do grupo familiar'}"> checked</c:if>>Outros membros do grupo familiar
                        <br /><input type="radio" name="opt_qt10_ResponsavelFinanceiro" value="Próprio estudante" onclick="if(document.getElementById('qt10_Outros').disabled==false){document.getElementById('qt10_Outros').disabled=true}" <c:if test="${formulario.qt10_ResponsavelFinanceiro == 'Próprio estudante'}"> checked</c:if>>Próprio estudante
                        <br /><input type="radio" name="opt_qt10_ResponsavelFinanceiro" value="Outros" onclick="if(document.getElementById('qt10_Outros').disabled==true){document.getElementById('qt10_Outros').disabled=false}" <c:if test="${formulario.qt10_ResponsavelFinanceiro == 'Outros'}"> checked</c:if>>Outros - informe quem:&nbsp;<input type="text" id="qt10_Outros" name="txt_qt10_Outros" value="${formulario.qt10_Outros}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 11:</td>
                </tr>
                <tr>
                    <td>
                        O bairro e a casa onde mora a família tem:
                        <br />Rede de esgoto:&nbsp;
                        <input type="radio" name="opt_qt11_Esgoto" value="Sim" <c:if test="${formulario.qt11_Esgoto == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt11_Esgoto" value="Não" <c:if test="${formulario.qt11_Esgoto == 'Não'}"> checked</c:if>>Não
                        <br />Água tratada:&nbsp;
                        <input type="radio" name="opt_qt11_Agua" value="Sim" <c:if test="${formulario.qt11_Agua == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt11_Agua" value="Não" <c:if test="${formulario.qt11_Agua == 'Não'}"> checked</c:if>>Não
                        <br />Iluminação pública:&nbsp;
                        <input type="radio" name="opt_qt11_Iluminacao" value="Sim" <c:if test="${formulario.qt11_Iluminacao == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt11_Iluminacao" value="Não" <c:if test="${formulario.qt11_Iluminacao == 'Não'}"> checked</c:if>>Não
                        <br />Coleta de Lixo:&nbsp;
                        <input type="radio" name="opt_qt11_Lixo" value="Sim" <c:if test="${formulario.qt11_Lixo == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt11_Lixo" value="Não" <c:if test="${formulario.qt11_Lixo == 'Não'}"> checked</c:if>>Não
                        <br />Ruas pavimentadas:&nbsp;
                        <input type="radio" name="opt_qt11_Pavimentacao" value="Sim" <c:if test="${formulario.qt11_Pavimentacao == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt11_Pavimentacao" value="Não" <c:if test="${formulario.qt11_Pavimentacao == 'Não'}"> checked</c:if>>Não
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 12:</td>
                </tr>
                <tr>
                    <td>Sua família reside em:
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Vila ou aglomerado" onclick="if(document.getElementById('qt12_Outro').disabled==false){document.getElementById('qt12_Outro').disabled=true}" <c:if test="${formulario.qt12_Residencia == 'Vila ou aglomerado'}"> checked</c:if>>Vila ou aglomerado
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Bairro padrão popular" onclick="if(document.getElementById('qt12_Outro').disabled==false){document.getElementById('qt12_Outro').disabled=true}" <c:if test="${formulario.qt12_Residencia == 'Bairro padrão popular'}"> checked</c:if>>Bairro padrão popular
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Bairro padrão médio" onclick="if(document.getElementById('qt12_Outro').disabled==false){document.getElementById('qt12_Outro').disabled=true}" <c:if test="${formulario.qt12_Residencia == 'Bairro padrão médio'}"> checked</c:if>>Bairro padrão médio
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Bairro padrão alto e luxo" onclick="if(document.getElementById('qt12_Outro').disabled==false){document.getElementById('qt12_Outro').disabled=true}" <c:if test="${formulario.qt12_Residencia == 'Bairro padrão alto e luxo'}"> checked</c:if>>Bairro padrão alto e luxo
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Fora do perímetro urbano" onclick="if(document.getElementById('qt12_Outro').disabled==false){document.getElementById('qt12_Outro').disabled=true}" <c:if test="${formulario.qt12_Residencia == 'Fora do perímetro urbano'}"> checked</c:if>>Fora do perímetro urbano
                        <br /><input type="radio" name="opt_qt12_Residencia" value="Outro" onclick="if(document.getElementById('qt12_Outro').disabled==true){document.getElementById('qt12_Outro').disabled=false}" <c:if test="${formulario.qt12_Residencia == 'Outro'}"> checked</c:if>>Outro - especifique:&nbsp;<input type="text" id="qt12_Outro" name="txt_qt12_Outro" value="${formulario.qt12_Outro}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 13:</td>
                </tr>
                <tr>
                    <td>Sua família reside em imóvel:<br />
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Alugado" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==true){document.getElementById('qt13_ValorAluguel').disabled=false}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Alugado'}"> checked</c:if>>Alugado - Valor do aluguel (R$):&nbsp;<input type="text" id="qt13_ValorAluguel" name="txt_qt13_ValorAluguel" value="${formulario.qt13_ValorAluguel}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Próprio - já quitado" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Próprio - já quitado'}"> checked</c:if>>Próprio - já quitado
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Próprio - por herança" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Próprio - por herança'}"> checked</c:if>>Próprio - por herança
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Próprio - em pagamento" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==true){document.getElementById('qt13_ValorPrestacao').disabled=false}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Próprio - em pagamento'}"> checked</c:if>>Próprio - em pagamento - Valor da prestação (R$):&nbsp;<input type="text" id="qt13_ValorPrestacao" name="txt_qt13_ValorPrestacao" value="${formulario.qt13_ValorPrestacao}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Emprestado ou cedido" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==true){document.getElementById('qt13_Nome').disabled=false}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Emprestado ou cedido'}"> checked</c:if>>Emprestado ou cedido - Por quem?&nbsp;<input type="text" id="qt13_Nome" name="txt_qt13_Nome" value="${formulario.qt13_Nome}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Construído em lote de parente" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==false){document.getElementById('qt13_Outro').disabled=true}" <c:if test="${formulario.qt13_Imovel == 'Construído em lote de parente'}"> checked</c:if>>Construído em lote de parente
                        <br /><input type="radio" name="opt_qt13_Imovel" value="Outra situação" onclick="if(document.getElementById('qt13_ValorAluguel').disabled==false){document.getElementById('qt13_ValorAluguel').disabled=true}; if(document.getElementById('qt13_ValorPrestacao').disabled==false){document.getElementById('qt13_ValorPrestacao').disabled=true}; if(document.getElementById('qt13_Nome').disabled==false){document.getElementById('qt13_Nome').disabled=true}; if(document.getElementById('qt13_Outro').disabled==true){document.getElementById('qt13_Outro').disabled=false}" <c:if test="${formulario.qt13_Imovel == 'Outra situação'}"> checked</c:if>>Outra situação - Qual?&nbsp;<input type="text" id="qt13_Outro" name="txt_qt13_Outro" value="${formulario.qt13_Outro}" disabled="disabled" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 14:</td>
                </tr>
                <tr>
                    <td>
                        Marque a característica que melhor descreve a sua casa:
                        <br /><input type="radio" name="opt_qt14_Acabamento" value="Sim" <c:if test="${formulario.qt14_Acabamento == 'Sim'}"> checked</c:if>>Residência com acabamento
                        <br /><input type="radio" name="opt_qt14_Acabamento" value="Não" <c:if test="${formulario.qt14_Acabamento == 'Não'}"> checked</c:if>>Residência sem acabamento
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 15:</td>
                </tr>
                <tr>
                    <td>A família possui outros imóveis além do que habita? (lotes, sítios, fazendas, casa na praia, aptos, salas, barracões ou outros)<br />
                        <input type="radio" name="opt_qt15_OutrosImoveis" value="Sim" onclick="if(document.getElementById('qt15_DescricaoImoveis').disabled==true){document.getElementById('qt15_DescricaoImoveis').disabled=false}" <c:if test="${formulario.qt15_OutrosImoveis == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt15_OutrosImoveis" value="Não" onclick="if(document.getElementById('qt15_DescricaoImoveis').disabled==false){document.getElementById('qt15_DescricaoImoveis').disabled=true}" <c:if test="${formulario.qt15_OutrosImoveis == 'Não'}"> checked</c:if>>Não
                        <br /> Se sim - especifique tipo e local de cada imóvel
                        <br /><textarea rows="2" cols="100" id="qt15_DescricaoImoveis" name="txt_qt15_DescricaoImoveis" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>${formulario.qt15_DescricaoImoveis}</textarea>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 16</td>
                </tr>
                <tr>
                    <td>
                        Em relação à casa de sua família, especifique a quantidade de:
                        <br />01) Automóvel&nbsp;<input type="text" name="txt_qt16_QuantCarro" value="${formulario.qt16_QuantCarro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />02) Televisão&nbsp;<input type="text" name="txt_qt16_QuantTV" value="${formulario.qt16_QuantTV}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />03) Máquina de lavar roupa&nbsp;<input type="text" name="txt_qt16_QuantMaqLavar" value="${formulario.qt16_QuantMaqLavar}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />04) Geladeira&nbsp;<input type="text" name="txt_qt16_QuantGeladeira" value="${formulario.qt16_QuantGeladeira}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />05) TV a cabo&nbsp;<input type="text" name="txt_qt16_QuantTVCabo" value="${formulario.qt16_QuantTVCabo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />06) Computador&nbsp;<input type="text" name="txt_qt16_QuantComputador" value="${formulario.qt16_QuantComputador}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />07) Internet paga&nbsp;<input type="text" name="txt_qt16_QuantInternetPaga" value="${formulario.qt16_QuantInternetPaga}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />08) Empregada mensalista&nbsp;<input type="text" name="txt_qt16_QuantEmpregadaMensalista" value="${formulario.qt16_QuantEmpregadaMensalista}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />09) Empregada diarista&nbsp;<input type="text" name="txt_qt16_QuantEmpregadaDiarista" value="${formulario.qt16_QuantEmpregadaDiarista}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />10) Banheiro&nbsp;<input type="text" name="txt_qt16_QuantBanheiro" value="${formulario.qt16_QuantBanheiro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />11) Quarto&nbsp;<input type="text" name="txt_qt16_QuantQuarto" value="${formulario.qt16_QuantQuarto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 17:</td>
                </tr>
                <tr>
                    <td>Há problemas de saúde existentes entre as pessoas que moram com sua família, inclusive você?<br />
                        <input type="radio" name="opt_qt17_ProblemaSaude" value="Sim" <c:if test="${formulario.qt17_ProblemaSaude == 'Sim'}"> checked</c:if>>Sim
                        <input type="radio" name="opt_qt17_ProblemaSaude" value="Não" <c:if test="${formulario.qt17_ProblemaSaude == 'Não'}"> checked</c:if>>Não
                        <br/> Caso 'Sim' acesse no menu o item 'Manter Doença' depois de terminar e confirmar este formulário.
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 18:</td>
                </tr>
                <tr>
                    <td>
                        Outras rendas (dados referentes ao último mês):
                        <br />(lance os dados de sua família, considerando as pessoas mantidas pela mesma renda ou contribuintes com a renda familiar, inclusive o estudante)
                        <br />01) Aluguel(is) de imóvel(is) - Valor (R$):&nbsp;<input type="text" name="txt_qt18_AluguelImoveis" value="${formulario.qt18_AluguelImoveis}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />02) Pensão por morte - Valor (R$):&nbsp;<input type="text" name="txt_qt18_PensaoMorte" value="${formulario.qt18_PensaoMorte}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />03) Pensão alimentícia - Valor (R$):&nbsp;<input type="text" name="txt_qt18_PensaoAlimenticia" value="${formulario.qt18_PensaoAlimenticia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />04) Ajudas de terceiros - Valor (R$):&nbsp;<input type="text" name="txt_qt18_AjudaTerceiros" value="${formulario.qt18_AjudaTerceiros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />05) Benefícios sociais - Valor (R$):&nbsp;<input type="text" name="txt_qt18_BeneficiosSociais" value="${formulario.qt18_BeneficiosSociais}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />06) Outro - Qual?&nbsp;<input type="text" name="txt_qt18_NomeOutraRenda" value="${formulario.qt18_NomeOutraRenda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> - Valor (R$):&nbsp;<input type="text" name="txt_qt18_OutraRenda" value="${formulario.qt18_OutraRenda}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />Total da renda familiar (R$)&nbsp;<input type="text" name="txt_qt18_TotalRenda" value="${formulario.qt18_TotalRenda}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if>>
                        <br />Número total de pessoas da família que vivem dessa renda (incluindo o estudante)&nbsp;<input type="text" name="txt_qt18_NumeroResidentes" value="${formulario.qt18_NumeroResidentes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />OBS.: Acesse no menu o item 'Manter Renda' depois de terminar e confirmar este formulário, para lançar a renda de cada membro da família.
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 19:</td>
                </tr>
                <tr>
                    <td>
                        Despesa familiar mensal:
                        <br />(excluir despesas do estudante do IF Sudeste MG que reside fora)
                        <br />01) Água - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorAgua" value="${formulario.qt19_ValorAgua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />02) Luz - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorLuz" value="${formulario.qt19_ValorLuz}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />03) Telefone - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorTelefone" value="${formulario.qt19_ValorTelefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />04) Condomínio - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorCondominio" value="${formulario.qt19_ValorCondominio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />05) Mensalidade escolar - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorMensalidadeEscolar" value="${formulario.qt19_ValorMensalidadeEscolar}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />06) Alimentação - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorAlimentacao" value="${formulario.qt19_ValorAlimentacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />07) Saúde - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorSaude" value="${formulario.qt19_ValorSaude}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />08) Transporte - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorTransporte" value="${formulario.qt19_ValorTransporte}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />09) IPTU anual - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorIptuAnual" value="${formulario.qt19_ValorIptuAnual}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />10) Aluguel / prestação casa - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorAluguel" value="${formulario.qt19_ValorAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />11) Pensão alimentícia - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorPensao" value="${formulario.qt19_ValorPensao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />11) Outros - Valor (R$):&nbsp;<input type="text" name="txt_qt19_ValorOutros" value="${formulario.qt19_ValorOutros}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 20:</td>
                </tr>
                <tr>
                    <td>
                        Despesa do estudante do IF Sudeste MG com moradia:
                        <br />(registrar apenas a parcela que cabe ao estudante, no caso de república ou similar)
                        <br />01) Água - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorAgua" value="${formulario.qt20_ValorAgua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />02) Luz - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorLuz" value="${formulario.qt20_ValorLuz}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />03) Telefone - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorTelefone" value="${formulario.qt20_ValorTelefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />04) Condomínio - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorCondominio" value="${formulario.qt20_ValorCondominio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />05) Aluguel - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorAluguel" value="${formulario.qt20_ValorAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <br />06) IPTU anual - Valor (R$):&nbsp;<input type="text" name="txt_qt20_ValorIptuAnual" value="${formulario.qt20_ValorIptuAnual}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr> 
                    <td><hr />QUESTÃO 21:</td>
                </tr>
                <tr>
                    <td>
                        Informe ou esclareça sobre dados não contemplados neste formulário ou situações especiais que julgar conveniente:
                        <br /><textarea rows="5" cols="100" name="txt_qt21_Esclarecimentos" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>${formulario.qt21_Esclarecimentos}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <hr />TERMO DE COMPROMISSO
                        <br /><input type="checkbox" name="termo" value="Sim" />Declaro que as informações prestadas correspondem à realidade. Estou ciente de que a não veracidade das respostas desclassificará o estudante.
                    </td>
                </tr>
                <tr>
                    <td><hr /><input type="submit" name="btnConfirmar" value="Confirmar"></td>
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
                if (form.optAluno.value == "0"){
                    mensagem = mensagem + "Selecione um Aluno\n";
                }
                if (form.optSelecao.value == "0"){
                    mensagem = mensagem + "Selecione uma Seleção\n";
                }
                if (form.opt_qt01_Resposta.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não na Questão 01\n";
                }                             
                if (form.opt_qt02_Alimentacao.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Alimentação na Questão 02\n";
                }
                if (form.opt_qt02_Manutencao.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Manutenção na Questão 02\n";
                }
                if (form.opt_qt02_Moradia.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Moradia na Questão 02\n";
                }
                if (form.opt_qt02_Transporte.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Transporte na Questão 02\n";
                }
                if (form.opt_qt03_Transporte.value == ""){
                    mensagem = mensagem + "Selecione um Transporte na Questão 03\n";
                }
                if (form.txt_qt03_ValorGastoDiario.value == ""){
                    form.txt_qt03_ValorGastoDiario.value = 0.0;
                }
                if (form.txt_qt03_ValorGastoDiario.value < 0.0){
                    mensagem = mensagem + "O gasto diário na Questão 03 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt03_ValorGastoDiario.value)){
                    mensagem = mensagem + "O gasto diário na Questão 03 deve ser numérico\n";
                }
                if (form.txt_qt03_ValorGastoMensal.value == ""){
                    form.txt_qt03_ValorGastoMensal.value = 0.0;
                }
                if (form.txt_qt03_ValorGastoMensal.value < 0.0){
                    mensagem = mensagem + "O gasto mensal na Questão 03 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt03_ValorGastoMensal.value)){
                    mensagem = mensagem + "O gasto mensal na Questão 03 deve ser numérico\n";
                }
                if (form.opt_qt04_InstituicaoEnsinoFundamental.value == ""){
                    mensagem = mensagem + "Selecione uma Instituição de Ensino Fundamental na Questão 04\n";
                }
                if (form.opt_qt05_InstituicaoEnsinoMedio.value == ""){
                    mensagem = mensagem + "Selecione uma Instituição de Ensino Medio na Questão 05\n";
                }
                if (form.txt_qt06_ValorBolsaEstagio.value == ""){
                    form.txt_qt06_ValorBolsaEstagio.value = 0.0;
                }
                if (form.txt_qt06_ValorBolsaEstagio.value < 0.0){
                    mensagem = mensagem + "O valor bolsa estágio na Questão 06 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt06_ValorBolsaEstagio.value)){
                    mensagem = mensagem + "O valor bolsa estágio na Questão 06 deve ser numérico\n";
                }
                if (form.txt_qt06_ValorBolsaIniciacao.value == ""){
                    form.txt_qt06_ValorBolsaIniciacao.value = 0.0;
                }
                if (form.txt_qt06_ValorBolsaIniciacao.value < 0.0){
                    mensagem = mensagem + "O valor bolsa iniciação na Questão 06 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt06_ValorBolsaIniciacao.value)){
                    mensagem = mensagem + "O valor bolsa iniciação na Questão 06 deve ser numérico\n";
                }
                if (form.txt_qt06_ValorBolsaTreinamento.value == ""){
                    form.txt_qt06_ValorBolsaTreinamento.value = 0.0;
                }
                if (form.txt_qt06_ValorBolsaTreinamento.value < 0.0){
                    mensagem = mensagem + "O valor bolsa treinamento na Questão 06 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt06_ValorBolsaTreinamento.value)){
                    mensagem = mensagem + "O valor bolsa treinamento na Questão 06 deve ser numérico\n";
                }
                if (form.txt_qt06_ValorBolsaOutro.value == ""){
                    form.txt_qt06_ValorBolsaOutro.value = 0.0;
                }
                if (form.txt_qt06_ValorBolsaOutro.value < 0.0){
                    mensagem = mensagem + "O valor bolsa outro na Questão 06 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt06_ValorBolsaOutro.value)){
                    mensagem = mensagem + "O valor bolsa outro na Questão 06 deve ser numérico\n";
                }
                if (form.opt_qt06_AtividadeRemunerada.value == ""){
                    mensagem = mensagem + "Selecione uma Atividade Remunerada na Questão 06\n";
                }
                if (form.opt_qt07_TrabalhoRemunerado.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Trabalho Remunerado na Questão 07\n";
                }
                if (form.txt_qt07_Salario.value == ""){
                    form.txt_qt07_Salario.value = 0.0;
                }
                if (form.txt_qt07_Salario.value < 0.0){
                    mensagem = mensagem + "O valor do salário na Questão 07 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt07_Salario.value)){
                    mensagem = mensagem + "O valor do salário na Questão 07 deve ser numérico\n";
                } 
                if (form.opt_qt08_Manutencao.value == ""){
                    mensagem = mensagem + "Selecione uma Manutenção na Questão 08\n";
                }
                if (form.opt_qt09_Moradia.value == ""){
                    mensagem = mensagem + "Selecione uma Moradia na Questão 09\n";
                }
                if (form.opt_qt10_ResponsavelFinanceiro.value == ""){
                    mensagem = mensagem + "Selecione um Responsavel Financeiro na Questão 10\n";
                }
                if (form.opt_qt11_Esgoto.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Esgoto na Questão 11\n";
                }
                if (form.opt_qt11_Agua.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Agua na Questão 11\n";
                }
                if (form.opt_qt11_Iluminacao.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Iluminação na Questão 11\n";
                }
                if (form.opt_qt11_Lixo.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Lixo na Questão 11\n";
                }
                if (form.opt_qt11_Pavimentacao.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Pavimentação na Questão 11\n";
                }
                if (form.opt_qt12_Residencia.value == ""){
                    mensagem = mensagem + "Selecione um Local de Residência na Questão 12\n";
                }
                if (form.opt_qt13_Imovel.value == ""){
                    mensagem = mensagem + "Selecione um Tipo de Imóvel na Questão 13\n";
                }
                if (form.txt_qt13_ValorAluguel.value == ""){
                    form.txt_qt13_ValorAluguel.value = 0.0;
                }
                if (form.txt_qt13_ValorAluguel.value < 0.0){
                    mensagem = mensagem + "O valor do aluguel na Questão 13 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt13_ValorAluguel.value)){
                    mensagem = mensagem + "O valor do aluguel na Questão 13 deve ser numérico\n";
                }
                if (form.txt_qt13_ValorPrestacao.value == ""){
                    form.txt_qt13_ValorPrestacao.value = 0.0;
                }
                if (form.txt_qt13_ValorPrestacao.value < 0.0){
                    mensagem = mensagem + "O valor da prestação na Questão 13 não pode ser negativo\n";
                }
                if (!campoNumerico(form.txt_qt13_ValorPrestacao.value)){
                    mensagem = mensagem + "O valor da prestação na Questão 13 deve ser numérico\n";
                }                               
                if (form.opt_qt14_Acabamento.value == ""){
                    mensagem = mensagem + "Informe Residência com ou sem Acabamento na Questão 14\n";
                }
                if (form.opt_qt15_OutrosImoveis.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não em Outros Imóveis na Questão 15\n";
                }
                if (form.txt_qt16_QuantCarro.value == ""){
                    mensagem = mensagem + "Informe a quantidade de carros na Questão 16\n";
                }
                if (form.txt_qt16_QuantTV.value == ""){
                    mensagem = mensagem + "Informe a quantidade de TVs na Questão 16\n";
                }
                if (form.txt_qt16_QuantMaqLavar.value == ""){
                    mensagem = mensagem + "Informe a quantidade de máquinas de lavar na Questão 16\n";
                }
                if (form.txt_qt16_QuantGeladeira.value == ""){
                    mensagem = mensagem + "Informe a quantidade de geladeiras na Questão 16\n";
                }
                if (form.txt_qt16_QuantTVCabo.value == ""){
                    mensagem = mensagem + "Informe a quantidade de TVs a cabo na Questão 16\n";
                }
                if (form.txt_qt16_QuantComputador.value == ""){
                    mensagem = mensagem + "Informe a quantidade de computadores na Questão 16\n";
                }
                if (form.txt_qt16_QuantInternetPaga.value == ""){
                    mensagem = mensagem + "Informe a quantidade de internetes pagas na Questão 16\n";
                }
                if (form.txt_qt16_QuantEmpregadaMensalista.value == ""){
                    mensagem = mensagem + "Informe a quantidade de empregadas mensalistas na Questão 16\n";
                }
                if (form.txt_qt16_QuantEmpregadaDiarista.value == ""){
                    mensagem = mensagem + "Informe a quantidade de empregadas diaristas na Questão 16\n";
                }
                if (form.txt_qt16_QuantBanheiro.value == ""){
                    mensagem = mensagem + "Informe a quantidade de banheiros na Questão 16\n";
                }
                if (form.txt_qt16_QuantQuarto.value == ""){
                    mensagem = mensagem + "Informe a quantidade de quartos na Questão 16\n";
                }
                if (form.opt_qt17_ProblemaSaude.value == ""){
                    mensagem = mensagem + "Informe Sim ou Não para Problema de Saúde na Questão 17\n";
                }
                if (form.txt_qt18_AluguelImoveis.value == ""){
                    form.txt_qt18_AluguelImoveis.value = 0.0;
                }
                if (form.txt_qt18_PensaoMorte.value == ""){
                    form.txt_qt18_PensaoMorte.value = 0.0;
                }
                if (form.txt_qt18_PensaoAlimenticia.value == ""){
                    form.txt_qt18_PensaoAlimenticia.value = 0.0;
                }
                if (form.txt_qt18_AjudaTerceiros.value == ""){
                    form.txt_qt18_AjudaTerceiros.value = 0.0;
                }
                if (form.txt_qt18_BeneficiosSociais.value == ""){
                    form.txt_qt18_BeneficiosSociais.value = 0.0;
                }
                if (form.txt_qt18_OutraRenda.value == ""){
                    form.txt_qt18_OutraRenda.value = 0.0;
                }
                if (form.txt_qt18_AluguelImoveis.value < 0.0){
                    mensagem = mensagem + "Renda de Aluguel não pode ser negativa\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (form.txt_qt18_PensaoMorte.value < 0.0){
                    mensagem = mensagem + "Renda de Pensão por Morte não pode ser negativa\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (form.txt_qt18_PensaoAlimenticia.value < 0.0){
                    mensagem = mensagem + "Renda de Pensão Alimentícia não pode ser negativa\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (form.txt_qt18_AjudaTerceiros.value < 0.0){
                    mensagem = mensagem + "Ajuda de Terceiros não pode ser negativa\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (form.txt_qt18_BeneficiosSociais.value < 0.0){
                    mensagem = mensagem + "Benefícios Sociais não podem ser negativos\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (form.txt_qt18_OutraRenda.value < 0.0){
                    mensagem = mensagem + "Outras Rendas não podem ser negativas\n";
                    form.txt_qt18_TotalRenda.value = "";
                }
                if (!campoNumerico(form.txt_qt18_AluguelImoveis.value)){
                    mensagem = mensagem + "Aluguel na Questão 18 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt18_PensaoMorte.value)){
                    mensagem = mensagem + "Pensão por Morte na Questão 18 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt18_PensaoAlimenticia.value)){
                    mensagem = mensagem + "Pensão Alimentícia na Questão 18 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt18_AjudaTerceiros.value)){
                    mensagem = mensagem + "Ajuda de Terceiros na Questão 18 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt18_BeneficiosSociais.value)){
                    mensagem = mensagem + "Benefícios Sociais na Questão 18 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt18_OutraRenda.value)){
                    mensagem = mensagem + "Outra Renda na Questão 18 deve ser numérico\n";
                }
                if (form.txt_qt18_AluguelImoveis.value >= 0.0 && form.txt_qt18_PensaoMorte.value >= 0.0 && form.txt_qt18_PensaoAlimenticia.value >= 0.0 && form.txt_qt18_AjudaTerceiros.value >= 0.0 && form.txt_qt18_BeneficiosSociais.value >= 0.0 && form.txt_qt18_OutraRenda.value >= 0.0){
                    form.txt_qt18_TotalRenda.value = (parseFloat(form.txt_qt18_AluguelImoveis.value) + parseFloat(form.txt_qt18_PensaoMorte.value) + parseFloat(form.txt_qt18_PensaoAlimenticia.value) + parseFloat(form.txt_qt18_AjudaTerceiros.value) + parseFloat(form.txt_qt18_BeneficiosSociais.value) + parseFloat(form.txt_qt18_OutraRenda.value)).toFixed(2);
                }
                if (form.txt_qt18_NumeroResidentes.value == ""){
                    mensagem = mensagem + "Informe o número de residentes na Questão 18\n";
                }
                if (form.txt_qt19_ValorAgua.value == ""){
                    form.txt_qt19_ValorAgua.value = 0.0;
                }
                if (form.txt_qt19_ValorLuz.value == ""){
                    form.txt_qt19_ValorLuz.value = 0.0;
                }
                if (form.txt_qt19_ValorTelefone.value == ""){
                    form.txt_qt19_ValorTelefone.value = 0.0;
                }
                if (form.txt_qt19_ValorCondominio.value == ""){
                    form.txt_qt19_ValorCondominio.value = 0.0;
                }
                if (form.txt_qt19_ValorMensalidadeEscolar.value == ""){
                    form.txt_qt19_ValorMensalidadeEscolar.value = 0.0;
                }
                if (form.txt_qt19_ValorAlimentacao.value == ""){
                    form.txt_qt19_ValorAlimentacao.value = 0.0;
                }
                if (form.txt_qt19_ValorSaude.value == ""){
                    form.txt_qt19_ValorSaude.value = 0.0;
                }
                if (form.txt_qt19_ValorTransporte.value == ""){
                    form.txt_qt19_ValorTransporte.value = 0.0;
                }
                if (form.txt_qt19_ValorIptuAnual.value == ""){
                    form.txt_qt19_ValorIptuAnual.value = 0.0;
                }
                if (form.txt_qt19_ValorAluguel.value == ""){
                    form.txt_qt19_ValorAluguel.value = 0.0;
                }
                if (form.txt_qt19_ValorPensao.value == ""){
                    form.txt_qt19_ValorPensao.value = 0.0;
                }
                if (form.txt_qt19_ValorOutros.value == ""){
                    form.txt_qt19_ValorOutros.value = 0.0;
                }
                if (form.txt_qt19_ValorAgua.value < 0.0){
                    mensagem = mensagem + "Despesa de Água na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorLuz.value < 0.0){
                    mensagem = mensagem + "Despesa de Luz na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorTelefone.value < 0.0){
                    mensagem = mensagem + "Despesa de Telefone na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorCondominio.value < 0.0){
                    mensagem = mensagem + "Despesa de Condomínio na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorMensalidadeEscolar.value < 0.0){
                    mensagem = mensagem + "Despesa de Mensalidade Escolar na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorAlimentacao.value < 0.0){
                    mensagem = mensagem + "Despesa de Alimentação na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorSaude.value < 0.0){
                    mensagem = mensagem + "Despesa de Saúde na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorTransporte.value < 0.0){
                    mensagem = mensagem + "Despesa de Transporte na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorIptuAnual.value < 0.0){
                    mensagem = mensagem + "Despesa de IPTU Anual na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorAluguel.value < 0.0){
                    mensagem = mensagem + "Despesa de Aluguel na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorPensao.value < 0.0){
                    mensagem = mensagem + "Despesa de Pensão na Questão 19 não pode ser negativa\n";
                }
                if (form.txt_qt19_ValorOutros.value < 0.0){
                    mensagem = mensagem + "Outras Despesas na Questão 19 não podem ser negativas\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorAgua.value)){
                    mensagem = mensagem + "Despesa de Água na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorLuz.value)){
                    mensagem = mensagem + "Despesa de Luz na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorTelefone.value)){
                    mensagem = mensagem + "Despesa de Telefone na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorCondominio.value)){
                    mensagem = mensagem + "Despesa de Condomínio na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorMensalidadeEscolar.value)){
                    mensagem = mensagem + "Despesa de Mensalidade Escolar na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorAlimentacao.value)){
                    mensagem = mensagem + "Despesa de Alimentação na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorSaude.value)){
                    mensagem = mensagem + "Despesa de Saúde na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorTransporte.value)){
                    mensagem = mensagem + "Despesa de Transporte na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorIptuAnual.value)){
                    mensagem = mensagem + "Despesa de IPTU Anual na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorAluguel.value)){
                    mensagem = mensagem + "Despesa de Aluguel na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorPensao.value)){
                    mensagem = mensagem + "Despesa de Pensão na Questão 19 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt19_ValorOutros.value)){
                    mensagem = mensagem + "Outras Despesas na Questão 19 deve ser numérico\n";
                }
                if (form.txt_qt20_ValorAgua.value == ""){
                    form.txt_qt20_ValorAgua.value = 0.0;
                }
                if (form.txt_qt20_ValorLuz.value == ""){
                    form.txt_qt20_ValorLuz.value = 0.0;
                }
                if (form.txt_qt20_ValorTelefone.value == ""){
                    form.txt_qt20_ValorTelefone.value = 0.0;
                }
                if (form.txt_qt20_ValorCondominio.value == ""){
                    form.txt_qt20_ValorCondominio.value = 0.0;
                }
                if (form.txt_qt20_ValorAluguel.value == ""){
                    form.txt_qt20_ValorAluguel.value = 0.0;
                }
                if (form.txt_qt20_ValorIptuAnual.value == ""){
                    form.txt_qt20_ValorIptuAnual.value = 0.0;
                }
                if (form.txt_qt20_ValorAgua.value < 0.0){
                    mensagem = mensagem + "Despesa de Água na Questão 20 não pode ser negativa\n";
                }
                if (form.txt_qt20_ValorLuz.value < 0.0){
                    mensagem = mensagem + "Despesa de Luz na Questão 20 não pode ser negativa\n";
                }
                if (form.txt_qt20_ValorTelefone.value < 0.0){
                    mensagem = mensagem + "Despesa de Telefone na Questão 20 não pode ser negativa\n";
                }
                if (form.txt_qt20_ValorCondominio.value < 0.0){
                    mensagem = mensagem + "Despesa de Condomínio na Questão 20 não pode ser negativa\n";
                }
                if (form.txt_qt20_ValorAluguel.value < 0.0){
                    mensagem = mensagem + "Despesa de Aluguel na Questão 20 não pode ser negativa\n";
                }
                if (form.txt_qt20_ValorIptuAnual.value < 0.0){
                    mensagem = mensagem + "Despesa de IPTU Anual na Questão 20 não pode ser negativa\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorAgua.value)){
                    mensagem = mensagem + "Despesa de Água na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorLuz.value)){
                    mensagem = mensagem + "Despesa de Luz na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorTelefone.value)){
                    mensagem = mensagem + "Despesa de Telefone na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorCondominio.value)){
                    mensagem = mensagem + "Despesa de Condomínio na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorAluguel.value)){
                    mensagem = mensagem + "Despesa de Aluguel na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt20_ValorIptuAnual.value)){
                    mensagem = mensagem + "Despesa de IPTU Anual na Questão 20 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt16_QuantCarro.value)){
                    mensagem = mensagem + "A quantidade de carros na Questão 16 deve ser numérico\n";
                }
                if (!campoNumerico(form.txt_qt16_QuantTV.value)){
                    mensagem = mensagem + "A quantidade de TVs na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantMaqLavar.value)){
                    mensagem = mensagem + "A quantidade de máquinas de lavar na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantGeladeira.value)){
                    mensagem = mensagem + "A quantidade de geladeiras na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantTVCabo.value)){
                    mensagem = mensagem + "A quantidade de TVs a cabo na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantComputador.value)){
                    mensagem = mensagem + "A quantidade de computadores na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantInternetPaga.value)){
                    mensagem = mensagem + "A quantidade de internetes pagas na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantEmpregadaMensalista.value)){
                    mensagem = mensagem + "A quantidade de empregadas mensalistas na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantEmpregadaDiarista.value)){
                    mensagem = mensagem + "A quantidade de empregadas diaristas na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantBanheiro.value)){
                    mensagem = mensagem + "A quantidade de banheiros na Questão 16 deve ser numérico\n";
                } 
                if (!campoNumerico(form.txt_qt16_QuantQuarto.value)){
                    mensagem = mensagem + "A quantidade de quartos na Questão 16 deve ser numérico\n";
                }
                if(!form.termo.checked){
                    mensagem = mensagem + "Você deve aceitar os termos de compromisso\n";
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