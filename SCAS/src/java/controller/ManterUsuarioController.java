/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Nathan
 */
public class ManterUsuarioController extends HttpServlet {

    private Usuario usuario;
    
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
                int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
                usuario = UsuarioDAO.obterUsuario(codUsuario);
                request.setAttribute("usuario", usuario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterUsuario.jsp");
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
            String senha = request.getParameter("txtSenha");
            
            if(operacao.equals("Incluir")){
                usuario = new Usuario(codUsuario, dataNasc, nome, sexo, cpf, identidade, telefoneFixo, telefoneCelular, email, endereco, numero, complemento, bairro, cep, cidade, uf, login, senha);
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
                usuario.setSenha(senha);
                UsuarioDAO.getInstance().alterar(usuario);
            }else if (operacao.equals("Excluir")){
                UsuarioDAO.getInstance().excluir(usuario);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaUsuarioController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
