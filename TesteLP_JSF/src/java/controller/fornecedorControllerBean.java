package controller;

import dao.FornecedorDAO;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Fornecedor;


@ManagedBean
@SessionScoped
public class fornecedorControllerBean {
    
    private Fornecedor fornecedor;
    private List<Fornecedor> listaFornecedor;
    private String operacao;
    
    @PostConstruct
    public void init(){
        this.fornecedor = new Fornecedor();
        this.listaFornecedor = FornecedorDAO.obterFornecedores();
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.operacao = params.get("operacao");
    }
    
    public String manterFornecedor(String operacao, Fornecedor f){
        if(!operacao.equals("Incluir") && f != null){
            this.fornecedor = f;
        }
        this.operacao = operacao;
        return "manageFornecedor";
    }
    
    public String confirmarOperacao(){
        FornecedorDAO.getInstance().operacao(fornecedor, operacao, fornecedor.getId());
        if(!operacao.equals("Excluir")){
            this.fornecedor = new Fornecedor();
        }
        this.listaFornecedor = FornecedorDAO.obterFornecedores();
        return "fornecedor";
    }
    
    //Geters and Seters

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }
    
    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
