package modelo;

import dao.BolsaDAO;
import java.io.Serializable;
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
@Table(name = "bolsa")
public class Bolsa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOLSA_ID", nullable = false)
    private Integer codBolsa;
    @Size(max = 10)
    @Column(name = "DT_INICIO", length = 10)
    private String dataInicio;
    @Size(max = 10)
    @Column(name = "DT_FIM", length = 10)
    private String dataFim;
    @JoinColumn(name = "FORMULARIO_ID", referencedColumnName = "FORMULARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Formulario formulario;
    
    public Bolsa(){
    }
    
    public static List<Bolsa> obterBolsas() throws ClassNotFoundException{
        return BolsaDAO.obterBolsas();
    }

    public static Bolsa obterBolsa(int codBolsa) throws ClassNotFoundException {
        return (Bolsa) BolsaDAO.getInstance().obterClasse(Bolsa.class, codBolsa);
    }
    
    public Bolsa(Integer codBolsa, String dataInicio, String dataFim, Formulario formulario) {
        this.codBolsa = codBolsa;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.formulario = formulario;
    }

    public Integer getCodBolsa() {
        return codBolsa;
    }

    public void setCodBolsa(Integer codBolsa) {
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
    
    public Formulario getFormulario(){
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBolsa != null ? codBolsa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolsa)) {
            return false;
        }
        Bolsa other = (Bolsa) object;
        if ((this.codBolsa == null && other.codBolsa != null) || (this.codBolsa != null && !this.codBolsa.equals(other.codBolsa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Bolsa[ id=" + codBolsa + " ]";
    }    
}
