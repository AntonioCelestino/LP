package controller;

import dao.DoencaDAO;
import dao.FormularioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Doenca;
import modelo.Formulario;

public class ManterDoencaController extends HttpServlet {

    private Doenca doenca;
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
                int codDoenca = Integer.parseInt(request.getParameter("codDoenca"));
                doenca = DoencaDAO.obterDoenca(codDoenca);
                String d = Integer.toString(codDoenca);
                String f = Integer.toString(doenca.getFormulario().getCodFormulario());
                doenca.setCodDoenca(Integer.parseInt(d.substring(f.length())));
                request.setAttribute("formulario", doenca.getFormulario());
                request.setAttribute("doenca", doenca);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDoenca.jsp");
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
            int codDoenca = Integer.parseInt(request.getParameter("optFormulario") + request.getParameter("txtCodDoenca"));
            int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
            String qt17_Nome = request.getParameter("txt_qt17_Nome");
            String qt17_Doenca = request.getParameter("txt_qt17_Doenca");
            String qt17_Trabalho = request.getParameter("opt_qt17_Trabalho");
            String qt17_Dependencia = request.getParameter("opt_qt17_Dependencia");
            float qt17_Gasto = Float.parseFloat(request.getParameter("txt_qt17_Gasto"));
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = FormularioDAO.obterFormulario(codFormulario);
            }
            if(operacao.equals("Incluir")){
                doenca = new Doenca(codDoenca, formulario, qt17_Nome, qt17_Doenca, qt17_Trabalho, qt17_Dependencia, qt17_Gasto);
                DoencaDAO.getInstance().operacao(doenca, "gravar");
            }else if(operacao.equals("Editar")){
                doenca.setCodDoenca(codDoenca);
                doenca.setFormulario(formulario);
                doenca.setQt17_Nome(qt17_Nome);
                doenca.setQt17_Doenca(qt17_Doenca);
                doenca.setQt17_Trabalho(qt17_Trabalho);
                doenca.setQt17_Dependencia(qt17_Dependencia);
                doenca.setQt17_Gasto(qt17_Gasto);
                DoencaDAO.getInstance().operacao(doenca, "alterar");
            }else if (operacao.equals("Excluir")){
                doenca.setCodDoenca(codDoenca);
                DoencaDAO.getInstance().operacao(doenca, "excluir");
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDoencaController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

}
