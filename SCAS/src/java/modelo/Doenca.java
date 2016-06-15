package modelo;

import dao.DoencaDAO;
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
@Table(name = "doenca")
public class Doenca implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOENCA_ID", nullable = false)
    private Integer codDoenca;
    @JoinColumn(name = "FORMULARIO_ID", referencedColumnName = "FORMULARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Formulario formulario;
    @Size(max = 45)
    @Column(name = "QT17_NOME", length = 45)
    private String qt17_Nome;
    @Size(max = 45)
    @Column(name = "QT17_DOENCA", length = 45)
    private String qt17_Doenca;
    @Size(max = 45)
    @Column(name = "QT17_TRABALHO", length = 45)
    private String qt17_Trabalho;
    @Size(max = 45)
    @Column(name = "QT17_DEPENDENCIA", length = 45)
    private String qt17_Dependencia;
    @Column(name = "QT17_GASTO")
    private float qt17_Gasto;
    
    public Doenca(){
    }

    public static List<Doenca> obterDoencas() throws ClassNotFoundException{
        return DoencaDAO.obterDoencas();
    }

    public static Doenca obterDoenca(int codDoenca) throws ClassNotFoundException {
        return DoencaDAO.obterDoenca(codDoenca);
    }
    
    public Doenca(Integer codDoenca, Formulario Formuario, String qt17_Nome, String qt17_Doenca, String qt17_Trabalho, String qt17_Dependencia, float qt17_Gasto) {
        this.codDoenca = codDoenca;
        this.formulario = Formuario;
        this.qt17_Nome = qt17_Nome;
        this.qt17_Doenca = qt17_Doenca;
        this.qt17_Trabalho = qt17_Trabalho;
        this.qt17_Dependencia = qt17_Dependencia;
        this.qt17_Gasto = qt17_Gasto;
    }
    
    public Integer getCodDoenca() {
        return codDoenca;
    }

    public void setCodDoenca(Integer codDoenca) {
        this.codDoenca = codDoenca;
    }

    public Formulario getFormulario(){
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

    public float getQt17_Gasto() {
        return qt17_Gasto;
    }

    public void setQt17_Gasto(float qt17_Gasto) {
        this.qt17_Gasto = qt17_Gasto;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDoenca != null ? codDoenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doenca)) {
            return false;
        }
        Doenca other = (Doenca) object;
        if ((this.codDoenca == null && other.codDoenca != null) || (this.codDoenca != null && !this.codDoenca.equals(other.codDoenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Doenca[ id=" + codDoenca + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        DoencaDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DoencaDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        DoencaDAO.getInstance().excluir(this);
    }
}
