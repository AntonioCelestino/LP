package modelo;

import dao.SelecaoDAO;
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
@Table(name = "selecao")
public class Selecao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SELECAO_ID", nullable = false)
    private Integer codSelecao;
    @Size(max = 45)
    @Column(name = "DT_INICIO_INSCRICAO", length = 45)
    private String dataInicioSelecao;
    @Size(max = 45)
    @Column(name = "DT_FIM_INSCRICAO", length = 45)
    private String dataFimSelecao;
    @Size(max = 45)
    @Column(name = "NUM_EDITAL", length = 45)
    private String numeroEdital;
    @JoinColumn(name = "MODALIDADE_ID", referencedColumnName = "MODALIDADE_ID", nullable = false)
    @ManyToOne(optional = false)
    private Modalidade modalidade;
    
    public Selecao(){
    }

    public static List<Selecao> obterSelecoes() throws ClassNotFoundException{
        return SelecaoDAO.obterSelecoes();
    }

    public static Selecao obterSelecao(int codSelecao) throws ClassNotFoundException{
        return (Selecao) SelecaoDAO.getInstance().obterClasse(Selecao.class, codSelecao);
    }

    public Integer getCodSelecao() {
        return codSelecao;
    }

    public void setCodSelecao(Integer codSelecao) {
        this.codSelecao = codSelecao;
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

    public Modalidade getModalidade(){
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSelecao != null ? codSelecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selecao)) {
            return false;
        }
        Selecao other = (Selecao) object;
        if ((this.codSelecao == null && other.codSelecao != null) || (this.codSelecao != null && !this.codSelecao.equals(other.codSelecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Selecao[ id=" + codSelecao + " ]";
    }
}
