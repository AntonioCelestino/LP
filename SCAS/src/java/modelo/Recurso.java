package modelo;

import dao.RecursoDAO;
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

@Entity
@Table(name = "recurso")
public class Recurso implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECURSO_ID", nullable = false)
    private Integer codRecurso;
    @Column(name = "ANO")
    private Integer ano;
    @Column(name = "CREDITOS")
    private float creditos;
    @Column(name = "DEBITOS")
    private float debitos;
    @Column(name = "SALDO")
    private float saldo;
    @JoinColumn(name = "MODALIDADE_ID", referencedColumnName = "MODALIDADE_ID", nullable = false)
    @ManyToOne(optional = false)
    private Modalidade modalidade;
    
    public Recurso(){
    }
    
    public static List<Recurso> obterRecursos() throws ClassNotFoundException{
        return RecursoDAO.obterRecursos();
    }
    
    public static Recurso obterRecurso(int codRecurso) throws ClassNotFoundException {
        return RecursoDAO.obterRecurso(codRecurso);
    }

    public Recurso(Integer codRecurso, Integer ano, float creditos, float debitos, float saldo, Modalidade modalidade) {
        this.codRecurso = codRecurso;
        this.ano = ano;
        this.creditos = creditos;
        this.debitos = debitos;
        this.saldo = saldo;
        this.modalidade = modalidade;
    }

    public Integer getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(Integer codRecurso) {
        this.codRecurso = codRecurso;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public float getDebitos() {
        return debitos;
    }

    public void setDebitos(float debitos) {
        this.debitos = debitos;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public Modalidade getModalidade(){
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRecurso != null ? codRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.codRecurso == null && other.codRecurso != null) || (this.codRecurso != null && !this.codRecurso.equals(other.codRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Recurso[ id=" + codRecurso + " ]";
    }
}
