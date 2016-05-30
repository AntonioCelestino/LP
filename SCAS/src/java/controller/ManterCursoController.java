/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

/**
 *
 * @author Nathan
 */
public class ManterCursoController extends HttpServlet {

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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } //catch(ClassNotFoundException ex){
          //  throw new ServletException(ex);
        //}
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String tipoEnsino = request.getParameter("optTipoEnsino");
        String turno = request.getParameter("optTurno"); 
        try{
            Curso curso = new Curso(codCurso, nome, tipoEnsino, turno);
            curso.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            Curso curso = Curso.obterCurso(codCurso);
            request.setAttribute("curso", curso);
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);   
        }catch(ServletException ex){
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
            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
            Curso curso = Curso.obterCurso(codCurso);
            request.setAttribute("curso", curso);
            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
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
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String tipoEnsino = request.getParameter("optTipoEnsino");
        String turno = request.getParameter("optTurno"); 
        try{
            Curso curso = new Curso(codCurso, nome, tipoEnsino, turno);
            curso.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
        int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
        String nome = request.getParameter("txtNomeCurso");
        String tipoEnsino = request.getParameter("optTipoEnsino");
        String turno = request.getParameter("optTurno"); 
        try{
            Curso curso = new Curso(codCurso, nome, tipoEnsino, turno);
            curso.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
