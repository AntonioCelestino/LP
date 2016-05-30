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
import modelo.Renda;
import modelo.Formulario;

/**
 *
 * @author Nathan
 */
public class ManterRendaController extends HttpServlet {

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
            Logger.getLogger(ManterRendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterRendaController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("formularios", Formulario.obterFormularios());

            RequestDispatcher view = request.getRequestDispatcher("/manterRenda.jsp");
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
        int codRenda = Integer.parseInt(request.getParameter("optFormulario") + request.getParameter("txtCodRenda"));
        int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
        String qt18_Nome = request.getParameter("txt_qt18_Nome");
        String qt18_DataNasc = request.getParameter("txt_qt18_DataNasc");
        String qt18_EstadoCivil = request.getParameter("opt_qt18_EstadoCivil");
        String qt18_Parentesco = request.getParameter("txt_qt18_Parentesco");
        String qt18_Escolaridade = request.getParameter("opt_qt18_Escolaridade");
        String qt18_Trabalho = request.getParameter("opt_qt18_Trabalho");
        String qt18_Ocupacao = request.getParameter("txt_qt18_Ocupacao");
        double qt18_RendaBruta = Double.parseDouble(request.getParameter("txt_qt18_RendaBruta"));
        try{
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = Formulario.obterFormulario(codFormulario);
            }
            Renda renda = new Renda(codRenda, formulario, qt18_Nome, qt18_DataNasc, qt18_EstadoCivil, qt18_Parentesco, qt18_Escolaridade, qt18_Trabalho, qt18_Ocupacao, qt18_RendaBruta);
            renda.setCodFormulario(codFormulario);
            renda.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRendaController");
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
            request.setAttribute("formularios", Formulario.obterFormularios());
            int codRenda = Integer.parseInt(request.getParameter("codRenda"));
            Renda renda = Renda.obterRenda(codRenda);
            request.setAttribute("renda", renda);
            RequestDispatcher view = request.getRequestDispatcher("/manterRenda.jsp");
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
        int codRenda = Integer.parseInt(request.getParameter("txtCodRenda"));
        int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
        String qt18_Nome = request.getParameter("txt_qt18_Nome");
        String qt18_DataNasc = request.getParameter("txt_qt18_DataNasc");
        String qt18_EstadoCivil = request.getParameter("opt_qt18_EstadoCivil");
        String qt18_Parentesco = request.getParameter("txt_qt18_Parentesco");
        String qt18_Escolaridade = request.getParameter("opt_qt18_Escolaridade");
        String qt18_Trabalho = request.getParameter("opt_qt18_Trabalho");
        String qt18_Ocupacao = request.getParameter("txt_qt18_Ocupacao");
        double qt18_RendaBruta = Double.parseDouble(request.getParameter("txt_qt18_RendaBruta"));
        try{
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = Formulario.obterFormulario(codFormulario);
            }
            Renda renda = new Renda(codRenda, formulario, qt18_Nome, qt18_DataNasc, qt18_EstadoCivil, qt18_Parentesco, qt18_Escolaridade, qt18_Trabalho, qt18_Ocupacao, qt18_RendaBruta);
            renda.setCodFormulario(codFormulario);
            renda.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRendaController");
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

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("formularios", Formulario.obterFormularios());
            int codRenda = Integer.parseInt(request.getParameter("codRenda"));
            Renda renda = Renda.obterRenda(codRenda);
            request.setAttribute("renda", renda);
            RequestDispatcher view = request.getRequestDispatcher("/manterRenda.jsp");
            view.forward(request, response);   
        } catch(ServletException ex){
            throw ex;
        } catch(IOException ex){
            throw new ServletException(ex);
        } catch(ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int codRenda = Integer.parseInt(request.getParameter("txtCodRenda"));
        int codFormulario = Integer.parseInt(request.getParameter("optFormulario"));
        String qt18_Nome = request.getParameter("txt_qt18_Nome");
        String qt18_DataNasc = request.getParameter("txt_qt18_DataNasc");
        String qt18_EstadoCivil = request.getParameter("opt_qt18_EstadoCivil");
        String qt18_Parentesco = request.getParameter("txt_qt18_Parentesco");
        String qt18_Escolaridade = request.getParameter("opt_qt18_Escolaridade");
        String qt18_Trabalho = request.getParameter("opt_qt18_Trabalho");
        String qt18_Ocupacao = request.getParameter("txt_qt18_Ocupacao");
        double qt18_RendaBruta = Double.parseDouble(request.getParameter("txt_qt18_RendaBruta"));
        try{
            Formulario formulario = null;
            if(codFormulario != 0){
                formulario = Formulario.obterFormulario(codFormulario);
            }
            Renda renda = new Renda(codRenda, formulario, qt18_Nome, qt18_DataNasc, qt18_EstadoCivil, qt18_Parentesco, qt18_Escolaridade, qt18_Trabalho, qt18_Ocupacao, qt18_RendaBruta);
            renda.setCodFormulario(codFormulario);
            renda.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaRendaController");
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
