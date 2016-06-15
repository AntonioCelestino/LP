package controller;

import dao.FormularioDAO;
import dao.RendaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Renda;
import modelo.Formulario;

public class ManterRendaController extends HttpServlet {
    
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
                int codRenda = Integer.parseInt(request.getParameter("codRenda"));
                renda = RendaDAO.obterRenda(codRenda);
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
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            int codRenda = Integer.parseInt(request.getParameter("optFormulario") + request.getParameter("txtCodRenda"));
            int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
            String qt18_Nome = request.getParameter("txt_qt18_Nome");
            String qt18_DataNasc = request.getParameter("txt_qt18_DataNasc");
            String qt18_EstadoCivil = request.getParameter("opt_qt18_EstadoCivil");
            String qt18_Parentesco = request.getParameter("txt_qt18_Parentesco");
            String qt18_Escolaridade = request.getParameter("opt_qt18_Escolaridade");
            String qt18_Trabalho = request.getParameter("opt_qt18_Trabalho");
            String qt18_Ocupacao = request.getParameter("txt_qt18_Ocupacao");
            float qt18_RendaBruta = Float.parseFloat(request.getParameter("txt_qt18_RendaBruta"));
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = FormularioDAO.obterFormulario(codFormulario);
            }
            if(operacao.equals("Incluir")){
                renda = new Renda(codRenda, formulario, qt18_Nome, qt18_DataNasc, qt18_EstadoCivil, qt18_Parentesco, qt18_Escolaridade, qt18_Trabalho, qt18_Ocupacao, qt18_RendaBruta);
                RendaDAO.getInstance().gravar(renda);
            }else if(operacao.equals("Editar")){
                renda.setFormulario(formulario);
                renda.setQt18_Nome(qt18_Nome);
                renda.setQt18_DataNasc(qt18_DataNasc);
                renda.setQt18_EstadoCivil(qt18_EstadoCivil);
                renda.setQt18_Parentesco(qt18_Parentesco);
                renda.setQt18_Escolaridade(qt18_Escolaridade);
                renda.setQt18_Trabalho(qt18_Trabalho);
                renda.setQt18_Ocupacao(qt18_Ocupacao);
                renda.setQt18_RendaBruta(qt18_RendaBruta);
                RendaDAO.getInstance().alterar(renda);
            }else if (operacao.equals("Excluir")){
                RendaDAO.getInstance().excluir(renda);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRendaController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

}
