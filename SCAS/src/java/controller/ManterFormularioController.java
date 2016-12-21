package controller;

import dao.AlunoDAO;
import dao.FormularioDAO;
import dao.SelecaoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Formulario;
import modelo.Selecao;

public class ManterFormularioController extends ProcessRequestController {

    private Formulario formulario;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFormularioController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFormularioController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("alunos", AlunoDAO.obterAlunos());
            request.setAttribute("selecoes", SelecaoDAO.obterSelecoes());
            if(!operacao.equals("Incluir")){
                int codFormulario = Integer.parseInt(request.getParameter("codFormulario"));
                formulario = (Formulario) FormularioDAO.getInstance().obterClasse(Formulario.class, codFormulario);
                request.setAttribute("formulario", formulario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFormulario.jsp");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException e){
            throw new ServletException(e);
        }
    }
    
    public String verificaCampo(String campo){
        if(campo == null){
            return "0";
        }else{
            return campo;
        }
    }
    
    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
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
            float qt03_ValorGastoDiario = Float.parseFloat(verificaCampo(request.getParameter("txt_qt03_ValorGastoDiario"))); 	
            float qt03_ValorGastoMensal = Float.parseFloat(verificaCampo(request.getParameter("txt_qt03_ValorGastoMensal"))); 	
            String qt03_Outro = request.getParameter("txt_qt03_Outro");
            String qt04_InstituicaoEnsinoFundamental = request.getParameter("opt_qt04_InstituicaoEnsinoFundamental");
            String qt05_InstituicaoEnsinoMedio = request.getParameter("opt_qt05_InstituicaoEnsinoMedio");
            String qt06_AtividadeRemunerada = request.getParameter("opt_qt06_AtividadeRemunerada"); 	
            float qt06_ValorBolsaEstagio = Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaEstagio"))); 		
            String qt06_ProjetoIniciacao = request.getParameter("txt_qt06_ProjetoIniciacao"); 	
            float qt06_ValorBolsaIniciacao = Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaIniciacao"))); 	
            String qt06_ProjetoTreinamento = request.getParameter("txt_qt06_ProjetoTreinamento"); 	
            float qt06_ValorBolsaTreinamento = Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaTreinamento"))); 	
            String qt06_Outro = request.getParameter("txt_qt06_Outro"); 		
            float qt06_ValorBolsaOutro = Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaOutro")));
            String qt07_TrabalhoRemunerado = request.getParameter("opt_qt07_TrabalhoRemunerado");	
            String qt07_HorasSemanais = request.getParameter("txt_qt07_HorasSemanais"); 	
            float qt07_Salario = Float.parseFloat(verificaCampo(request.getParameter("txt_qt07_Salario")));
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
            float qt13_ValorAluguel = Float.parseFloat(verificaCampo(request.getParameter("txt_qt13_ValorAluguel")));	
            float qt13_ValorPrestacao = Float.parseFloat(verificaCampo(request.getParameter("txt_qt13_ValorPrestacao")));	
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
            float qt18_AluguelImoveis = Float.parseFloat(request.getParameter("txt_qt18_AluguelImoveis"));
            float qt18_PensaoMorte = Float.parseFloat(request.getParameter("txt_qt18_PensaoMorte"));
            float qt18_PensaoAlimenticia = Float.parseFloat(request.getParameter("txt_qt18_PensaoAlimenticia"));
            float qt18_AjudaTerceiros = Float.parseFloat(request.getParameter("txt_qt18_AjudaTerceiros"));
            float qt18_BeneficiosSociais = Float.parseFloat(request.getParameter("txt_qt18_BeneficiosSociais"));
            float qt18_OutraRenda = Float.parseFloat(request.getParameter("txt_qt18_OutraRenda"));
            String qt18_NomeOutraRenda = request.getParameter("txt_qt18_NomeOutraRenda");
            float qt18_TotalRenda = Float.parseFloat(request.getParameter("txt_qt18_TotalRenda"));
            int qt18_NumeroResidentes = Integer.parseInt(request.getParameter("txt_qt18_NumeroResidentes"));
            float qt19_ValorAgua = Float.parseFloat(request.getParameter("txt_qt19_ValorAgua"));
            float qt19_ValorLuz = Float.parseFloat(request.getParameter("txt_qt19_ValorLuz"));
            float qt19_ValorTelefone = Float.parseFloat(request.getParameter("txt_qt19_ValorTelefone"));
            float qt19_ValorCondominio = Float.parseFloat(request.getParameter("txt_qt19_ValorCondominio"));
            float qt19_ValorMensalidadeEscolar = Float.parseFloat(request.getParameter("txt_qt19_ValorMensalidadeEscolar"));
            float qt19_ValorAlimentacao = Float.parseFloat(request.getParameter("txt_qt19_ValorAlimentacao"));
            float qt19_ValorSaude = Float.parseFloat(request.getParameter("txt_qt19_ValorSaude"));
            float qt19_ValorTransporte = Float.parseFloat(request.getParameter("txt_qt19_ValorTransporte"));
            float qt19_ValorIptuAnual = Float.parseFloat(request.getParameter("txt_qt19_ValorIptuAnual"));
            float qt19_ValorAluguel = Float.parseFloat(request.getParameter("txt_qt19_ValorAluguel"));
            float qt19_ValorPensao = Float.parseFloat(request.getParameter("txt_qt19_ValorPensao"));
            float qt19_ValorOutros = Float.parseFloat(request.getParameter("txt_qt19_ValorOutros"));
            float qt20_ValorAgua = Float.parseFloat(request.getParameter("txt_qt20_ValorAgua"));
            float qt20_ValorLuz = Float.parseFloat(request.getParameter("txt_qt20_ValorLuz"));
            float qt20_ValorTelefone = Float.parseFloat(request.getParameter("txt_qt20_ValorTelefone"));
            float qt20_ValorCondominio = Float.parseFloat(request.getParameter("txt_qt20_ValorCondominio"));
            float qt20_ValorAluguel = Float.parseFloat(request.getParameter("txt_qt20_ValorAluguel"));
            float qt20_ValorIptuAnual = Float.parseFloat(request.getParameter("txt_qt20_ValorIptuAnual"));
            String qt21_Esclarecimentos = request.getParameter("txt_qt21_Esclarecimentos");
            Aluno aluno = null;
            Selecao selecao = null;
            if(codAluno != 0){
                aluno = (Aluno) AlunoDAO.getInstance().obterClasse(Aluno.class, codAluno);
            }
            if(codSelecao != 0){
                selecao = (Selecao) SelecaoDAO.getInstance().obterClasse(Selecao.class, codSelecao);
            }
            if(operacao.equals("Incluir")){
                formulario = new Formulario(codFormulario, aluno, selecao)
                        .questao_01(qt01_Resposta, qt01_Nome, qt01_Parentesco, qt01_Programa, qt01_Ano)
                        .questao_02(qt02_Alimentacao, qt02_Manutencao, qt02_Moradia, qt02_Transporte, qt02_Outro)
                        .questao_03(qt03_Transporte, qt03_Tempo, qt03_ValorGastoDiario, qt03_ValorGastoMensal, qt03_Outro)
                        .questao_04(qt04_InstituicaoEnsinoFundamental)
                        .questao_05(qt05_InstituicaoEnsinoMedio)
                        .questao_06(qt06_AtividadeRemunerada, qt06_ValorBolsaEstagio, qt06_ProjetoIniciacao, qt06_ValorBolsaIniciacao, qt06_ProjetoTreinamento, qt06_ValorBolsaTreinamento, qt06_Outro, qt06_ValorBolsaOutro)
                        .questao_07(qt07_TrabalhoRemunerado, qt07_HorasSemanais, qt07_Salario)
                        .questao_08(qt08_Manutencao, qt08_Outra)
                        .questao_09(qt09_Moradia, qt09_Outra)
                        .questao_10(qt10_ResponsavelFinanceiro, qt10_Outros)
                        .questao_11(qt11_Esgoto, qt11_Agua, qt11_Iluminacao, qt11_Lixo, qt11_Pavimentacao)
                        .questao_12(qt12_Residencia, qt12_Outro)
                        .questao_13(qt13_Imovel, qt13_ValorAluguel, qt13_ValorPrestacao, qt13_Nome, qt13_Outro)
                        .questao_14(qt14_Acabamento)
                        .questao_15(qt15_OutrosImoveis, qt15_DescricaoImoveis)
                        .questao_16(qt16_QuantCarro, qt16_QuantTV, qt16_QuantMaqLavar, qt16_QuantGeladeira, qt16_QuantTVCabo, qt16_QuantComputador, qt16_QuantInternetPaga, qt16_QuantEmpregadaMensalista, qt16_QuantEmpregadaDiarista, qt16_QuantBanheiro, qt16_QuantQuarto)
                        .questao_17(qt17_ProblemaSaude)
                        .questao_18(qt18_AluguelImoveis, qt18_PensaoMorte, qt18_PensaoAlimenticia, qt18_AjudaTerceiros, qt18_BeneficiosSociais, qt18_OutraRenda, qt18_NomeOutraRenda, qt18_TotalRenda, qt18_NumeroResidentes)
                        .questao_19(qt19_ValorAgua, qt19_ValorLuz, qt19_ValorTelefone, qt19_ValorCondominio, qt19_ValorMensalidadeEscolar, qt19_ValorAlimentacao, qt19_ValorSaude, qt19_ValorTransporte, qt19_ValorIptuAnual, qt19_ValorAluguel, qt19_ValorPensao, qt19_ValorOutros)
                        .questao_20(qt20_ValorAgua, qt20_ValorLuz, qt20_ValorTelefone, qt20_ValorCondominio, qt20_ValorAluguel, qt20_ValorIptuAnual)
                        .questao_21(qt21_Esclarecimentos);
                FormularioDAO.getInstance().operacao(formulario, "gravar", codFormulario);
            }else if(operacao.equals("Editar")){
                formulario.setQt01_Resposta(qt01_Resposta);
                formulario.setQt01_Nome(qt01_Nome);
                formulario.setQt01_Parentesco(qt01_Parentesco);
                formulario.setQt01_Programa(qt01_Programa);
                formulario.setQt01_Ano(qt01_Ano);
                formulario.setQt02_Alimentacao(qt02_Alimentacao);
                formulario.setQt02_Manutencao(qt02_Manutencao);
                formulario.setQt02_Moradia(qt02_Moradia);
                formulario.setQt02_Transporte(qt02_Transporte);
                formulario.setQt02_Outro(qt02_Outro);
                formulario.setQt03_Transporte(qt03_Transporte);
                formulario.setQt03_Tempo(qt03_Tempo);
                formulario.setQt03_ValorGastoDiario(qt03_ValorGastoDiario);
                formulario.setQt03_ValorGastoMensal(qt03_ValorGastoMensal);
                formulario.setQt03_Outro(qt03_Outro);
                formulario.setQt04_InstituicaoEnsinoFundamental(qt04_InstituicaoEnsinoFundamental);
                formulario.setQt05_InstituicaoEnsinoMedio(qt05_InstituicaoEnsinoMedio);
                formulario.setQt06_AtividadeRemunerada(qt06_AtividadeRemunerada);
                formulario.setQt06_ValorBolsaEstagio(qt06_ValorBolsaEstagio);
                formulario.setQt06_ProjetoIniciacao(qt06_ProjetoIniciacao);
                formulario.setQt06_ValorBolsaIniciacao(qt06_ValorBolsaIniciacao);
                formulario.setQt06_ProjetoTreinamento(qt06_ProjetoTreinamento);
                formulario.setQt06_ValorBolsaTreinamento(qt06_ValorBolsaTreinamento);
                formulario.setQt06_Outro(qt06_Outro);
                formulario.setQt06_ValorBolsaOutro(qt06_ValorBolsaOutro);
                formulario.setQt07_TrabalhoRemunerado(qt07_TrabalhoRemunerado);
                formulario.setQt07_HorasSemanais(qt07_HorasSemanais);
                formulario.setQt07_Salario(qt07_Salario);
                formulario.setQt08_Manutencao(qt08_Manutencao);
                formulario.setQt08_Outra(qt08_Outra);
                formulario.setQt09_Moradia(qt09_Moradia);
                formulario.setQt09_Outra(qt09_Outra);
                formulario.setQt10_ResponsavelFinanceiro(qt10_ResponsavelFinanceiro);
                formulario.setQt10_Outros(qt10_Outros);
                formulario.setQt11_Esgoto(qt11_Esgoto);
                formulario.setQt11_Agua(qt11_Agua);
                formulario.setQt11_Iluminacao(qt11_Iluminacao);
                formulario.setQt11_Lixo(qt11_Lixo);
                formulario.setQt11_Pavimentacao(qt11_Pavimentacao);
                formulario.setQt12_Residencia(qt12_Residencia);
                formulario.setQt12_Outro(qt12_Outro);
                formulario.setQt13_Imovel(qt13_Imovel);
                formulario.setQt13_ValorAluguel(qt13_ValorAluguel);
                formulario.setQt13_ValorPrestacao(qt13_ValorPrestacao);
                formulario.setQt13_Nome(qt13_Nome);
                formulario.setQt13_Outro(qt13_Outro);
                formulario.setQt14_Acabamento(qt14_Acabamento);
                formulario.setQt15_OutrosImoveis(qt15_OutrosImoveis);
                formulario.setQt15_DescricaoImoveis(qt15_DescricaoImoveis);
                formulario.setQt16_QuantCarro(qt16_QuantCarro);
                formulario.setQt16_QuantTV(qt16_QuantTV);
                formulario.setQt16_QuantMaqLavar(qt16_QuantMaqLavar);
                formulario.setQt16_QuantGeladeira(qt16_QuantGeladeira);
                formulario.setQt16_QuantTVCabo(qt16_QuantTVCabo);
                formulario.setQt16_QuantComputador(qt16_QuantComputador);
                formulario.setQt16_QuantInternetPaga(qt16_QuantInternetPaga);
                formulario.setQt16_QuantEmpregadaMensalista(qt16_QuantEmpregadaMensalista);
                formulario.setQt16_QuantEmpregadaDiarista(qt16_QuantEmpregadaDiarista);
                formulario.setQt16_QuantBanheiro(qt16_QuantBanheiro);
                formulario.setQt16_QuantQuarto(qt16_QuantQuarto);
                formulario.setQt17_ProblemaSaude(qt17_ProblemaSaude);
                formulario.setQt18_AluguelImoveis(qt18_AluguelImoveis);
                formulario.setQt18_PensaoMorte(qt18_PensaoMorte);
                formulario.setQt18_PensaoAlimenticia(qt18_PensaoAlimenticia);
                formulario.setQt18_AjudaTerceiros(qt18_AjudaTerceiros);
                formulario.setQt18_BeneficiosSociais(qt18_BeneficiosSociais);
                formulario.setQt18_OutraRenda(qt18_OutraRenda);
                formulario.setQt18_NomeOutraRenda(qt18_NomeOutraRenda);
                formulario.setQt18_TotalRenda(qt18_TotalRenda);
                formulario.setQt18_NumeroResidentes(qt18_NumeroResidentes);
                formulario.setQt19_ValorAgua(qt19_ValorAgua);
                formulario.setQt19_ValorLuz(qt19_ValorLuz);
                formulario.setQt19_ValorTelefone(qt19_ValorTelefone);
                formulario.setQt19_ValorCondominio(qt19_ValorCondominio);
                formulario.setQt19_ValorMensalidadeEscolar(qt19_ValorMensalidadeEscolar);
                formulario.setQt19_ValorAlimentacao(qt19_ValorAlimentacao);
                formulario.setQt19_ValorSaude(qt19_ValorSaude);
                formulario.setQt19_ValorTransporte(qt19_ValorTransporte);
                formulario.setQt19_ValorIptuAnual(qt19_ValorIptuAnual);
                formulario.setQt19_ValorAluguel(qt19_ValorAluguel);
                formulario.setQt19_ValorPensao(qt19_ValorPensao);
                formulario.setQt19_ValorOutros(qt19_ValorOutros);
                formulario.setQt20_ValorAgua(qt20_ValorAgua);
                formulario.setQt20_ValorLuz(qt20_ValorLuz);
                formulario.setQt20_ValorTelefone(qt20_ValorTelefone);
                formulario.setQt20_ValorCondominio(qt20_ValorCondominio);
                formulario.setQt20_ValorAluguel(qt20_ValorAluguel);
                formulario.setQt20_ValorIptuAnual(qt20_ValorIptuAnual);
                formulario.setQt21_Esclarecimentos(qt21_Esclarecimentos);
                FormularioDAO.getInstance().operacao(formulario, "alterar", codFormulario);
            }else if (operacao.equals("Excluir")){
                FormularioDAO.getInstance().operacao(formulario, "excluir", codFormulario);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
