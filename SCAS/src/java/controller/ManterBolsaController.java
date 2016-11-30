package controller;

import dao.BolsaDAO;
import dao.FormularioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bolsa;
import modelo.Formulario;

public class ManterBolsaController extends HttpServlet {

    private Bolsa bolsa;
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
            request.setAttribute("formularios", FormularioDAO.obterFormularios());
            if(!operacao.equals("Incluir")){
                int codBolsa = Integer.parseInt(request.getParameter("codBolsa"));
                bolsa = BolsaDAO.obterBolsa(codBolsa);
                request.setAttribute("bolsa", bolsa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterBolsa.jsp");
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
            int codBolsa = Integer.parseInt(request.getParameter("txtCodBolsa"));
            String dataInicio = request.getParameter("txtDataInicio");
            String dataFim = request.getParameter("txtDataFim");
            int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = FormularioDAO.obterFormulario(codFormulario);
            }
            if(operacao.equals("Incluir")){
                bolsa = new Bolsa(codBolsa, dataInicio, dataFim, formulario);
                BolsaDAO.getInstance().operacao(bolsa, "gravar");
            }else if(operacao.equals("Editar")){
                bolsa.setDataInicio(dataInicio);
                bolsa.setDataFim(dataFim);
                bolsa.setFormulario(formulario);
                BolsaDAO.getInstance().operacao(bolsa, "alterar");
            }else if (operacao.equals("Excluir")){
                BolsaDAO.getInstance().operacao(bolsa, "excluir");
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaBolsaController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
