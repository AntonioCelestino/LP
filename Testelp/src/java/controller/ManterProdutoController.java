package controller;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Fornecedor;
import modelo.Produto;

public class ManterProdutoController extends ProcessRequestController {
    private Produto produto;
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
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("fornecedores", FornecedorDAO.obterFornecedores());
            if(!operacao.equals("Incluir")){
                int codProduto = Integer.parseInt(request.getParameter("codProduto"));
                produto = (Produto) ProdutoDAO.getInstance().obterClasse(Produto.class, codProduto);
                request.setAttribute("produto", produto);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterProduto.jsp");
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
            int codFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));
            if(operacao.equals("Incluir")){
                produto = new Produto();
                produto.setId(Integer.parseInt(request.getParameter("txtCodProduto")));
            }
            Fornecedor fornecedor = null;
            if(codFornecedor != 0){
                fornecedor = (Fornecedor) FornecedorDAO.getInstance().obterClasse(Fornecedor.class, codFornecedor);
            }
            produto.setNome(request.getParameter("txtNome"));
            produto.setPreco(Float.parseFloat(request.getParameter("txtPreco")));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
            produto.setFornecedorId(fornecedor);
            ProdutoDAO.getInstance().operacao(produto, operacao, produto.getId());
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
