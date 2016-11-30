package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Curso;
import modelo.Usuario;

public class ManterAlunoController extends HttpServlet {

    private Aluno aluno;
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
            request.setAttribute("cursos", CursoDAO.obterCursos());
            request.setAttribute("usuarios", UsuarioDAO.obterUsuarios());
            if(!operacao.equals("Incluir")){
                int codAluno = Integer.parseInt(request.getParameter("codAluno"));
                aluno = AlunoDAO.obterAluno(codAluno);
                request.setAttribute("aluno", aluno);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
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
            int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
            int anoIngresso = Integer.parseInt(request.getParameter("txtAnoIngresso"));
            String periodoCurso = request.getParameter("txtPeriodoCurso");
            String familia_endereco = request.getParameter("txtFamiliaEndereco");
            String familia_numero = request.getParameter("txtFamiliaNumero");
            String familia_complemento = request.getParameter("txtFamiliaComplemento");
            String familia_bairro = request.getParameter("txtFamiliaBairro");
            String familia_cep = request.getParameter("txtFamiliaCep");
            String familia_cidade = request.getParameter("txtFamiliaCidade");
            String familia_uf = request.getParameter("txtFamiliaUF");
            int codCurso = Integer.parseInt(request.getParameter("optCurso"));
            int codUsuario = Integer.parseInt(request.getParameter("optUsuario"));
            Curso curso = null;
            Usuario usuario = null;
            if(codCurso != 0){
                curso = CursoDAO.obterCurso(codCurso);
            }
            if(codUsuario != 0){
                usuario = UsuarioDAO.obterUsuario(codUsuario);
            }
            if(operacao.equals("Incluir")){
                aluno = new Aluno(matricula, anoIngresso, periodoCurso, familia_endereco, familia_numero, familia_complemento, familia_bairro, familia_cep, familia_cidade, familia_uf, curso, usuario);
                AlunoDAO.getInstance().operacao(aluno, "gravar");
            }else if(operacao.equals("Editar")){
                aluno.setAnoIngresso(anoIngresso);
                aluno.setPeriodoCurso(periodoCurso);
                aluno.setFamilia_endereco(familia_endereco);
                aluno.setFamilia_numero(familia_numero);
                aluno.setFamilia_complemento(familia_complemento);
                aluno.setFamilia_bairro(familia_bairro);
                aluno.setFamilia_cep(familia_cep);
                aluno.setFamilia_cidade(familia_cidade);
                aluno.setFamilia_uf(familia_uf);
                aluno.setCurso(curso);
                aluno.setUsuario(usuario);
                AlunoDAO.getInstance().operacao(aluno, "alterar");
            }else if (operacao.equals("Excluir")){
                AlunoDAO.getInstance().operacao(aluno, "excluir");
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
