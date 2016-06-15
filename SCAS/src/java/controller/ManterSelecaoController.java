package controller;

import dao.ModalidadeDAO;
import dao.SelecaoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Modalidade;
import modelo.Selecao;

public class ManterSelecaoController extends HttpServlet {
    
    private Selecao selecao;
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
        if(acao.equals("prepararOperacao")){
            prepararOperacao(request, response);
        } 
        if(acao.equals("confirmarOperacao")){
            confirmarOperacao(request, response);
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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("modalidades", ModalidadeDAO.obterModalidades());
            if(!operacao.equals("Incluir")){
                int codSelecao = Integer.parseInt(request.getParameter("codSelecao"));
                selecao = SelecaoDAO.obterSelecao(codSelecao);
                request.setAttribute("selecao", selecao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterSelecao.jsp");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException e){
            throw new ServletException(e);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            int codSelecao = Integer.parseInt(request.getParameter("txtCodSelecao"));
            String dataInicioSelecao = request.getParameter("txtDataInicioSelecao");
            String dataFimSelecao = request.getParameter("txtDataFimSelecao");
            String numeroEdital = request.getParameter("txtNumeroEdital");
            int codModalidade = Integer.parseInt(request.getParameter("optModalidade"));
            Modalidade modalidade = null;
            if(codModalidade != 0){
                modalidade = ModalidadeDAO.obterModalidade(codModalidade);
            }
            if(operacao.equals("Incluir")){
                selecao = new Selecao(codSelecao, dataInicioSelecao, dataFimSelecao, numeroEdital, modalidade);
                SelecaoDAO.getInstance().gravar(selecao);
            }else if(operacao.equals("Editar")){
                selecao.setDataInicioSelecao(dataInicioSelecao);
                selecao.setDataFimSelecao(dataFimSelecao);
                selecao.setNumeroEdital(numeroEdital);
                selecao.setModalidade(modalidade);
                SelecaoDAO.getInstance().alterar(selecao);
            }else if (operacao.equals("Excluir")){
                SelecaoDAO.getInstance().excluir(selecao);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaSelecaoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
