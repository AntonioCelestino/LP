package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Curso;
import modelo.Usuario;

public class ManterAlunoController extends ProcessRequestController {

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
            Logger.getLogger(ManterAlunoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAlunoController.class.getName()).log(Level.SEVERE, null, ex);
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
            request.setAttribute("cursos", CursoDAO.obterCursos());
            request.setAttribute("usuarios", UsuarioDAO.obterUsuarios());
            if(!operacao.equals("Incluir")){
                int codAluno = Integer.parseInt(request.getParameter("codAluno"));
                aluno = (Aluno) AlunoDAO.getInstance().obterClasse(Aluno.class, codAluno);
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
    
    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String operacao = request.getParameter("operacao");
            if(operacao.equals("Incluir")){
                aluno = new Aluno();
                aluno.setMatricula(Integer.parseInt(request.getParameter("txtMatricula")));
            }
            int codCurso = Integer.parseInt(request.getParameter("optCurso"));
            int codUsuario = Integer.parseInt(request.getParameter("optUsuario"));
            Curso curso = null;
            Usuario usuario = null;
            if(codCurso != 0){
                curso = (Curso) CursoDAO.getInstance().obterClasse(Curso.class, codCurso);
            }
            if(codUsuario != 0){
                usuario = (Usuario) UsuarioDAO.getInstance().obterClasse(Usuario.class, codUsuario);
            }
            aluno.setAnoIngresso(Integer.parseInt(request.getParameter("txtAnoIngresso")));
            aluno.setPeriodoCurso(request.getParameter("txtPeriodoCurso"));
            aluno.setFamilia_endereco(request.getParameter("txtFamiliaEndereco"));
            aluno.setFamilia_numero(request.getParameter("txtFamiliaNumero"));
            aluno.setFamilia_complemento(request.getParameter("txtFamiliaComplemento"));
            aluno.setFamilia_bairro(request.getParameter("txtFamiliaBairro"));
            aluno.setFamilia_cep(request.getParameter("txtFamiliaCep"));
            aluno.setFamilia_cidade(request.getParameter("txtFamiliaCidade"));
            aluno.setFamilia_uf(request.getParameter("txtFamiliaUF"));
            aluno.setCurso(curso);
            aluno.setUsuario(usuario);
            AlunoDAO.getInstance().operacao(aluno, operacao, aluno.getMatricula());
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
