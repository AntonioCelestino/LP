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
            int codAluno = Integer.parseInt(request.getParameter("optAluno"));
            int codSelecao = Integer.parseInt(request.getParameter("optSelecao"));
            Aluno aluno = null;
            Selecao selecao = null;
            if(codAluno != 0){
                aluno = (Aluno) AlunoDAO.getInstance().obterClasse(Aluno.class, codAluno);
            }
            if(codSelecao != 0){
                selecao = (Selecao) SelecaoDAO.getInstance().obterClasse(Selecao.class, codSelecao);
            }
            formulario.setAluno(aluno);
            formulario.setSelecao(selecao);
            formulario.setQt01_Resposta(request.getParameter("opt_qt01_Resposta"));
            formulario.setQt01_Nome(request.getParameter("txt_qt01_Nome"));
            formulario.setQt01_Parentesco(request.getParameter("txt_qt01_Parentesco"));
            formulario.setQt01_Programa(request.getParameter("txt_qt01_Programa"));
            formulario.setQt01_Ano(request.getParameter("txt_qt01_Ano"));
            formulario.setQt02_Alimentacao(request.getParameter("opt_qt02_Alimentacao"));
            formulario.setQt02_Manutencao(request.getParameter("opt_qt02_Manutencao"));
            formulario.setQt02_Moradia(request.getParameter("opt_qt02_Moradia"));
            formulario.setQt02_Transporte(request.getParameter("opt_qt02_Transporte"));
            formulario.setQt02_Outro(request.getParameter("txt_qt02_Outro"));
            formulario.setQt03_Transporte(request.getParameter("opt_qt03_Transporte"));
            formulario.setQt03_Tempo(request.getParameter("txt_qt03_Tempo"));
            formulario.setQt03_ValorGastoDiario(Float.parseFloat(verificaCampo(request.getParameter("txt_qt03_ValorGastoDiario"))));
            formulario.setQt03_ValorGastoMensal(Float.parseFloat(verificaCampo(request.getParameter("txt_qt03_ValorGastoMensal"))));
            formulario.setQt03_Outro(request.getParameter("txt_qt03_Outro"));
            formulario.setQt04_InstituicaoEnsinoFundamental(request.getParameter("opt_qt04_InstituicaoEnsinoFundamental"));
            formulario.setQt05_InstituicaoEnsinoMedio(request.getParameter("opt_qt05_InstituicaoEnsinoMedio"));
            formulario.setQt06_AtividadeRemunerada(request.getParameter("opt_qt06_AtividadeRemunerada"));
            formulario.setQt06_ValorBolsaEstagio(Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaEstagio"))));
            formulario.setQt06_ProjetoIniciacao(request.getParameter("txt_qt06_ProjetoIniciacao"));
            formulario.setQt06_ValorBolsaIniciacao(Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaIniciacao"))));
            formulario.setQt06_ProjetoTreinamento(request.getParameter("txt_qt06_ProjetoTreinamento"));
            formulario.setQt06_ValorBolsaTreinamento(Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaTreinamento"))));
            formulario.setQt06_Outro(request.getParameter("txt_qt06_Outro"));
            formulario.setQt06_ValorBolsaOutro(Float.parseFloat(verificaCampo(request.getParameter("txt_qt06_ValorBolsaOutro"))));
            formulario.setQt07_TrabalhoRemunerado(request.getParameter("opt_qt07_TrabalhoRemunerado"));
            formulario.setQt07_HorasSemanais(request.getParameter("txt_qt07_HorasSemanais"));
            formulario.setQt07_Salario(Float.parseFloat(verificaCampo(request.getParameter("txt_qt07_Salario"))));
            formulario.setQt08_Manutencao(request.getParameter("opt_qt08_Manutencao"));
            formulario.setQt08_Outra(request.getParameter("txt_qt08_Outra"));
            formulario.setQt09_Moradia(request.getParameter("opt_qt09_Moradia"));
            formulario.setQt09_Outra(request.getParameter("txt_qt09_Outra"));
            formulario.setQt10_ResponsavelFinanceiro(request.getParameter("opt_qt10_ResponsavelFinanceiro"));
            formulario.setQt10_Outros(request.getParameter("txt_qt10_Outros"));
            formulario.setQt11_Esgoto(request.getParameter("opt_qt11_Esgoto"));
            formulario.setQt11_Agua(request.getParameter("opt_qt11_Agua"));
            formulario.setQt11_Iluminacao(request.getParameter("opt_qt11_Iluminacao"));
            formulario.setQt11_Lixo(request.getParameter("opt_qt11_Lixo"));
            formulario.setQt11_Pavimentacao(request.getParameter("opt_qt11_Pavimentacao"));
            formulario.setQt12_Residencia(request.getParameter("opt_qt12_Residencia"));
            formulario.setQt12_Outro(request.getParameter("txt_qt12_Outro"));
            formulario.setQt13_Imovel(request.getParameter("opt_qt13_Imovel"));
            formulario.setQt13_ValorAluguel(Float.parseFloat(verificaCampo(request.getParameter("txt_qt13_ValorAluguel"))));
            formulario.setQt13_ValorPrestacao(Float.parseFloat(verificaCampo(request.getParameter("txt_qt13_ValorPrestacao"))));
            formulario.setQt13_Nome(request.getParameter("txt_qt13_Nome"));
            formulario.setQt13_Outro(request.getParameter("txt_qt13_Outro"));
            formulario.setQt14_Acabamento(request.getParameter("opt_qt14_Acabamento"));
            formulario.setQt15_OutrosImoveis(request.getParameter("opt_qt15_OutrosImoveis"));
            formulario.setQt15_DescricaoImoveis(request.getParameter("txt_qt15_DescricaoImoveis"));
            formulario.setQt16_QuantCarro(Integer.parseInt(request.getParameter("txt_qt16_QuantCarro")));
            formulario.setQt16_QuantTV(Integer.parseInt(request.getParameter("txt_qt16_QuantTV")));
            formulario.setQt16_QuantMaqLavar(Integer.parseInt(request.getParameter("txt_qt16_QuantMaqLavar")));
            formulario.setQt16_QuantGeladeira(Integer.parseInt(request.getParameter("txt_qt16_QuantGeladeira")));
            formulario.setQt16_QuantTVCabo(Integer.parseInt(request.getParameter("txt_qt16_QuantTVCabo")));
            formulario.setQt16_QuantComputador(Integer.parseInt(request.getParameter("txt_qt16_QuantComputador")));
            formulario.setQt16_QuantInternetPaga(Integer.parseInt(request.getParameter("txt_qt16_QuantInternetPaga")));
            formulario.setQt16_QuantEmpregadaMensalista(Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaMensalista")));
            formulario.setQt16_QuantEmpregadaDiarista(Integer.parseInt(request.getParameter("txt_qt16_QuantEmpregadaDiarista")));
            formulario.setQt16_QuantBanheiro(Integer.parseInt(request.getParameter("txt_qt16_QuantBanheiro")));
            formulario.setQt16_QuantQuarto(Integer.parseInt(request.getParameter("txt_qt16_QuantQuarto")));
            formulario.setQt17_ProblemaSaude(request.getParameter("opt_qt17_ProblemaSaude"));
            formulario.setQt18_AluguelImoveis(Float.parseFloat(request.getParameter("txt_qt18_AluguelImoveis")));
            formulario.setQt18_PensaoMorte(Float.parseFloat(request.getParameter("txt_qt18_PensaoMorte")));
            formulario.setQt18_PensaoAlimenticia(Float.parseFloat(request.getParameter("txt_qt18_PensaoAlimenticia")));
            formulario.setQt18_AjudaTerceiros(Float.parseFloat(request.getParameter("txt_qt18_AjudaTerceiros")));
            formulario.setQt18_BeneficiosSociais(Float.parseFloat(request.getParameter("txt_qt18_BeneficiosSociais")));
            formulario.setQt18_OutraRenda(Float.parseFloat(request.getParameter("txt_qt18_OutraRenda")));
            formulario.setQt18_NomeOutraRenda(request.getParameter("txt_qt18_NomeOutraRenda"));
            formulario.setQt18_TotalRenda(Float.parseFloat(request.getParameter("txt_qt18_TotalRenda")));
            formulario.setQt18_NumeroResidentes(Integer.parseInt(request.getParameter("txt_qt18_NumeroResidentes")));
            formulario.setQt19_ValorAgua(Float.parseFloat(request.getParameter("txt_qt19_ValorAgua")));
            formulario.setQt19_ValorLuz(Float.parseFloat(request.getParameter("txt_qt19_ValorLuz")));
            formulario.setQt19_ValorTelefone(Float.parseFloat(request.getParameter("txt_qt19_ValorTelefone")));
            formulario.setQt19_ValorCondominio(Float.parseFloat(request.getParameter("txt_qt19_ValorCondominio")));
            formulario.setQt19_ValorMensalidadeEscolar(Float.parseFloat(request.getParameter("txt_qt19_ValorMensalidadeEscolar")));
            formulario.setQt19_ValorAlimentacao(Float.parseFloat(request.getParameter("txt_qt19_ValorAlimentacao")));
            formulario.setQt19_ValorSaude(Float.parseFloat(request.getParameter("txt_qt19_ValorSaude")));
            formulario.setQt19_ValorTransporte(Float.parseFloat(request.getParameter("txt_qt19_ValorTransporte")));
            formulario.setQt19_ValorIptuAnual(Float.parseFloat(request.getParameter("txt_qt19_ValorIptuAnual")));
            formulario.setQt19_ValorAluguel(Float.parseFloat(request.getParameter("txt_qt19_ValorAluguel")));
            formulario.setQt19_ValorPensao(Float.parseFloat(request.getParameter("txt_qt19_ValorPensao")));
            formulario.setQt19_ValorOutros(Float.parseFloat(request.getParameter("txt_qt19_ValorOutros")));
            formulario.setQt20_ValorAgua(Float.parseFloat(request.getParameter("txt_qt20_ValorAgua")));
            formulario.setQt20_ValorLuz(Float.parseFloat(request.getParameter("txt_qt20_ValorLuz")));
            formulario.setQt20_ValorTelefone(Float.parseFloat(request.getParameter("txt_qt20_ValorTelefone")));
            formulario.setQt20_ValorCondominio(Float.parseFloat(request.getParameter("txt_qt20_ValorCondominio")));
            formulario.setQt20_ValorAluguel(Float.parseFloat(request.getParameter("txt_qt20_ValorAluguel")));
            formulario.setQt20_ValorIptuAnual(Float.parseFloat(request.getParameter("txt_qt20_ValorIptuAnual")));
            formulario.setQt21_Esclarecimentos(request.getParameter("txt_qt21_Esclarecimentos"));
            if(operacao.equals("Incluir")){
                formulario.setCodFormulario(codAluno + codSelecao);
            }
            FormularioDAO.getInstance().operacao(formulario, operacao, formulario.getCodFormulario());
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
