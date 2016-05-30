/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Curso;
import modelo.Usuario;

/**
 *
 * @author Nathan
 */
public class ManterAlunoController extends HttpServlet {

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
        if(acao.equals("prepararIncluir")){
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if(acao.equals("prepararEditar")){
                    prepararEditar(request, response);
                } else {
                    if (acao.equals("confirmarEditar")) {
                        confirmarEditar(request, response);
                    } else {
                        if(acao.equals("prepararExcluir")){
                            prepararExcluir(request, response);
                        } else {
                            if (acao.equals("confirmarExcluir")) {
                                confirmarExcluir(request, response);
                            }
                        }
                    }   
                }
            }
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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException {
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
        try{
            Usuario usuario = null;
            if(codUsuario != 0){
                usuario = Usuario.obterUsuario(codUsuario);
            }
            Curso curso = null;
            if(codCurso != 0){
                curso = Curso.obterCurso(codCurso);
            }
            Aluno aluno = new Aluno(matricula, anoIngresso, periodoCurso, familia_endereco, familia_numero, familia_complemento, familia_bairro, familia_cep, familia_cidade, familia_uf, curso, usuario);
            aluno.setCodUsuario(codUsuario);
            aluno.setCodCurso(codCurso);
            aluno.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Editar");
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            int matricula = Integer.parseInt(request.getParameter("codAluno"));
            Aluno aluno = Aluno.obterAluno(matricula);
            request.setAttribute("aluno", aluno);
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("cursos", Curso.obterCursos());
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            int matricula = Integer.parseInt(request.getParameter("codAluno"));
            Aluno aluno = Aluno.obterAluno(matricula);
            request.setAttribute("aluno", aluno);
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
        try{
            Usuario usuario = null;
            if(codUsuario != 0){
                usuario = Usuario.obterUsuario(codUsuario);
            }
            Curso curso = null;
            if(codCurso != 0){
                curso = Curso.obterCurso(codCurso);
            }
            Aluno aluno = new Aluno(matricula, anoIngresso, periodoCurso, familia_endereco, familia_numero, familia_complemento, familia_bairro, familia_cep, familia_cidade, familia_uf, curso, usuario);
            aluno.setCodUsuario(codUsuario);
            aluno.setCodCurso(codCurso);
            aluno.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
        try{
            Usuario usuario = null;
            if(codUsuario != 0){
                usuario = Usuario.obterUsuario(codUsuario);
            }
            Curso curso = null;
            if(codCurso != 0){
                curso = Curso.obterCurso(codCurso);
            }
            Aluno aluno = new Aluno(matricula, anoIngresso, periodoCurso, familia_endereco, familia_numero, familia_complemento, familia_bairro, familia_cep, familia_cidade, familia_uf, curso, usuario);
            aluno.setCodUsuario(codUsuario);
            aluno.setCodCurso(codCurso);
            aluno.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch (IOException ex){
            throw new ServletException(ex);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException ex){
            throw new ServletException(ex);
        }catch (ServletException ex){
            throw ex;
        }
    }
}
