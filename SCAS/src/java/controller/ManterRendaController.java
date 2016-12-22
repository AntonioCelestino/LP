package controller;

import dao.FormularioDAO;
import dao.RendaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Renda;
import modelo.Formulario;

public class ManterRendaController extends ProcessRequestController {
    
    private Renda renda;
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
            Logger.getLogger(ManterRendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterRendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            request.setAttribute("formularios", FormularioDAO.obterFormularios());
            if(!operacao.equals("Incluir")){
                int codRenda = Integer.parseInt(request.getParameter("codRenda"));
                renda = (Renda) RendaDAO.getInstance().obterClasse(Renda.class, codRenda);
                String r = Integer.toString(codRenda);
                String f = Integer.toString(renda.getFormulario().getCodFormulario());
                renda.setCodRenda(Integer.parseInt(r.substring(f.length())));
                request.setAttribute("formulario", renda.getFormulario());
                request.setAttribute("renda", renda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterRenda.jsp");
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
            int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
            int codRenda = Integer.parseInt(codFormulario + request.getParameter("txtCodRenda"));
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = (Formulario) FormularioDAO.getInstance().obterClasse(Formulario.class, codFormulario);
            }
            renda.setFormulario(formulario);
            renda.setQt18_Nome(request.getParameter("txt_qt18_Nome"));
            renda.setQt18_DataNasc(request.getParameter("txt_qt18_DataNasc"));
            renda.setQt18_EstadoCivil(request.getParameter("opt_qt18_EstadoCivil"));
            renda.setQt18_Parentesco(request.getParameter("txt_qt18_Parentesco"));
            renda.setQt18_Escolaridade(request.getParameter("opt_qt18_Escolaridade"));
            renda.setQt18_Trabalho(request.getParameter("opt_qt18_Trabalho"));
            renda.setQt18_Ocupacao(request.getParameter("txt_qt18_Ocupacao"));
            renda.setQt18_RendaBruta(Float.parseFloat(request.getParameter("txt_qt18_RendaBruta")));
            if(operacao.equals("Incluir")){
                renda.setCodRenda(codRenda);
            }
            RendaDAO.getInstance().operacao(renda, operacao, codRenda);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRendaController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
