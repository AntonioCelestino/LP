package modelo;

import dao.ModalidadeDAO;
import java.sql.SQLException;
import java.util.List;

public class Modalidade {
    private int codModalidade;
    private String nome;
    private double valorMensal;
    private String descricao;

    public Modalidade(int codModalidade, String nome, double valorMensal, String descricao) {
        this.codModalidade = codModalidade;
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.descricao = descricao;
    }
    
    public static List<Modalidade> obterModalidades() throws ClassNotFoundException{
        return ModalidadeDAO.obterModalidades();
    }
    
    public static Modalidade obterModalidade(int codModalidade) throws ClassNotFoundException{
        return ModalidadeDAO.obterModalidade(codModalidade);
    }

    public int getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(int codModalidade) {
        this.codModalidade = codModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ModalidadeDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        ModalidadeDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        ModalidadeDAO.excluir(this);
    }
    
}

