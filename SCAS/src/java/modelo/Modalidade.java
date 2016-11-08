package modelo;

import dao.ModalidadeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "modalidade")
public class Modalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "MODALIDADE_ID", nullable = false)
    private Integer codModalidade;
    @Column(name = "VALOR_MENSAL")
    private float valorMensal;
    @Column(name = "NOME", length = 45)
    private String nome;
    @Size(max = 45)
    @Column(name = "DESCRICAO", length = 45)
    private String descricao;
    
    public Modalidade(){
    }
    
    public static List<Modalidade> obterModalidades() throws ClassNotFoundException{
        return ModalidadeDAO.obterModalidades();
    }
    
    public static Modalidade obterModalidade(int codModalidade) throws ClassNotFoundException{
        return ModalidadeDAO.obterModalidade(codModalidade);
    }

    public Modalidade(Integer codModalidade, float valorMensal, String nome, String descricao) {
        this.codModalidade = codModalidade;
        this.valorMensal = valorMensal;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(Integer codModalidade) {
        this.codModalidade = codModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(float valorMensal) {
        this.valorMensal = valorMensal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double calculaImposto(double valor){
        double taxa;
        if(valor < 100){//1
            taxa = 0;//2
        }else if(valor < 200){//3
            taxa = 0.05;//4
        }else if(valor < 300){//5
            taxa = 0.1;//6
        }else if(valor < 400){//7
            taxa = 0.15;//8
        }else if(valor < 500){//9
            taxa = 0.17;//10
        }else if(valor < 600){//11
            taxa = 0.19;//12
        }else if(valor < 700){//13
            taxa = 0.21;//14
        }else if(valor < 800){//15
            taxa = 0.23;//16
        }else if(valor < 900){//17
            taxa = 0.25;//18
        }else if(valor < 1000){//19
            taxa = 0.27;//20
        }else{
            taxa = 0.3;//21
        }
        return valor * taxa;//22
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModalidade != null ? codModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidade)) {
            return false;
        }
        Modalidade other = (Modalidade) object;
        if ((this.codModalidade == null && other.codModalidade != null) || (this.codModalidade != null && !this.codModalidade.equals(other.codModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Modalidade[ id=" + codModalidade + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ModalidadeDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        ModalidadeDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        ModalidadeDAO.getInstance().excluir(this);
    }
    
}

