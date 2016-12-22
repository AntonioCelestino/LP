package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import util.Criptografia;

public class ManterUsuarioController extends ProcessRequestController {
    private Usuario usuario;
    private String senhaOriginal;
    
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
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            int codUsuarioLogado = Integer.parseInt(request.getParameter("codUsuarioLogado"));
            if(!operacao.equals("Incluir")){
                int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
                usuario = (Usuario) UsuarioDAO.getInstance().obterClasse(Usuario.class, codUsuario);
                senhaOriginal = usuario.getSenha();
                usuario.setSenha("");
                request.setAttribute("usuario", usuario);
            }
            request.setAttribute("codUsuarioLogado", codUsuarioLogado);
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
            throw ex;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        try{
            String operacao = request.getParameter("operacao");
            int codUsuario = Integer.parseInt(request.getParameter("txtCodUsuario"));
            int codUsuarioLogado = Integer.parseInt(request.getParameter("codUsuarioLogado"));
            String senhaAnterior = request.getParameter("txtSenhaAnterior");
            String senha = request.getParameter("txtSenha");
            usuario.setDataNasc(request.getParameter("txtDataNasc"));
            usuario.setNome(request.getParameter("txtNome"));
            usuario.setSexo(request.getParameter("txtSexo"));
            usuario.setCpf(request.getParameter("txtCPF"));
            usuario.setIdentidade(request.getParameter("txtIdentidade"));
            usuario.setTelefoneFixo(request.getParameter("txtTelefoneFixo"));
            usuario.setTelefoneCelular(request.getParameter("txtTelefoneCelular"));
            usuario.setEmail(request.getParameter("txtEmail"));
            usuario.setEndereco(request.getParameter("txtEndereco"));
            usuario.setNumero(request.getParameter("txtNumero"));
            usuario.setComplemento(request.getParameter("txtComplemento"));
            usuario.setBairro(request.getParameter("txtBairro"));
            usuario.setCep(request.getParameter("txtCep"));
            usuario.setCidade(request.getParameter("txtCidade"));
            usuario.setUf(request.getParameter("txtUF"));
            usuario.setLogin(request.getParameter("txtLogin"));
            if(operacao.equals("Editar")){
                if(senha == null && senhaAnterior == null){
                    usuario.setSenha(senhaOriginal);
                }else{
                    if (UsuarioDAO.verificarUsuario(request.getParameter("txtLogin"), Criptografia.criptografar(senhaAnterior))) {
                        usuario.setSenha(Criptografia.criptografar(senha));
                        UsuarioDAO.getInstance().operacao(usuario, operacao, codUsuario);
                    } else {
                        request.setAttribute("operacao", operacao);
                        usuario.setSenha("");
                        request.setAttribute("usuario", usuario);
                        request.setAttribute("codUsuarioLogado", codUsuarioLogado);
                        RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
                        view.forward(request, response);
                    }
                }
            }else{
                if(operacao.equals("Incluir")){
                    usuario.setCodUsuario(codUsuario);
                    Criptografia.criptografar(senha);
                }
                UsuarioDAO.getInstance().operacao(usuario, operacao, codUsuario);
            }
            request.setAttribute("codUsuarioLogado", codUsuarioLogado);
            RequestDispatcher view;
            if(UsuarioDAO.verificarTipoUsuario(codUsuarioLogado, "aluno")){
                request.setAttribute("codUsuario", codUsuario);
                view = request.getRequestDispatcher("/menuAluno.jsp");
            }else{
                view = request.getRequestDispatcher("PesquisaUsuarioController");
            }
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
