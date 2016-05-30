package modelo;

import dao.ModalidadeDAO;
import dao.RecursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Recurso {
    
    private int codRecurso;
    private int ano;
    private double creditos;
    private double debitos;
    private double saldo;
    
    private Modalidade modalidade;
    
    private int codModalidade;

    public Recurso(int codRecurso, int ano, double creditos, double debitos, double saldo, Modalidade modalidade) {
        this.codRecurso = codRecurso;
        this.ano = ano;
        this.creditos = creditos;
        this.debitos = debitos;
        this.saldo = saldo;
        this.modalidade = modalidade;
    }
    
    
    public static List<Recurso> obterRecursos() throws ClassNotFoundException{
        return RecursoDAO.obterRecursos();
    }
    
    public static Recurso obterRecurso(int codRecurso) throws ClassNotFoundException {
        return RecursoDAO.obterRecurso(codRecurso);
    }

    public int getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(int codRecurso) {
        this.codRecurso = codRecurso;
    }

    public int getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(int codModalidade) {
        this.codModalidade = codModalidade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public double getDebitos() {
        return debitos;
    }

    public void setDebitos(double debitos) {
        this.debitos = debitos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
        RecursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        RecursoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        RecursoDAO.excluir(this);
    }
    
}
