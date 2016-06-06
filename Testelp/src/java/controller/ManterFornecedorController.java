package controller;

import dao.FornecedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerError;
import java.rmi.ServerException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Fornecedor;

public class ManterFornecedorController extends HttpServlet {
    private Fornecedor fornecedor;
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
                int codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));
                fornecedor = FornecedorDAO.obterFornecedor(codFornecedor);
                request.setAttribute("fornecedor", fornecedor);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFornecedor.jsp");
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
            int codFornecedor = Integer.parseInt(request.getParameter("txtCodFornecedor"));
            String nome = request.getParameter("txtNome");
            String cnpj = request.getParameter("txtCNPJ");
            String telefone = request.getParameter("txtTelefone");
            String cidade = request.getParameter("txtCidade");
            if(operacao.equals("Incluir")){
                fornecedor = new Fornecedor(codFornecedor, nome, cnpj, telefone, cidade);
                FornecedorDAO.getInstance().salvar(fornecedor);
            }else if(operacao.equals("Editar")){
                fornecedor.setNome(nome);
                fornecedor.setCnpj(cnpj);
                fornecedor.setTelefone(telefone);
                fornecedor.setCidade(cidade);
                FornecedorDAO.getInstance().alterar(fornecedor);
            }else if (operacao.equals("Excluir")){
                FornecedorDAO.getInstance().excluir(fornecedor);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFornecedorController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
