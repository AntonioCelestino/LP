package modelo;

import dao.RendaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "renda")
public class Renda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENDA_ID", nullable = false)
    private Integer codRenda;
    @JoinColumn(name = "FORMULARIO_ID", referencedColumnName = "FORMULARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Formulario formulario;
    @Size(max = 45)
    @Column(name = "QT18_NOME", length = 45)
    private String qt18_Nome;
    @Size(max = 45)
    @Column(name = "QT18_DATA_NASC", length = 45)
    private String qt18_DataNasc;
    @Size(max = 45)
    @Column(name = "QT18_ESTADO_CIVIL", length = 45)
    private String qt18_EstadoCivil;
    @Size(max = 45)
    @Column(name = "QT18_PARENTESCO", length = 45)
    private String qt18_Parentesco;
    @Size(max = 45)
    @Column(name = "QT18_ESCOLARIDADE", length = 45)
    private String qt18_Escolaridade;
    @Size(max = 45)
    @Column(name = "QT18_TRABALHO", length = 45)
    private String qt18_Trabalho;
    @Size(max = 45)
    @Column(name = "QT18_OCUPACAO", length = 45)
    private String qt18_Ocupacao;
    @Column(name = "QT18_RENDA_BRUTA")
    private float qt18_RendaBruta;
    
    public Renda(){
    }

    public static List<Renda> obterRendas() throws ClassNotFoundException{
        return RendaDAO.obterRendas();
    }

    public static Renda obterRenda(int codRenda) throws ClassNotFoundException {
        return RendaDAO.obterRenda(codRenda);
    }
    
    public Renda(Integer codRenda, Formulario formulario, String qt18_Nome, String qt18_DataNasc, String qt18_EstadoCivil, String qt18_Parentesco, String qt18_Escolaridade, String qt18_Trabalho, String qt18_Ocupacao, float qt18_RendaBruta) {
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
    
    public Integer getCodRenda() {
        return codRenda;
    }

    public void setCodRenda(Integer codRenda) {
        this.codRenda = codRenda;
    }

    public Formulario getFormulario(){
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

    public float getQt18_RendaBruta() {
        return qt18_RendaBruta;
    }

    public void setQt18_RendaBruta(float qt18_RendaBruta) {
        this.qt18_RendaBruta = qt18_RendaBruta;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRenda != null ? codRenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Renda)) {
            return false;
        }
        Renda other = (Renda) object;
        if ((this.codRenda == null && other.codRenda != null) || (this.codRenda != null && !this.codRenda.equals(other.codRenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Renda[ id=" + codRenda + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        RendaDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        RendaDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        RendaDAO.getInstance().excluir(this);
    }
}
