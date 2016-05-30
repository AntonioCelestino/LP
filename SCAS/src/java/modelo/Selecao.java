package modelo;

import dao.ModalidadeDAO;
import dao.SelecaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Selecao {
    private int codSelecao;
    private String dataInicioSelecao;
    private String dataFimSelecao;
    private String numeroEdital;
    
    private Modalidade modalidade;
    
    private int codModalidade;

    public Selecao(int codSelecao, String dataInicioSelecao, String dataFimSelecao, String numeroEdital, Modalidade modalidade) {
        this.codSelecao = codSelecao;
        this.dataInicioSelecao = dataInicioSelecao;
        this.dataFimSelecao = dataFimSelecao;
        this.numeroEdital = numeroEdital;
        this.modalidade = modalidade;
    }
    
    public static List<Selecao> obterSelecoes() throws ClassNotFoundException{
        return SelecaoDAO.obterSelecoes();
    }

    public static Selecao obterSelecao(int codSelecao) throws ClassNotFoundException{
        return SelecaoDAO.obterSelecao(codSelecao);
    }

    public int getCodSelecao() {
        return codSelecao;
    }

    public void setCodSelecao(int codSelecao) {
        this.codSelecao = codSelecao;
    }

    public int getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(int codModalidade) {
        this.codModalidade = codModalidade;
    }

    public String getDataInicioSelecao() {
        return dataInicioSelecao;
    }

    public void setDataInicioSelecao(String dataInicioSelecao) {
        this.dataInicioSelecao = dataInicioSelecao;
    }

    public String getDataFimSelecao() {
        return dataFimSelecao;
    }

    public void setDataFimSelecao(String dataFimSelecao) {
        this.dataFimSelecao = dataFimSelecao;
    }

    public String getNumeroEdital() {
        return numeroEdital;
    }

    public void setNumeroEdital(String numeroEdital) {
        this.numeroEdital = numeroEdital;
    }

    public Modalidade getModalidade() throws ClassNotFoundException {
        if ((codModalidade != 0) && (modalidade == null)) {
            modalidade = ModalidadeDAO.obterModalidade(codModalidade);
        }
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        SelecaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        SelecaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        SelecaoDAO.excluir(this);
    }
    
}
