package modelo;

import dao.FuncionarioDAO;
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
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGISTRO", nullable = false)
    private Integer registro;
    @Size(max = 45)
    @Column(name = "CARGO", length = 45)
    private String cargo;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Funcionario(){
    }
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException{
        return FuncionarioDAO.obterFuncionarios();
    }
    
    public static  Funcionario obterFuncionario(int registro) throws ClassNotFoundException{
        return FuncionarioDAO.obterFuncionario(registro);
    }
    
    public Funcionario(Integer registro, String cargo, Usuario usuario) {
        this.registro = registro;
        this.cargo = cargo;
        this.usuario = usuario;
    }
    
    public Integer getRegistro() {
        return registro;
    }
    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public Usuario getUsuario() throws ClassNotFoundException {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registro != null ? registro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.registro == null && other.registro != null) || (this.registro != null && !this.registro.equals(other.registro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funcionario[ id=" + registro + " ]";
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FuncionarioDAO.getInstance().gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.getInstance().alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.getInstance().excluir(this);
    }
    
}
