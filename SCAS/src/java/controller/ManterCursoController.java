package controller;

import dao.CursoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

public class ManterCursoController extends HttpServlet {

    private Curso curso;
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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if(!operacao.equals("Incluir")){
                int codCurso = Integer.parseInt(request.getParameter("codCurso"));
                curso = CursoDAO.obterCurso(codCurso);
                request.setAttribute("curso", curso);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
            throw ex;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String operacao = request.getParameter("operacao");
            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            String nome = request.getParameter("txtNomeCurso");
            String tipoEnsino = request.getParameter("optTipoEnsino");
            String turno = request.getParameter("optTurno"); 
            if(operacao.equals("Incluir")){
                curso = new Curso(codCurso, nome, tipoEnsino, turno);
                CursoDAO.getInstance().operacao(curso, "gravar");
            }else if(operacao.equals("Editar")){
                curso.setNome(nome);
                curso.setTipoEnsino(tipoEnsino);
                curso.setTurno(turno);
                CursoDAO.getInstance().operacao(curso, "alterar");
            }else if (operacao.equals("Excluir")){
                CursoDAO.getInstance().operacao(curso, "excluir");
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

}
