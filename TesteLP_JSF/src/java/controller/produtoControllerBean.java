package controller;

import dao.ProdutoDAO;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;


@ManagedBean
@RequestScoped
public class produtoControllerBean {
    
    private Produto produto;
    private List<Produto> listaProduto;
    private String operacao;
    
    @PostConstruct
    public void init(){
        this.produto = new Produto();
        this.listaProduto = ProdutoDAO.obterProdutos();
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.operacao = params.get("operacao");
    }
    
    public String manterProduto(String operacao, Produto p){
        if(!operacao.equals("Incluir") && p != null){
            this.produto = p;
        }
        this.operacao = operacao;
        return "manageProduto";
    }
    
    public String confirmarOperacao(){
        ProdutoDAO.getInstance().operacao(produto, operacao, produto.getId());
        if(!operacao.equals("Excluir")){
            this.produto = new Produto();
        }
        this.listaProduto = ProdutoDAO.obterProdutos();
        return "produto";
    }
    
    //Geters and Seters

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
