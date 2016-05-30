package modelo;

import dao.DoencaDAO;
import dao.FormularioDAO;
import java.sql.SQLException;
import java.util.List;

public class Doenca {
    private int codDoenca;
    private Formulario formulario;
    private String qt17_Nome;
    private String qt17_Doenca;
    private String qt17_Trabalho;
    private String qt17_Dependencia;
    private double qt17_Gasto;
    
    private int codFormulario;

    public Doenca(int codDoenca, Formulario Formuario, String qt17_Nome, String qt17_Doenca, String qt17_Trabalho, String qt17_Dependencia, double qt17_Gasto) {
        this.codDoenca = codDoenca;
        this.formulario = Formuario;
        this.qt17_Nome = qt17_Nome;
        this.qt17_Doenca = qt17_Doenca;
        this.qt17_Trabalho = qt17_Trabalho;
        this.qt17_Dependencia = qt17_Dependencia;
        this.qt17_Gasto = qt17_Gasto;
    }

    public static List<Doenca> obterDoencas() throws ClassNotFoundException{
        return DoencaDAO.obterDoencas();
    }

    public static Doenca obterDoenca(int codDoenca) throws ClassNotFoundException {
        return DoencaDAO.obterDoenca(codDoenca);
    }
    
    public int getCodDoenca() {
        return codDoenca;
    }

    public void setCodDoenca(int codDoenca) {
        this.codDoenca = codDoenca;
    }

    public Formulario getFormulario() throws ClassNotFoundException {
        if ((codFormulario != 0) && (formulario == null)){
            formulario = FormularioDAO.obterFormulario(codFormulario);
        }
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public String getQt17_Nome() {
        return qt17_Nome;
    }

    public void setQt17_Nome(String qt17_Nome) {
        this.qt17_Nome = qt17_Nome;
    }

    public String getQt17_Doenca() {
        return qt17_Doenca;
    }

    public void setQt17_Doenca(String qt17_Doenca) {
        this.qt17_Doenca = qt17_Doenca;
    }

    public String getQt17_Trabalho() {
        return qt17_Trabalho;
    }

    public void setQt17_Trabalho(String qt17_Trabalho) {
        this.qt17_Trabalho = qt17_Trabalho;
    }

    public String getQt17_Dependencia() {
        return qt17_Dependencia;
    }

    public void setQt17_Dependencia(String qt17_Dependencia) {
        this.qt17_Dependencia = qt17_Dependencia;
    }

    public double getQt17_Gasto() {
        return qt17_Gasto;
    }

    public void setQt17_Gasto(double qt17_Gasto) {
        this.qt17_Gasto = qt17_Gasto;
    }

    public int getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        DoencaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DoencaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        DoencaDAO.excluir(this);
    }
}
