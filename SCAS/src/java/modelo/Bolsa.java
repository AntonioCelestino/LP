package modelo;

import dao.BolsaDAO;
import dao.FormularioDAO;
import java.sql.SQLException;
import java.util.List;

public class Bolsa {
    
    private int codBolsa;
    private String dataInicio;
    private String dataFim;
    
    private Formulario formulario;
    
    private int codFormulario;
    
    
    public Bolsa(int codBolsa, String dataInicio, String dataFim, Formulario formulario) {
        this.codBolsa = codBolsa;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.formulario = formulario;
    }
    
    public static List<Bolsa> obterBolsas() throws ClassNotFoundException{
        return BolsaDAO.obterBolsas();
    }

    public static Bolsa obterBolsa(int codBolsa) throws ClassNotFoundException {
        return BolsaDAO.obterBolsa(codBolsa);
    }

    public int getCodBolsa() {
        return codBolsa;
    }

    public void setCodBolsa(int codBolsa) {
        this.codBolsa = codBolsa;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
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
    
    public void gravar() throws SQLException, ClassNotFoundException {
        BolsaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        BolsaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        BolsaDAO.excluir(this);
    }
    
}
