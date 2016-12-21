package controller;

import dao.ModalidadeDAO;
import dao.RecursoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Modalidade;
import modelo.Recurso;

public class ManterRecursoController extends ProcessRequestController {

    private Recurso recurso;
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
            Logger.getLogger(ManterRecursoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterRecursoController.class.getName()).log(Level.SEVERE, null, ex);
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
                int codRecurso = Integer.parseInt(request.getParameter("codRecurso"));
                recurso = (Recurso) RecursoDAO.getInstance().obterClasse(Recurso.class, codRecurso);
                request.setAttribute("recurso", recurso);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterRecurso.jsp");
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
            int codRecurso = Integer.parseInt(request.getParameter("txtCodRecurso"));
            int ano = Integer.parseInt(request.getParameter("txtAno"));
            float creditos = Float.parseFloat(request.getParameter("txtCreditos"));
            float debitos = Float.parseFloat(request.getParameter("txtDebitos"));
            float saldo = Float.parseFloat(request.getParameter("txtSaldo"));
            int codModalidade = Integer.parseInt(request.getParameter("optModalidade"));
            Modalidade modalidade = null;
            if(codModalidade != 0){
                modalidade = (Modalidade) ModalidadeDAO.getInstance().obterClasse(Modalidade.class, codModalidade);
            }
            if(operacao.equals("Incluir")){
                recurso = new Recurso(codRecurso, ano, creditos, debitos, saldo, modalidade);
                RecursoDAO.getInstance().operacao(recurso, "gravar", codRecurso);
            }else if(operacao.equals("Editar")){
                recurso.setAno(ano);
                recurso.setCreditos(creditos);
                recurso.setDebitos(debitos);
                recurso.setSaldo(saldo);
                recurso.setModalidade(modalidade);
                RecursoDAO.getInstance().operacao(recurso, "alterar", codRecurso);
            }else if (operacao.equals("Excluir")){
                RecursoDAO.getInstance().operacao(recurso, "excluir", codRecurso);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRecursoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
