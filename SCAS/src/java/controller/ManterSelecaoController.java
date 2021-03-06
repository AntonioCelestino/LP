package controller;

import dao.ModalidadeDAO;
import dao.SelecaoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Modalidade;
import modelo.Selecao;

public class ManterSelecaoController extends ProcessRequestController {
    
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
            Logger.getLogger(ManterSelecaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterSelecaoController.class.getName()).log(Level.SEVERE, null, ex);
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
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("modalidades", ModalidadeDAO.obterModalidades());
            if(!operacao.equals("Incluir")){
                int codSelecao = Integer.parseInt(request.getParameter("codSelecao"));
                selecao = (Selecao) SelecaoDAO.getInstance().obterClasse(Selecao.class, codSelecao);
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
    
    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            if(operacao.equals("Incluir")){
                selecao = new Selecao();
                selecao.setCodSelecao(Integer.parseInt(request.getParameter("txtCodSelecao")));
            }
            int codModalidade = Integer.parseInt(request.getParameter("optModalidade"));
            Modalidade modalidade = null;
            if(codModalidade != 0){
                modalidade = (Modalidade) ModalidadeDAO.getInstance().obterClasse(Modalidade.class, codModalidade);
            }
            selecao.setDataInicioSelecao(request.getParameter("txtDataInicioSelecao"));
            selecao.setDataFimSelecao(request.getParameter("txtDataFimSelecao"));
            selecao.setNumeroEdital(request.getParameter("txtNumeroEdital"));
            selecao.setModalidade(modalidade);
            SelecaoDAO.getInstance().operacao(selecao, operacao, selecao.getCodSelecao());
            RequestDispatcher view = request.getRequestDispatcher("PesquisaSelecaoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
