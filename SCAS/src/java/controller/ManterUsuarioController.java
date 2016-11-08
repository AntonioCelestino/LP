/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlunoDAO;
import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bolsa;
import modelo.Modalidade;
import modelo.Usuario;
import util.Criptografia;

/**
 *
 * @author Nathan
 */
public class ManterUsuarioController extends HttpServlet {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            int codUsuarioLogado = Integer.parseInt(request.getParameter("codUsuarioLogado"));
            if(!operacao.equals("Incluir")){
                int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
                usuario = UsuarioDAO.obterUsuario(codUsuario);
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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        try{
            String operacao = request.getParameter("operacao");
            int codUsuarioLogado = Integer.parseInt(request.getParameter("codUsuarioLogado"));
            int codUsuario = Integer.parseInt(request.getParameter("txtCodUsuario"));
            String dataNasc = request.getParameter("txtDataNasc");
            String nome = request.getParameter("txtNome");
            String sexo = request.getParameter("txtSexo");
            String cpf = request.getParameter("txtCPF");
            String identidade = request.getParameter("txtIdentidade");
            String telefoneFixo = request.getParameter("txtTelefoneFixo");
            String telefoneCelular = request.getParameter("txtTelefoneCelular");
            String email = request.getParameter("txtEmail");
            String endereco = request.getParameter("txtEndereco");
            String numero = request.getParameter("txtNumero");
            String complemento = request.getParameter("txtComplemento");
            String bairro = request.getParameter("txtBairro");
            String cep = request.getParameter("txtCep");
            String cidade = request.getParameter("txtCidade");
            String uf = request.getParameter("txtUF");
            String login = request.getParameter("txtLogin");
            String senhaAnterior = request.getParameter("txtSenhaAnterior");
            String senha = request.getParameter("txtSenha");
            
            if(operacao.equals("Incluir")){
                usuario = new Usuario(codUsuario, dataNasc, nome, sexo, cpf, identidade, telefoneFixo, telefoneCelular, email, endereco, numero, 
                        complemento, bairro, cep, cidade, uf, login, Criptografia.criptografar(senha));
                UsuarioDAO.getInstance().gravar(usuario);
            }else if(operacao.equals("Editar")){
                usuario.setDataNasc(dataNasc);
                usuario.setNome(nome);
                usuario.setSexo(sexo);
                usuario.setCpf(cpf);
                usuario.setIdentidade(identidade);
                usuario.setTelefoneFixo(telefoneFixo);
                usuario.setTelefoneCelular(telefoneCelular);
                usuario.setEmail(email);
                usuario.setEndereco(endereco);
                usuario.setNumero(numero);
                usuario.setComplemento(complemento);
                usuario.setBairro(bairro);
                usuario.setCep(cep);
                usuario.setCidade(cidade);
                usuario.setUf(uf);
                usuario.setLogin(login);
                if(senha == null && senhaAnterior == null){
                    usuario.setSenha(senhaOriginal);
                    UsuarioDAO.getInstance().alterar(usuario);
                }else{
                    if (UsuarioDAO.verificarUsuario(login, Criptografia.criptografar(senhaAnterior))) {
                        usuario.setSenha(Criptografia.criptografar(senha));
                        UsuarioDAO.getInstance().alterar(usuario);
                    } else {
                        request.setAttribute("operacao", operacao);
                        usuario.setSenha("");
                        request.setAttribute("usuario", usuario);
                        request.setAttribute("codUsuarioLogado", codUsuarioLogado);
                        RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
                        view.forward(request, response);
                    }
                }
            }else if (operacao.equals("Excluir")){
                UsuarioDAO.getInstance().excluir(usuario);
            }
            if(AlunoDAO.verificarAluno(codUsuarioLogado)){
                request.setAttribute("codUsuario", codUsuario);
                request.setAttribute("codUsuarioLogado", codUsuarioLogado);
                RequestDispatcher view = request.getRequestDispatcher("/menuAluno.jsp");
                view.forward(request, response);
            }else{
                if(FuncionarioDAO.verificarFuncionario(codUsuarioLogado)){
                    request.setAttribute("codUsuarioLogado", codUsuarioLogado);
                    RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
                    view.forward(request, response);
                }else{
                    request.setAttribute("codUsuarioLogado", codUsuarioLogado);
                    RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
                    view.forward(request, response);
                }
            }
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
