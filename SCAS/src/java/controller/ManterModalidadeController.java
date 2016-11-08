package controller;

import dao.ModalidadeDAO;
import java.io.IOException;
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

public class ManterModalidadeController extends HttpServlet {

    private Modalidade modalidade;
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
                int codModalidade = Integer.parseInt(request.getParameter("codModalidade"));
                modalidade = ModalidadeDAO.obterModalidade(codModalidade);
                request.setAttribute("modalidade", modalidade);
                try {
                    impostos(request, response, codModalidade);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ManterModalidadeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterModalidade.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
            throw ex;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
    
    public void impostos(HttpServletRequest request, HttpServletResponse response, int codModalidade) throws ClassNotFoundException{
        
        List<Modalidade> modal = Modalidade.obterModalidades();
        double valor = 0;
        for (Modalidade m : modal) {
            if(m.getCodModalidade() == codModalidade){
                valor = m.getValorMensal();
                break;
            }
        } 
        request.setAttribute("imposto", modalidade.calculaImposto(valor));
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String operacao = request.getParameter("operacao");
            int codModalidade = Integer.parseInt(request.getParameter("txtCodModalidade"));
            float valorMensal = Float.parseFloat(request.getParameter("txtValorMensal"));
            String nome = request.getParameter("txtNomeModalidade");
            String descricao = request.getParameter("txtDescricaoModalidade"); 
            if(operacao.equals("Incluir")){
                modalidade = new Modalidade(codModalidade, valorMensal, nome, descricao);
                ModalidadeDAO.getInstance().gravar(modalidade);
            }else if(operacao.equals("Editar")){
                modalidade.setValorMensal(valorMensal);
                modalidade.setNome(nome);
                modalidade.setDescricao(descricao);
                ModalidadeDAO.getInstance().alterar(modalidade);
            }else if (operacao.equals("Excluir")){
                ModalidadeDAO.getInstance().excluir(modalidade);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaModalidadeController");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}
