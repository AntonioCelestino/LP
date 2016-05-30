package modelo;

import dao.RendaDAO;
import dao.FormularioDAO;
import java.sql.SQLException;
import java.util.List;

public class Renda {
    private int codRenda;
    private Formulario formulario;
    private String qt18_Nome;
    private String qt18_DataNasc;
    private String qt18_EstadoCivil;
    private String qt18_Parentesco;
    private String qt18_Escolaridade;
    private String qt18_Trabalho;
    private String qt18_Ocupacao;
    private double qt18_RendaBruta;
    
    private int codFormulario;

    public Renda(int codRenda, Formulario formulario, String qt18_Nome, String qt18_DataNasc, String qt18_EstadoCivil, String qt18_Parentesco, String qt18_Escolaridade, String qt18_Trabalho, String qt18_Ocupacao, double qt18_RendaBruta) {
        this.codRenda = codRenda;
        this.formulario = formulario;
        this.qt18_Nome = qt18_Nome;
        this.qt18_DataNasc = qt18_DataNasc;
        this.qt18_EstadoCivil = qt18_EstadoCivil;
        this.qt18_Parentesco = qt18_Parentesco;
        this.qt18_Escolaridade = qt18_Escolaridade;
        this.qt18_Trabalho = qt18_Trabalho;
        this.qt18_Ocupacao = qt18_Ocupacao;
        this.qt18_RendaBruta = qt18_RendaBruta;
    }

    public static List<Renda> obterRendas() throws ClassNotFoundException{
        return RendaDAO.obterRendas();
    }

    public static Renda obterRenda(int codRenda) throws ClassNotFoundException {
        return RendaDAO.obterRenda(codRenda);
    }
    
    public int getCodRenda() {
        return codRenda;
    }

    public void setCodRenda(int codRenda) {
        this.codRenda = codRenda;
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

    public String getQt18_Nome() {
        return qt18_Nome;
    }

    public void setQt18_Nome(String qt18_Nome) {
        this.qt18_Nome = qt18_Nome;
    }

    public String getQt18_DataNasc() {
        return qt18_DataNasc;
    }

    public void setQt18_DataNasc(String qt18_DataNasc) {
        this.qt18_DataNasc = qt18_DataNasc;
    }

    public String getQt18_EstadoCivil() {
        return qt18_EstadoCivil;
    }

    public void setQt18_EstadoCivil(String qt18_EstadoCivil) {
        this.qt18_EstadoCivil = qt18_EstadoCivil;
    }

    public String getQt18_Parentesco() {
        return qt18_Parentesco;
    }

    public void setQt18_Parentesco(String qt18_Parentesco) {
        this.qt18_Parentesco = qt18_Parentesco;
    }

    public String getQt18_Escolaridade() {
        return qt18_Escolaridade;
    }

    public void setQt18_Escolaridade(String qt18_Escolaridade) {
        this.qt18_Escolaridade = qt18_Escolaridade;
    }

    public String getQt18_Trabalho() {
        return qt18_Trabalho;
    }

    public void setQt18_Trabalho(String qt18_Trabalho) {
        this.qt18_Trabalho = qt18_Trabalho;
    }

    public String getQt18_Ocupacao() {
        return qt18_Ocupacao;
    }

    public void setQt18_Ocupacao(String qt18_Ocupacao) {
        this.qt18_Ocupacao = qt18_Ocupacao;
    }

    public double getQt18_RendaBruta() {
        return qt18_RendaBruta;
    }

    public void setQt18_RendaBruta(double qt18_RendaBruta) {
        this.qt18_RendaBruta = qt18_RendaBruta;
    }

    public int getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        RendaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        RendaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        RendaDAO.excluir(this);
    }
}
