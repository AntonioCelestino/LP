/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Formulario;
import modelo.Funcionario;
import modelo.Selecao;

/**
 *
 * @author Nathan
 */
public class ManterFormularioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        if(acao.equals("prepararIncluir")){
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if(acao.equals("prepararEditar")){
                    prepararEditar(request, response);
                } else {
                    if (acao.equals("confirmarEditar")) {
                        confirmarEditar(request, response);
                    } else {
                        if(acao.equals("prepararExcluir")){
                            prepararExcluir(request, response);
                        } else {
                            if (acao.equals("confirmarExcluir")) {
                                confirmarExcluir(request, response);
                            }
                        }
                    }   
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("alunos", Aluno.obterAlunos());
            request.setAttribute("selecoes", Selecao.obterSelecoes());
            
            RequestDispatcher view = request.getRequestDispatcher("/manterFormulario.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int codFormulario = Integer.parseInt(request.getParameter("optAluno") + request.getParameter("optSelecao"));
        int codAluno = Integer.parseInt(request.getParameter("optAluno"));
        int codSelecao = Integer.parseInt(request.getParameter("optSelecao"));
        String qt01_Resposta = request.getParameter("opt_qt01_Resposta");	
        String qt01_Nome = request.getParameter("txt_qt01_Nome"); 		
        String qt01_Parentesco = request.getParameter("txt_qt01_Parentesco");	
        String qt01_Programa = request.getParameter("txt_qt01_Programa"); 	
        String qt01_Ano = request.getParameter("txt_qt01_Ano");
        String qt02_Alimentacao = request.getParameter("opt_qt02_Alimentacao");	
        String qt02_Manutencao = request.getParameter("opt_qt02_Manutencao");	
        String qt02_Moradia = request.getParameter("opt_qt02_Moradia");	
        String qt02_Transporte = request.getParameter("opt_qt02_Transporte");	
        String qt02_Outro = request.getParameter("txt_qt02_Outro");
        String qt03_Transporte = request.getParameter("opt_qt03_Transporte");	
        String qt03_Tempo = request.getParameter("txt_qt03_Tempo");	
        String qt03_ValorGastoDiario = request.getParameter("txt_qt03_ValorGastoDiario"); 	
        String qt03_ValorGastoMensal = request.getParameter("txt_qt03_ValorGastoMensal"); 	
        String qt03_Outro = request.getParameter("txt_qt03_Outro");
        String qt04_InstituicaoEnsinoFundamental = request.getParameter("opt_qt04_InstituicaoEnsinoFundamental");
        String qt05_InstituicaoEnsinoMedio = request.getParameter("opt_qt05_InstituicaoEnsinoMedio");
        String qt06_AtividadeRemunerada = request.getParameter("opt_qt06_AtividadeRemunerada"); 	
        String qt06_ValorBolsaEstagio = request.getParameter("txt_qt06_ValorBolsaEstagio"); 		
        String qt06_ProjetoIniciacao = request.getParameter("txt_qt06_ProjetoIniciacao"); 	
        String qt06_ValorBolsaIniciacao = request.getParameter("txt_qt06_ValorBolsaIniciacao"); 	
        String qt06_ProjetoTreinamento = request.getParameter("txt_qt06_ProjetoTreinamento"); 	
        String qt06_ValorBolsaTreinamento = request.getParameter("txt_qt06_ValorBolsaTreinamento"); 	
        String qt06_Outro = request.getParameter("txt_qt06_Outro"); 		
        String qt06_ValorBolsaOutro = request.getParameter("txt_qt06_ValorBolsaOutro");
        String qt07_TrabalhoRemunerado = request.getParameter("opt_qt07_TrabalhoRemunerado");	
        String qt07_HorasSemanais = request.getParameter("txt_qt07_HorasSemanais"); 	
        String qt07_Salario = request.getParameter("txt_qt07_Salario");
        String qt08_Manutencao = request.getParameter("opt_qt08_Manutencao"); 	
        String qt08_Outra = request.getParameter("txt_qt08_Outra");
        String qt09_Moradia = request.getParameter("opt_qt09_Moradia"); 	
        String qt09_Outra = request.getParameter("txt_qt09_Outra");
        String qt10_ResponsavelFinanceiro = request.getParameter("opt_qt10_ResponsavelFinanceiro");		
        String qt10_Outros = request.getParameter("txt_qt10_Outros");
        String qt11_Esgoto = request.getParameter("opt_qt11_Esgoto");		
        String qt11_Agua = request.getParameter("opt_qt11_Agua");			
        String qt11_Iluminacao = request.getParameter("opt_qt11_Iluminacao");		
        String qt11_Lixo = request.getParameter("opt_qt11_Lixo");			
        String qt11_Pavimentacao = request.getParameter("opt_qt11_Pavimentacao");
        String qt12_Residencia = request.getParameter("opt_qt12_Residencia"); 	
        String qt12_Outro = request.getParameter("txt_qt12_Outro");
        String qt13_Imovel = request.getParameter("opt_qt13_Imovel"); 	
        String qt13_ValorAluguel = request.getParameter("txt_qt13_ValorAluguel");	
        String qt13_ValorPrestacao = request.getParameter("txt_qt13_ValorPrestacao");	
        String qt13_Nome = request.getParameter("txt_qt13_Nome");		
        String qt13_Outro = request.getParameter("txt_qt13_Outro");
        String qt14_Acabamento = request.getParameter("opt_qt14_Acabamento");
        String qt15_OutrosImoveis = request.getParameter("opt_qt15_OutrosImoveis");
        String qt15_DescricaoImoveis = request.getParameter("txt_qt15_DescricaoImoveis");
        int qt16_QuantCarro = Integer.parseInt(request.getParameter("txt_qt16_QuantCarro"));
        int qt16_QuantTV = Integer.parseInt(request.getParameter("txt_qt16_QuantTV"));
        int qt16_QuantMaqLavar = Integer.parseInt(request.getParameter("txt_qt16_QuantMaqLavar"));
        int qt16_QuantGeladeira = Integer.parseInt(request.getParameter("txt_qt16_QuantGeladeira"));
        int qt16_QuantTVCabo = Integer.parseInt(request.getParameter("txt_qt16_QuantTVCabo"));
        int qt16_QuantComputador = Integer.parseInt(request.getParameter("txt_qt16_QuantComputador"));
        int qt16_QuantInternetPaga = Integer.parseInt(request.getParameter("txt_qt16_QuantInternetPaga"));
        int qt16_QuantEmpregadaMensalista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaMensalista"));
        int qt16_QuantEmpregadaDiarista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaDiarista"));
        int qt16_QuantBanheiro = Integer.parseInt(request.getParameter("txt_qt16_QuantBanheiro"));
        int qt16_QuantQuarto = Integer.parseInt(request.getParameter("txt_qt16_QuantQuarto"));
        String qt17_ProblemaSaude = request.getParameter("opt_qt17_ProblemaSaude");
        double qt18_AluguelImoveis = Double.parseDouble(request.getParameter("txt_qt18_AluguelImoveis"));
        double qt18_PensaoMorte = Double.parseDouble(request.getParameter("txt_qt18_PensaoMorte"));
        double qt18_PensaoAlimenticia = Double.parseDouble(request.getParameter("txt_qt18_PensaoAlimenticia"));
        double qt18_AjudaTerceiros = Double.parseDouble(request.getParameter("txt_qt18_AjudaTerceiros"));
        double qt18_BeneficiosSociais = Double.parseDouble(request.getParameter("txt_qt18_BeneficiosSociais"));
        double qt18_OutraRenda = Double.parseDouble(request.getParameter("txt_qt18_OutraRenda"));
        String qt18_NomeOutraRenda = request.getParameter("txt_qt18_NomeOutraRenda");
        double qt18_TotalRenda = Double.parseDouble(request.getParameter("txt_qt18_TotalRenda"));
        int qt18_NumeroResidentes = Integer.parseInt(request.getParameter("txt_qt18_NumeroResidentes"));
        double qt19_ValorAgua = Double.parseDouble(request.getParameter("txt_qt19_ValorAgua"));
        double qt19_ValorLuz = Double.parseDouble(request.getParameter("txt_qt19_ValorLuz"));
        double qt19_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt19_ValorTelefone"));
        double qt19_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt19_ValorCondominio"));
        double qt19_ValorMensalidadeEscolar = Double.parseDouble(request.getParameter("txt_qt19_ValorMensalidadeEscolar"));
        double qt19_ValorAlimentacao = Double.parseDouble(request.getParameter("txt_qt19_ValorAlimentacao"));
        double qt19_ValorSaude = Double.parseDouble(request.getParameter("txt_qt19_ValorSaude"));
        double qt19_ValorTransporte = Double.parseDouble(request.getParameter("txt_qt19_ValorTransporte"));
        double qt19_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt19_ValorIptuAnual"));
        double qt19_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt19_ValorAluguel"));
        double qt19_ValorPensao = Double.parseDouble(request.getParameter("txt_qt19_ValorPensao"));
        double qt19_ValorOutros = Double.parseDouble(request.getParameter("txt_qt19_ValorOutros"));
        double qt20_ValorAgua = Double.parseDouble(request.getParameter("txt_qt20_ValorAgua"));
        double qt20_ValorLuz = Double.parseDouble(request.getParameter("txt_qt20_ValorLuz"));
        double qt20_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt20_ValorTelefone"));
        double qt20_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt20_ValorCondominio"));
        double qt20_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt20_ValorAluguel"));
        double qt20_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt20_ValorIptuAnual"));
        String qt21_Esclarecimentos = request.getParameter("txt_qt21_Esclarecimentos");
        try{
            Aluno aluno = null;
            if(codAluno != 0){
                aluno = Aluno.obterAluno(codAluno);
            }
            Selecao selecao = null;
            if(codSelecao != 0){
                selecao = Selecao.obterSelecao(codSelecao);
            }
            Formulario formulario = new Formulario(codFormulario, aluno, selecao, qt01_Resposta, qt01_Nome, qt01_Parentesco, qt01_Programa, 
                    qt01_Ano, qt02_Alimentacao, qt02_Manutencao, qt02_Moradia, qt02_Transporte, qt02_Outro, qt03_Transporte, qt03_Tempo, qt03_ValorGastoDiario, qt03_ValorGastoMensal, 
                    qt03_Outro, qt04_InstituicaoEnsinoFundamental, qt05_InstituicaoEnsinoMedio, qt06_AtividadeRemunerada, qt06_ValorBolsaEstagio, 
                    qt06_ProjetoIniciacao, qt06_ValorBolsaIniciacao, qt06_ProjetoTreinamento, qt06_ValorBolsaTreinamento, qt06_Outro, 
                    qt06_ValorBolsaOutro, qt07_TrabalhoRemunerado, qt07_HorasSemanais, qt07_Salario, qt08_Manutencao, qt08_Outra, qt09_Moradia, 
                    qt09_Outra, qt10_ResponsavelFinanceiro, qt10_Outros, qt11_Esgoto, qt11_Agua, qt11_Iluminacao, qt11_Lixo, qt11_Pavimentacao, 
                    qt12_Residencia, qt12_Outro, qt13_Imovel, qt13_ValorAluguel, qt13_ValorPrestacao, qt13_Nome, qt13_Outro, qt14_Acabamento, 
                    qt15_OutrosImoveis, qt15_DescricaoImoveis, qt16_QuantCarro, qt16_QuantTV, qt16_QuantMaqLavar, qt16_QuantGeladeira, qt16_QuantTVCabo, qt16_QuantComputador, 
                    qt16_QuantInternetPaga, qt16_QuantEmpregadaMensalista, qt16_QuantEmpregadaDiarista, qt16_QuantBanheiro, qt16_QuantQuarto, 
                    qt17_ProblemaSaude, qt18_AluguelImoveis, qt18_PensaoMorte, qt18_PensaoAlimenticia, qt18_AjudaTerceiros, qt18_BeneficiosSociais, 
                    qt18_OutraRenda, qt18_NomeOutraRenda, qt18_TotalRenda, qt18_NumeroResidentes, qt19_ValorAgua, qt19_ValorLuz, qt19_ValorTelefone, qt19_ValorCondominio, 
                    qt19_ValorMensalidadeEscolar, qt19_ValorAlimentacao, qt19_ValorSaude, qt19_ValorTransporte, qt19_ValorIptuAnual, qt19_ValorAluguel, qt19_ValorPensao, 
                    qt19_ValorOutros, qt20_ValorAgua, qt20_ValorLuz, qt20_ValorTelefone, qt20_ValorCondominio, qt20_ValorAluguel, qt20_ValorIptuAnual, qt21_Esclarecimentos);            
            formulario.setCodAluno(codAluno);
            formulario.setCodSelecao(codSelecao);
            formulario.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Editar");
            request.setAttribute("alunos", Aluno.obterAlunos());
            request.setAttribute("selecoes", Selecao.obterSelecoes());
            int codFormulario = Integer.parseInt(request.getParameter("codFormulario"));
            Formulario formulario = Formulario.obterFormulario(codFormulario);
            request.setAttribute("formulario", formulario);
            RequestDispatcher view = request.getRequestDispatcher("/manterFormulario.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int codFormulario = Integer.parseInt(request.getParameter("optAluno") + request.getParameter("optSelecao"));
        int codAluno = Integer.parseInt(request.getParameter("optAluno"));
        int codSelecao = Integer.parseInt(request.getParameter("optSelecao"));
        String qt01_Resposta = request.getParameter("opt_qt01_Resposta");	
        String qt01_Nome = request.getParameter("txt_qt01_Nome"); 		
        String qt01_Parentesco = request.getParameter("txt_qt01_Parentesco");	
        String qt01_Programa = request.getParameter("txt_qt01_Programa"); 	
        String qt01_Ano = request.getParameter("txt_qt01_Ano");
        String qt02_Alimentacao = request.getParameter("opt_qt02_Alimentacao");	
        String qt02_Manutencao = request.getParameter("opt_qt02_Manutencao");	
        String qt02_Moradia = request.getParameter("opt_qt02_Moradia");	
        String qt02_Transporte = request.getParameter("opt_qt02_Transporte");	
        String qt02_Outro = request.getParameter("txt_qt02_Outro");
        String qt03_Transporte = request.getParameter("opt_qt03_Transporte");	
        String qt03_Tempo = request.getParameter("txt_qt03_Tempo");	
        String qt03_ValorGastoDiario = request.getParameter("txt_qt03_ValorGastoDiario"); 	
        String qt03_ValorGastoMensal = request.getParameter("txt_qt03_ValorGastoMensal"); 	
        String qt03_Outro = request.getParameter("txt_qt03_Outro");
        String qt04_InstituicaoEnsinoFundamental = request.getParameter("opt_qt04_InstituicaoEnsinoFundamental");
        String qt05_InstituicaoEnsinoMedio = request.getParameter("opt_qt05_InstituicaoEnsinoMedio");
        String qt06_AtividadeRemunerada = request.getParameter("opt_qt06_AtividadeRemunerada"); 	
        String qt06_ValorBolsaEstagio = request.getParameter("txt_qt06_ValorBolsaEstagio"); 		
        String qt06_ProjetoIniciacao = request.getParameter("txt_qt06_ProjetoIniciacao"); 	
        String qt06_ValorBolsaIniciacao = request.getParameter("txt_qt06_ValorBolsaIniciacao"); 	
        String qt06_ProjetoTreinamento = request.getParameter("txt_qt06_ProjetoTreinamento"); 	
        String qt06_ValorBolsaTreinamento = request.getParameter("txt_qt06_ValorBolsaTreinamento"); 	
        String qt06_Outro = request.getParameter("txt_qt06_Outro"); 		
        String qt06_ValorBolsaOutro = request.getParameter("txt_qt06_ValorBolsaOutro");
        String qt07_TrabalhoRemunerado = request.getParameter("opt_qt07_TrabalhoRemunerado");	
        String qt07_HorasSemanais = request.getParameter("txt_qt07_HorasSemanais"); 	
        String qt07_Salario = request.getParameter("txt_qt07_Salario");
        String qt08_Manutencao = request.getParameter("opt_qt08_Manutencao"); 	
        String qt08_Outra = request.getParameter("txt_qt08_Outra");
        String qt09_Moradia = request.getParameter("opt_qt09_Moradia"); 	
        String qt09_Outra = request.getParameter("txt_qt09_Outra");
        String qt10_ResponsavelFinanceiro = request.getParameter("opt_qt10_ResponsavelFinanceiro");		
        String qt10_Outros = request.getParameter("txt_qt10_Outros");
        String qt11_Esgoto = request.getParameter("opt_qt11_Esgoto");		
        String qt11_Agua = request.getParameter("opt_qt11_Agua");			
        String qt11_Iluminacao = request.getParameter("opt_qt11_Iluminacao");		
        String qt11_Lixo = request.getParameter("opt_qt11_Lixo");			
        String qt11_Pavimentacao = request.getParameter("opt_qt11_Pavimentacao");
        String qt12_Residencia = request.getParameter("opt_qt12_Residencia"); 	
        String qt12_Outro = request.getParameter("txt_qt12_Outro");
        String qt13_Imovel = request.getParameter("opt_qt13_Imovel"); 	
        String qt13_ValorAluguel = request.getParameter("txt_qt13_ValorAluguel");	
        String qt13_ValorPrestacao = request.getParameter("txt_qt13_ValorPrestacao");	
        String qt13_Nome = request.getParameter("txt_qt13_Nome");		
        String qt13_Outro = request.getParameter("txt_qt13_Outro");
        String qt14_Acabamento = request.getParameter("opt_qt14_Acabamento");
        String qt15_OutrosImoveis = request.getParameter("opt_qt15_OutrosImoveis");
        String qt15_DescricaoImoveis = request.getParameter("txt_qt15_DescricaoImoveis");
        int qt16_QuantCarro = Integer.parseInt(request.getParameter("txt_qt16_QuantCarro"));
        int qt16_QuantTV = Integer.parseInt(request.getParameter("txt_qt16_QuantTV"));
        int qt16_QuantMaqLavar = Integer.parseInt(request.getParameter("txt_qt16_QuantMaqLavar"));
        int qt16_QuantGeladeira = Integer.parseInt(request.getParameter("txt_qt16_QuantGeladeira"));
        int qt16_QuantTVCabo = Integer.parseInt(request.getParameter("txt_qt16_QuantTVCabo"));
        int qt16_QuantComputador = Integer.parseInt(request.getParameter("txt_qt16_QuantComputador"));
        int qt16_QuantInternetPaga = Integer.parseInt(request.getParameter("txt_qt16_QuantInternetPaga"));
        int qt16_QuantEmpregadaMensalista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaMensalista"));
        int qt16_QuantEmpregadaDiarista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaDiarista"));
        int qt16_QuantBanheiro = Integer.parseInt(request.getParameter("txt_qt16_QuantBanheiro"));
        int qt16_QuantQuarto = Integer.parseInt(request.getParameter("txt_qt16_QuantQuarto"));
        String qt17_ProblemaSaude = request.getParameter("opt_qt17_ProblemaSaude");
        double qt18_AluguelImoveis = Double.parseDouble(request.getParameter("txt_qt18_AluguelImoveis"));
        double qt18_PensaoMorte = Double.parseDouble(request.getParameter("txt_qt18_PensaoMorte"));
        double qt18_PensaoAlimenticia = Double.parseDouble(request.getParameter("txt_qt18_PensaoAlimenticia"));
        double qt18_AjudaTerceiros = Double.parseDouble(request.getParameter("txt_qt18_AjudaTerceiros"));
        double qt18_BeneficiosSociais = Double.parseDouble(request.getParameter("txt_qt18_BeneficiosSociais"));
        double qt18_OutraRenda = Double.parseDouble(request.getParameter("txt_qt18_OutraRenda"));
        String qt18_NomeOutraRenda = request.getParameter("txt_qt18_NomeOutraRenda");
        double qt18_TotalRenda = Double.parseDouble(request.getParameter("txt_qt18_TotalRenda"));
        int qt18_NumeroResidentes = Integer.parseInt(request.getParameter("txt_qt18_NumeroResidentes"));
        double qt19_ValorAgua = Double.parseDouble(request.getParameter("txt_qt19_ValorAgua"));
        double qt19_ValorLuz = Double.parseDouble(request.getParameter("txt_qt19_ValorLuz"));
        double qt19_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt19_ValorTelefone"));
        double qt19_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt19_ValorCondominio"));
        double qt19_ValorMensalidadeEscolar = Double.parseDouble(request.getParameter("txt_qt19_ValorMensalidadeEscolar"));
        double qt19_ValorAlimentacao = Double.parseDouble(request.getParameter("txt_qt19_ValorAlimentacao"));
        double qt19_ValorSaude = Double.parseDouble(request.getParameter("txt_qt19_ValorSaude"));
        double qt19_ValorTransporte = Double.parseDouble(request.getParameter("txt_qt19_ValorTransporte"));
        double qt19_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt19_ValorIptuAnual"));
        double qt19_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt19_ValorAluguel"));
        double qt19_ValorPensao = Double.parseDouble(request.getParameter("txt_qt19_ValorPensao"));
        double qt19_ValorOutros = Double.parseDouble(request.getParameter("txt_qt19_ValorOutros"));
        double qt20_ValorAgua = Double.parseDouble(request.getParameter("txt_qt20_ValorAgua"));
        double qt20_ValorLuz = Double.parseDouble(request.getParameter("txt_qt20_ValorLuz"));
        double qt20_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt20_ValorTelefone"));
        double qt20_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt20_ValorCondominio"));
        double qt20_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt20_ValorAluguel"));
        double qt20_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt20_ValorIptuAnual"));
        String qt21_Esclarecimentos = request.getParameter("txt_qt21_Esclarecimentos");
        try{
            Aluno aluno = null;
            if(codAluno != 0){
                aluno = Aluno.obterAluno(codAluno);
            }
            Selecao selecao = null;
            if(codSelecao != 0){
                selecao = Selecao.obterSelecao(codSelecao);
            }
            Formulario formulario = new Formulario(codFormulario, aluno, selecao, qt01_Resposta, qt01_Nome, qt01_Parentesco, qt01_Programa, 
                    qt01_Ano, qt02_Alimentacao, qt02_Manutencao, qt02_Moradia, qt02_Transporte, qt02_Outro, qt03_Transporte, qt03_Tempo, qt03_ValorGastoDiario, qt03_ValorGastoMensal, 
                    qt03_Outro, qt04_InstituicaoEnsinoFundamental, qt05_InstituicaoEnsinoMedio, qt06_AtividadeRemunerada, qt06_ValorBolsaEstagio, 
                    qt06_ProjetoIniciacao, qt06_ValorBolsaIniciacao, qt06_ProjetoTreinamento, qt06_ValorBolsaTreinamento, qt06_Outro, 
                    qt06_ValorBolsaOutro, qt07_TrabalhoRemunerado, qt07_HorasSemanais, qt07_Salario, qt08_Manutencao, qt08_Outra, qt09_Moradia, 
                    qt09_Outra, qt10_ResponsavelFinanceiro, qt10_Outros, qt11_Esgoto, qt11_Agua, qt11_Iluminacao, qt11_Lixo, qt11_Pavimentacao, 
                    qt12_Residencia, qt12_Outro, qt13_Imovel, qt13_ValorAluguel, qt13_ValorPrestacao, qt13_Nome, qt13_Outro, qt14_Acabamento, 
                    qt15_OutrosImoveis, qt15_DescricaoImoveis, qt16_QuantCarro, qt16_QuantTV, qt16_QuantMaqLavar, qt16_QuantGeladeira, qt16_QuantTVCabo, qt16_QuantComputador, 
                    qt16_QuantInternetPaga, qt16_QuantEmpregadaMensalista, qt16_QuantEmpregadaDiarista, qt16_QuantBanheiro, qt16_QuantQuarto, 
                    qt17_ProblemaSaude, qt18_AluguelImoveis, qt18_PensaoMorte, qt18_PensaoAlimenticia, qt18_AjudaTerceiros, qt18_BeneficiosSociais, 
                    qt18_OutraRenda, qt18_NomeOutraRenda, qt18_TotalRenda, qt18_NumeroResidentes, qt19_ValorAgua, qt19_ValorLuz, qt19_ValorTelefone, qt19_ValorCondominio, 
                    qt19_ValorMensalidadeEscolar, qt19_ValorAlimentacao, qt19_ValorSaude, qt19_ValorTransporte, qt19_ValorIptuAnual, qt19_ValorAluguel, qt19_ValorPensao, 
                    qt19_ValorOutros, qt20_ValorAgua, qt20_ValorLuz, qt20_ValorTelefone, qt20_ValorCondominio, qt20_ValorAluguel, qt20_ValorIptuAnual, qt21_Esclarecimentos);            
            formulario.setCodAluno(codAluno);
            formulario.setCodSelecao(codSelecao);
            formulario.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("alunos", Aluno.obterAlunos());
            request.setAttribute("selecoes", Selecao.obterSelecoes());
            int codFormulario = Integer.parseInt(request.getParameter("codFormulario"));
            Formulario formulario = Formulario.obterFormulario(codFormulario);
            request.setAttribute("formulario", formulario);
            RequestDispatcher view = request.getRequestDispatcher("/manterFormulario.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int codFormulario = Integer.parseInt(request.getParameter("optAluno") + request.getParameter("optSelecao"));
        int codAluno = Integer.parseInt(request.getParameter("optAluno"));
        int codSelecao = Integer.parseInt(request.getParameter("optSelecao"));
        String qt01_Resposta = request.getParameter("opt_qt01_Resposta");	
        String qt01_Nome = request.getParameter("txt_qt01_Nome"); 		
        String qt01_Parentesco = request.getParameter("txt_qt01_Parentesco");	
        String qt01_Programa = request.getParameter("txt_qt01_Programa"); 	
        String qt01_Ano = request.getParameter("txt_qt01_Ano");
        String qt02_Alimentacao = request.getParameter("opt_qt02_Alimentacao");	
        String qt02_Manutencao = request.getParameter("opt_qt02_Manutencao");	
        String qt02_Moradia = request.getParameter("opt_qt02_Moradia");	
        String qt02_Transporte = request.getParameter("opt_qt02_Transporte");	
        String qt02_Outro = request.getParameter("txt_qt02_Outro");
        String qt03_Transporte = request.getParameter("opt_qt03_Transporte");	
        String qt03_Tempo = request.getParameter("txt_qt03_Tempo");	
        String qt03_ValorGastoDiario = request.getParameter("txt_qt03_ValorGastoDiario"); 	
        String qt03_ValorGastoMensal = request.getParameter("txt_qt03_ValorGastoMensal"); 	
        String qt03_Outro = request.getParameter("txt_qt03_Outro");
        String qt04_InstituicaoEnsinoFundamental = request.getParameter("opt_qt04_InstituicaoEnsinoFundamental");
        String qt05_InstituicaoEnsinoMedio = request.getParameter("opt_qt05_InstituicaoEnsinoMedio");
        String qt06_AtividadeRemunerada = request.getParameter("opt_qt06_AtividadeRemunerada"); 	
        String qt06_ValorBolsaEstagio = request.getParameter("txt_qt06_ValorBolsaEstagio"); 		
        String qt06_ProjetoIniciacao = request.getParameter("txt_qt06_ProjetoIniciacao"); 	
        String qt06_ValorBolsaIniciacao = request.getParameter("txt_qt06_ValorBolsaIniciacao"); 	
        String qt06_ProjetoTreinamento = request.getParameter("txt_qt06_ProjetoTreinamento"); 	
        String qt06_ValorBolsaTreinamento = request.getParameter("txt_qt06_ValorBolsaTreinamento"); 	
        String qt06_Outro = request.getParameter("txt_qt06_Outro"); 		
        String qt06_ValorBolsaOutro = request.getParameter("txt_qt06_ValorBolsaOutro");
        String qt07_TrabalhoRemunerado = request.getParameter("opt_qt07_TrabalhoRemunerado");	
        String qt07_HorasSemanais = request.getParameter("txt_qt07_HorasSemanais"); 	
        String qt07_Salario = request.getParameter("txt_qt07_Salario");
        String qt08_Manutencao = request.getParameter("opt_qt08_Manutencao"); 	
        String qt08_Outra = request.getParameter("txt_qt08_Outra");
        String qt09_Moradia = request.getParameter("opt_qt09_Moradia"); 	
        String qt09_Outra = request.getParameter("txt_qt09_Outra");
        String qt10_ResponsavelFinanceiro = request.getParameter("opt_qt10_ResponsavelFinanceiro");		
        String qt10_Outros = request.getParameter("txt_qt10_Outros");
        String qt11_Esgoto = request.getParameter("opt_qt11_Esgoto");		
        String qt11_Agua = request.getParameter("opt_qt11_Agua");			
        String qt11_Iluminacao = request.getParameter("opt_qt11_Iluminacao");		
        String qt11_Lixo = request.getParameter("opt_qt11_Lixo");			
        String qt11_Pavimentacao = request.getParameter("opt_qt11_Pavimentacao");
        String qt12_Residencia = request.getParameter("opt_qt12_Residencia"); 	
        String qt12_Outro = request.getParameter("txt_qt12_Outro");
        String qt13_Imovel = request.getParameter("opt_qt13_Imovel"); 	
        String qt13_ValorAluguel = request.getParameter("txt_qt13_ValorAluguel");	
        String qt13_ValorPrestacao = request.getParameter("txt_qt13_ValorPrestacao");	
        String qt13_Nome = request.getParameter("txt_qt13_Nome");		
        String qt13_Outro = request.getParameter("txt_qt13_Outro");
        String qt14_Acabamento = request.getParameter("opt_qt14_Acabamento");
        String qt15_OutrosImoveis = request.getParameter("opt_qt15_OutrosImoveis");
        String qt15_DescricaoImoveis = request.getParameter("txt_qt15_DescricaoImoveis");
        int qt16_QuantCarro = Integer.parseInt(request.getParameter("txt_qt16_QuantCarro"));
        int qt16_QuantTV = Integer.parseInt(request.getParameter("txt_qt16_QuantTV"));
        int qt16_QuantMaqLavar = Integer.parseInt(request.getParameter("txt_qt16_QuantMaqLavar"));
        int qt16_QuantGeladeira = Integer.parseInt(request.getParameter("txt_qt16_QuantGeladeira"));
        int qt16_QuantTVCabo = Integer.parseInt(request.getParameter("txt_qt16_QuantTVCabo"));
        int qt16_QuantComputador = Integer.parseInt(request.getParameter("txt_qt16_QuantComputador"));
        int qt16_QuantInternetPaga = Integer.parseInt(request.getParameter("txt_qt16_QuantInternetPaga"));
        int qt16_QuantEmpregadaMensalista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaMensalista"));
        int qt16_QuantEmpregadaDiarista = Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaDiarista"));
        int qt16_QuantBanheiro = Integer.parseInt(request.getParameter("txt_qt16_QuantBanheiro"));
        int qt16_QuantQuarto = Integer.parseInt(request.getParameter("txt_qt16_QuantQuarto"));
        String qt17_ProblemaSaude = request.getParameter("opt_qt17_ProblemaSaude");
        double qt18_AluguelImoveis = Double.parseDouble(request.getParameter("txt_qt18_AluguelImoveis"));
        double qt18_PensaoMorte = Double.parseDouble(request.getParameter("txt_qt18_PensaoMorte"));
        double qt18_PensaoAlimenticia = Double.parseDouble(request.getParameter("txt_qt18_PensaoAlimenticia"));
        double qt18_AjudaTerceiros = Double.parseDouble(request.getParameter("txt_qt18_AjudaTerceiros"));
        double qt18_BeneficiosSociais = Double.parseDouble(request.getParameter("txt_qt18_BeneficiosSociais"));
        double qt18_OutraRenda = Double.parseDouble(request.getParameter("txt_qt18_OutraRenda"));
        String qt18_NomeOutraRenda = request.getParameter("txt_qt18_NomeOutraRenda");
        double qt18_TotalRenda = Double.parseDouble(request.getParameter("txt_qt18_TotalRenda"));
        int qt18_NumeroResidentes = Integer.parseInt(request.getParameter("txt_qt18_NumeroResidentes"));
        double qt19_ValorAgua = Double.parseDouble(request.getParameter("txt_qt19_ValorAgua"));
        double qt19_ValorLuz = Double.parseDouble(request.getParameter("txt_qt19_ValorLuz"));
        double qt19_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt19_ValorTelefone"));
        double qt19_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt19_ValorCondominio"));
        double qt19_ValorMensalidadeEscolar = Double.parseDouble(request.getParameter("txt_qt19_ValorMensalidadeEscolar"));
        double qt19_ValorAlimentacao = Double.parseDouble(request.getParameter("txt_qt19_ValorAlimentacao"));
        double qt19_ValorSaude = Double.parseDouble(request.getParameter("txt_qt19_ValorSaude"));
        double qt19_ValorTransporte = Double.parseDouble(request.getParameter("txt_qt19_ValorTransporte"));
        double qt19_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt19_ValorIptuAnual"));
        double qt19_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt19_ValorAluguel"));
        double qt19_ValorPensao = Double.parseDouble(request.getParameter("txt_qt19_ValorPensao"));
        double qt19_ValorOutros = Double.parseDouble(request.getParameter("txt_qt19_ValorOutros"));
        double qt20_ValorAgua = Double.parseDouble(request.getParameter("txt_qt20_ValorAgua"));
        double qt20_ValorLuz = Double.parseDouble(request.getParameter("txt_qt20_ValorLuz"));
        double qt20_ValorTelefone = Double.parseDouble(request.getParameter("txt_qt20_ValorTelefone"));
        double qt20_ValorCondominio = Double.parseDouble(request.getParameter("txt_qt20_ValorCondominio"));
        double qt20_ValorAluguel = Double.parseDouble(request.getParameter("txt_qt20_ValorAluguel"));
        double qt20_ValorIptuAnual = Double.parseDouble(request.getParameter("txt_qt20_ValorIptuAnual"));
        String qt21_Esclarecimentos = request.getParameter("txt_qt21_Esclarecimentos");
        try{
            Aluno aluno = null;
            if(codAluno != 0){
                aluno = Aluno.obterAluno(codAluno);
            }
            Selecao selecao = null;
            if(codSelecao != 0){
                selecao = Selecao.obterSelecao(codSelecao);
            }
            Formulario formulario = new Formulario(codFormulario, aluno, selecao, qt01_Resposta, qt01_Nome, qt01_Parentesco, qt01_Programa, 
                    qt01_Ano, qt02_Alimentacao, qt02_Manutencao, qt02_Moradia, qt02_Transporte, qt02_Outro, qt03_Transporte, qt03_Tempo, qt03_ValorGastoDiario, qt03_ValorGastoMensal, 
                    qt03_Outro, qt04_InstituicaoEnsinoFundamental, qt05_InstituicaoEnsinoMedio, qt06_AtividadeRemunerada, qt06_ValorBolsaEstagio, 
                    qt06_ProjetoIniciacao, qt06_ValorBolsaIniciacao, qt06_ProjetoTreinamento, qt06_ValorBolsaTreinamento, qt06_Outro, 
                    qt06_ValorBolsaOutro, qt07_TrabalhoRemunerado, qt07_HorasSemanais, qt07_Salario, qt08_Manutencao, qt08_Outra, qt09_Moradia, 
                    qt09_Outra, qt10_ResponsavelFinanceiro, qt10_Outros, qt11_Esgoto, qt11_Agua, qt11_Iluminacao, qt11_Lixo, qt11_Pavimentacao, 
                    qt12_Residencia, qt12_Outro, qt13_Imovel, qt13_ValorAluguel, qt13_ValorPrestacao, qt13_Nome, qt13_Outro, qt14_Acabamento, 
                    qt15_OutrosImoveis, qt15_DescricaoImoveis, qt16_QuantCarro, qt16_QuantTV, qt16_QuantMaqLavar, qt16_QuantGeladeira, qt16_QuantTVCabo, qt16_QuantComputador, 
                    qt16_QuantInternetPaga, qt16_QuantEmpregadaMensalista, qt16_QuantEmpregadaDiarista, qt16_QuantBanheiro, qt16_QuantQuarto, 
                    qt17_ProblemaSaude, qt18_AluguelImoveis, qt18_PensaoMorte, qt18_PensaoAlimenticia, qt18_AjudaTerceiros, qt18_BeneficiosSociais, 
                    qt18_OutraRenda, qt18_NomeOutraRenda, qt18_TotalRenda, qt18_NumeroResidentes, qt19_ValorAgua, qt19_ValorLuz, qt19_ValorTelefone, qt19_ValorCondominio, 
                    qt19_ValorMensalidadeEscolar, qt19_ValorAlimentacao, qt19_ValorSaude, qt19_ValorTransporte, qt19_ValorIptuAnual, qt19_ValorAluguel, qt19_ValorPensao, 
                    qt19_ValorOutros, qt20_ValorAgua, qt20_ValorLuz, qt20_ValorTelefone, qt20_ValorCondominio, qt20_ValorAluguel, qt20_ValorIptuAnual, qt21_Esclarecimentos);            
            formulario.setCodAluno(codAluno);
            formulario.setCodSelecao(codSelecao);
            formulario.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }
}
